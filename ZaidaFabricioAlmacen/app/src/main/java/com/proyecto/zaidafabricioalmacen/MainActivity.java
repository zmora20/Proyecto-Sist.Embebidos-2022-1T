package com.proyecto.zaidafabricioalmacen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyecto.Clases.OptimizedStand;
import com.proyecto.Clases.Stand;


public class MainActivity extends AppCompatActivity
{

    public final static String creator = "DFlamis";

    private Button goMaps;
    private Button goControlPanel;
    private Button goProducts;
    private Button changeIP;
    private EditText ip;

    public static Context context;

    public static String productMsj = "";

    public static Stand theOnlyStand = new Stand();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        //Something---------------------------------------------------------------------------------

        TextView msj = (TextView) findViewById( R.id.feature );
        String newMsj = getString( R.string.myCredit ) + " " + getString( R.string.creator );
        msj.setText( newMsj );

        //End of something--------------------------------------------------------------------------

        goMaps = findViewById( R.id.maps );
        goMaps.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MainActivity.this, MapView.class);
                startActivity( idk );
            }
        });

        goControlPanel = findViewById( R.id.controlPanel );
        goControlPanel.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MainActivity.this, AdvancedSettings.class);
                startActivity( idk );
            }
        });

        goProducts = findViewById( R.id.member );
        goProducts.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MainActivity.this, Cheating.class);
                startActivity( idk );
            }
        });

        changeIP = findViewById( R.id.setIP );
        changeIP.setOnClickListener( new View.OnClickListener()
    {
        public void onClick(View view)
        {
            EditText ipText = (EditText) findViewById( R.id.askIP );
            MapView.ip = ipText.getText().toString();
            String msj = "IP ajustada a: " + MapView.ip;
            Toast toast = Toast.makeText(context, msj, Toast.LENGTH_SHORT);
            toast.show();
        }
    });
    }

}