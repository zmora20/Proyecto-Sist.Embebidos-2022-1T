package com.proyecto.zaidafabricioalmacen;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.Clases.Stand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class MapView extends AppCompatActivity
{
    public static String ip = "Default";
    public static String port = "8080";

    public static String connectionStatus = "Estado: Conectado";

    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Button stand_A;
        Button stand_B;
        Button stand_C;
        Button stand_D;
        Button stand_E;
        Button stand_F;

        Button theDeposit;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        stand_A = findViewById( R.id.standA );
        stand_B = findViewById( R.id.standB );
        stand_C = findViewById( R.id.standC );
        stand_D = findViewById( R.id.standD );
        stand_E = findViewById( R.id.standE );
        stand_F = findViewById( R.id.standF );

        stand_A.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=A");

                setContent();
            }
        });

        stand_B.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=B");

                setContent();
            }
        });

        stand_C.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=C");

                setContent();
            }
        });

        stand_D.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=D");

                setContent();
            }
        });

        stand_E.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=E");

                setContent();
            }
        });

        stand_F.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                loadData("http://" + ip + ":" + port + "/Control_Almacen_Channel/Look_For_Products.php?id=F");

                setContent();
            }
        });
    }

    public void loadData(String URL)
    {
        JsonArrayRequest idk = new JsonArrayRequest(URL, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                Cheating.connectionStatus = "Estado: ";
                JSONObject answer = null;
                for( int x = 0; x < response.length(); x++ )
                {
                    try
                    {
                        Cheating.connectionStatus = Cheating.connectionStatus + "Conectado :)";
                        answer = response.getJSONObject(x);
                        MainActivity.theOnlyStand.restoreSavedData( "" + answer.getString("product") + Stand.separator + answer.getString("quantity") + Stand.separator + answer.getString("scanDate") + Stand.separator + answer.getString("scans") + Stand.separator + answer.getString("fills") + Stand.separator + answer.getString("id"));
                        MainActivity.theOnlyStand.changeStatus( answer.getString("status") );
                    }
                    catch (JSONException | ParseException e)
                    {

                    }
                }
            };
        },new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Cheating.connectionStatus = "";
                Cheating.connectionStatus = Cheating.connectionStatus + "Todo lo que pudo salir mal, salio mal\n" + "Intenta cambiando la IP puesto que: '" + ip + "' no existe";
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add( idk );
    }

    private void setContent()
    {
        TextView standTextTile = (TextView) findViewById( R.id.standTitle2 );
        String newMsjA = getString( R.string.stringStand ) + " " + MainActivity.theOnlyStand.getID();
        standTextTile.setText( newMsjA );

        String msj = MainActivity.theOnlyStand.getText();
        TextView standTextContent = (TextView) findViewById( R.id.content2 );
        standTextContent.setText( msj );

        TextView textConnection = (TextView) findViewById( R.id.connectionVer2 );
        String newMsjC = connectionStatus;
        textConnection.setText( newMsjC );
    }
}