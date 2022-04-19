package com.wikitude.wikitudestudioandroidapptemplate.App;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wikitude.wikitudestudioandroidapptemplate.R;

public class Contacto extends Activity {
    BottomAppBar bottomAppBar;
    FloatingActionButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        bottomAppBar = findViewById(R.id.bar);
        btnHome = findViewById(R.id.home);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contacto.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contacto.this, RealidadAumentada.class);
                startActivity(intent);
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.malla){
                    Intent intent = new Intent(Contacto.this, Carrera.class);
                    startActivity(intent);
                    finish();

                }

                if(id == R.id.docente){
                    Intent intent = new Intent(Contacto.this, Docentes.class);
                    startActivity(intent);
                    finish();

                }
                if(id == R.id.ubicacion){
                    Toast.makeText(Contacto.this, "Ya estas en esta ventana", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}