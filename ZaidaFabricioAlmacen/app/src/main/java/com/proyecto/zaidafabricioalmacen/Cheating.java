package com.proyecto.zaidafabricioalmacen;

import static com.proyecto.zaidafabricioalmacen.MainActivity.context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.proyecto.Clases.Stand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class Cheating extends AppCompatActivity
{
    public static String connectionStatus = "Estado: Sin Conexion";

//    private Button refresh;
    private FloatingActionButton refresh;

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheating);


        initializeData();

        refresh = (FloatingActionButton) findViewById( R.id.refresh );
        refresh.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                initializeData();
            }
        });
    }

    public void initializeData()
    {
        String[] estantes = new String[6];
        estantes[0] = "A";
        estantes[1] = "B";
        estantes[2] = "C";
        estantes[3] = "D";
        estantes[4] = "E";
        estantes[5] = "F";

//        for( String s: estantes )
        for ( int x = 0; x < estantes.length; x++ )
        {
            loadData( "http://" + MapView.ip + ":" + MapView.port + "/Control_Almacen_Channel/Look_For_Products.php?id=" + estantes[x] );
        }

        TextView standTextTile = (TextView) findViewById( R.id.standTitle );
        String newMsjA = "Estadisticas de Productos";
        standTextTile.setText( newMsjA );

        TextView standTextContent = (TextView) findViewById( R.id.content );
        standTextContent.setText( MainActivity.productMsj );

        TextView textConnection = (TextView) findViewById( R.id.connectionVer );
        String newMsjC = connectionStatus;
        textConnection.setText( newMsjC );

        MainActivity.productMsj = "";
    }

    public void loadData(String URL)
    {
        JsonArrayRequest idk = new JsonArrayRequest(URL, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                JSONObject answer = null;
                for( int x = 0; x < response.length(); x++ )
                {
                    try
                    {
                        Cheating.connectionStatus = "Conectado :)";
                        answer = response.getJSONObject(x);
                        String tempMsj = "Producto: " + answer.getString("product") + "\n\tID del estante : " + answer.getString("id") + "\n\tCantidad: " + answer.getString("quantity") + "\n\n";
                        MainActivity.productMsj += tempMsj;
                    }
                    catch (JSONException e)
                    {

                    }
                }
            };
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( idk );
    }
}