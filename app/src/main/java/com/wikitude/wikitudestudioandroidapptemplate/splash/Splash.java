package com.wikitude.wikitudestudioandroidapptemplate.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.wikitude.wikitudestudioandroidapptemplate.App.MainActivity;
import com.wikitude.wikitudestudioandroidapptemplate.R;


public class Splash extends Activity {
    /*
    * Declaro las varibles usadas en la parte grafica
     */
    TextView nombreIStT, carrera;
    ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
        * Creas las animaciones
        *
        * */
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        /*
        * Relaciono la parte grafica con la clase
        * */
        nombreIStT = findViewById(R.id.nombreITS);
        carrera = findViewById(R.id.nombreCarrera);
        logoImageView = findViewById(R.id.logoImageView);

        /*
        * Establesco la animacion a cada cosa
        * */
        nombreIStT.setAnimation(animation2);
        carrera.setAnimation(animation2);
        logoImageView.setAnimation(animation1);

        /*
        * Cambio de actividad, le doy un tiempo y se cierra el splash
        * */
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(Splash.this, MainActivity.class);
               startActivity(intent);
               finish();
           }
       },2500);
    }
}