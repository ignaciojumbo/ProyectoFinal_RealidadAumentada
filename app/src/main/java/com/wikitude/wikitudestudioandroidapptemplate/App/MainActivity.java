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
import com.wikitude.wikitudestudioandroidapptemplate.RuntimePermissionRequestActivity;

public class MainActivity extends Activity {

    /* Declaro las varibles usadas en la parte grafica */
    BottomAppBar bottomAppBar;
    FloatingActionButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* RELACIONO CON LA PARTE GRAFICA CON LA CLASE*/
        bottomAppBar = findViewById(R.id.bar);
        btnHome = findViewById(R.id.home);

        /* LE DOY LA ACCION A LOS BOTONES PARA PODER NAVEGAR*/
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ya estas en esta ventana", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RealidadAumentada.class);
                startActivity(intent);
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.malla){
                    Intent intent = new Intent(MainActivity.this, Carrera.class);
                    startActivity(intent);

                }

                if(id == R.id.docente){
                    Intent intent = new Intent(MainActivity.this, Docentes.class);
                    startActivity(intent);

                }
                if(id == R.id.ubicacion){
                    Intent intent = new Intent(MainActivity.this, Contacto.class);
                    startActivity(intent);

                }
                return false;
            }
        });
    }
}