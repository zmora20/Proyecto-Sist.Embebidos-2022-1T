package com.proyecto.zaidafabricioalmacen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button goMaps;
    Button goProducts;
    Button goMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goMaps = findViewById( R.id.maps );
        goMaps.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MainActivity.this, MapView.class);
                startActivity( idk );
            }
        });

        goMembers = findViewById( R.id.member );
        goMembers.setOnClickListener( new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent idk = new Intent( MainActivity.this, Members.class);
                startActivity( idk );
            }
        });
    }
}