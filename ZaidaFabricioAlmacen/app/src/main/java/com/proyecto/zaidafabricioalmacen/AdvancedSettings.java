package com.proyecto.zaidafabricioalmacen;

import static com.proyecto.zaidafabricioalmacen.MainActivity.context;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.Clases.Stand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class AdvancedSettings extends AppCompatActivity
{
    private String theID = null;

    private Button deleteData;

    private Button scan;
    private Button fill;

    private Button search;
    private Button edit;

    private RequestQueue requestQueue;

    private EditText inputID;
    private EditText inputName;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_settings);

        inputID = (EditText) findViewById( R.id.idAsker );
        inputName = (EditText) findViewById( R.id.nameAsker );

        search = findViewById( R.id.idSearcher );
        search.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                theID = inputID.getText().toString();
                loadData("http://" + MapView.ip + ":" + MapView.port + "/Control_Almacen_Channel/Look_For_Products.php?id=" + theID,context);
            }
        });

        edit = findViewById( R.id.nameChanger );
        edit.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                changeName( "http://" + MapView.ip + ":" + MapView.port + "/Control_Almacen_Channel/Edit_Name.php", context);
            }
        });

        deleteData = findViewById( R.id.reset );
        deleteData.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                resetData( "http://" + MapView.ip + ":" + MapView.port + "/Control_Almacen_Channel/Reset_Data.php", context);
            }
        });

    }

    public void changeName(String URL, Context context)
    {
        StringRequest sr = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String popMessage = "Nice";
                Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String popMessage = "Ahh... salio mal xd";
                Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_LONG);
                toast.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", inputID.getText().toString());
                parametros.put("product", inputName.getText().toString());
                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( sr );
    }

    public void resetData(String URL, Context context)
    {
        StringRequest sr = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String popMessage = "Solicitud completada";
                Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String popMessage = "Ahh... salio mal xd";
                Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_LONG);
                toast.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", inputID.getText().toString());
                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( sr );
    }

    public void loadData(String URL, Context context)
    {
        JsonArrayRequest idk = new JsonArrayRequest(URL, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                String popMessage = "";

                JSONObject answer = null;
                for( int x = 0; x < response.length(); x++ )
                {
                    try
                    {
                        popMessage = "Conectado :)";

                        Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_SHORT);
                        toast.show();

                        answer = response.getJSONObject(x);

                        TextView textConnection = (TextView) findViewById( R.id.nameAsker );
                        textConnection.setText( answer.getString("product") );
                    }
                    catch (JSONException e)
                    {
                        popMessage = "Error de conexion" + e;
                        Toast toast = Toast.makeText(context, popMessage, Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            };
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                String msj = "Intenta una ID que exista";
                Toast toast = Toast.makeText(context, msj, Toast.LENGTH_LONG);
                toast.show();            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( idk );
    }
}