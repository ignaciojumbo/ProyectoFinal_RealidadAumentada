package com.wikitude.wikitudestudioandroidapptemplate.App;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wikitude.wikitudestudioandroidapptemplate.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Carrera extends Activity {

    /* DECLARO LAS VARIABLES PARA USARLAR */

    BottomAppBar bottomAppBar;
    FloatingActionButton btnHome;
    ImageView imageView;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);

        /*
        * Relaciono la parte grafica con el codigo
         */
        bottomAppBar = findViewById(R.id.bar);
        btnHome = findViewById(R.id.home);
        imageView = findViewById(R.id.mallaImg);

        /* PARA HACER ZOOM A LA IMG */
        photoViewAttacher = new PhotoViewAttacher(imageView);

        /* LE DOY LA ACCION A LOS BOTONES DEL MENU*/
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carrera.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carrera.this, RealidadAumentada.class);
                startActivity(intent);
            }
        });

        /* LE DOY LA ACCION A LOS BOTONES DEL MENU*/
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.malla) {
                    Toast.makeText(Carrera.this, "Ya estas en esta ventana", Toast.LENGTH_SHORT).show();
                }

                if (id == R.id.docente) {
                    Intent intent = new Intent(Carrera.this, Docentes.class);
                    startActivity(intent);
                    finish();
                }
                if (id == R.id.ubicacion) {
                    Intent intent = new Intent(Carrera.this, Contacto.class);
                    startActivity(intent);
                    finish();
                }
                return false;
            }
        });
    }
}