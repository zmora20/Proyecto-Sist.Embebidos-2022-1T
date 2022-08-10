package com.proyecto.zaidafabricioalmacen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapView extends AppCompatActivity
{
    @SuppressLint("WrongViewCast")
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
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });

        stand_B.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });

        stand_C.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });

        stand_D.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });

        stand_E.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });

        stand_F.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MapView.this, Cheating.class);
                startActivity( idk );
            }
        });



    }
}