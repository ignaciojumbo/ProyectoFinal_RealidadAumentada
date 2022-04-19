package com.wikitude.wikitudestudioandroidapptemplate.App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wikitude.wikitudestudioandroidapptemplate.R;
import com.wikitude.wikitudestudioandroidapptemplate.RuntimePermissionRequestActivity;

public class RealidadAumentada extends Activity implements View.OnClickListener {

    /* DECLARO LAS VARIABLES PARA USARLAS */
    RelativeLayout mision, docentes, vision, malla, contacto;
    BottomAppBar bottomAppBar;
    FloatingActionButton btnHome;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realidad_aumentada);

        /* RELACIONO CON LA PARTE GRAFICA CON LA CLASE */
        mision = findViewById(R.id.mision);
        vision = findViewById(R.id.vision);
        docentes = findViewById(R.id.docentes);
        malla = findViewById(R.id.malla);
        contacto = findViewById(R.id.contacto);
        floatingActionButton = findViewById(R.id.btnAyudaFlotante);
        bottomAppBar = findViewById(R.id.bar);
        btnHome = findViewById(R.id.home);

        /* LE DOY LA ACCION A LOS BOTONES DEL MENU*/
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealidadAumentada.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RealidadAumentada.this, "Ya estas en esta ventana", Toast.LENGTH_SHORT).show();
            }
        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.malla){
                    Intent intent = new Intent(RealidadAumentada.this, Carrera.class);
                    startActivity(intent);
                    finish();

                }

                if(id == R.id.docente){
                    Intent intent = new Intent(RealidadAumentada.this, Docentes.class);
                    startActivity(intent);
                    finish();

                }
                if(id == R.id.ubicacion){
                    Intent intent = new Intent(RealidadAumentada.this, Contacto.class);
                    startActivity(intent);
                    finish();

                }
                return false;
            }
        });

        /* ESTABLECO LA ACCIONES DE LAS OPCIONES DE LA REALIADAD AUMENTADA */
        mision.setOnClickListener(this);
        vision.setOnClickListener(this);
        docentes.setOnClickListener(this);
        malla.setOnClickListener(this);
        contacto.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == mision){
            llamadarRealidad();
            Toast.makeText(this, "Mision", Toast.LENGTH_SHORT).show();
        }
        if(view == vision){
            llamadarRealidad();
            Toast.makeText(this, "Vision", Toast.LENGTH_SHORT).show();
        }
        if(view == docentes){
            llamadarRealidad();
            Toast.makeText(this, "Docentes", Toast.LENGTH_SHORT).show();
        }
        if(view == malla){
            llamadarRealidad();
            Toast.makeText(this, "MALLA CURRICULAR", Toast.LENGTH_SHORT).show();
        }
        if(view == contacto){
            llamadarRealidad();
            Toast.makeText(this, "CONTACTO", Toast.LENGTH_SHORT).show();
        }
        /* BOTON FLOTANTE PARA LA AYUDA EN LA REALIDAD AUMENTADA*/
        if(view == floatingActionButton){
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    RealidadAumentada.this, R.style.BottonSheetDialogTheme);
            View bottonSheetView = LayoutInflater.from(getApplicationContext())
                    .inflate(
                            R.layout.layout_botton_ayudad,
                            (LinearLayout)findViewById(R.id.bottomAyuda));

            /* ESTABLECO EL VIEW */
            bottomSheetDialog.setContentView(bottonSheetView);
            bottomSheetDialog.show();

        }
    }

    /* METODO PARA LLAMAR A LA REALIDAD AUMENTADA*/

    public void llamadarRealidad(){
        Intent intent = new Intent(RealidadAumentada.this, RuntimePermissionRequestActivity.class);
        startActivity(intent);
    }
}