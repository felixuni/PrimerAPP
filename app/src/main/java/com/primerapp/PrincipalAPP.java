package com.primerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalAPP extends AppCompatActivity {

    public static String CLASS_TAG=PrincipalAPP.class.getName();
    Button ir;
    Intent voy;
    public static int INTENT_GET_MSG=1;
    public static String RETURN_MSG="return_msg";

    TextView mensajeboton,mensajeimagen;

    ImageView WS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_app);

        mensajeboton=(TextView)findViewById(R.id.textView2_datos_boton);
        mensajeimagen=(TextView)findViewById(R.id.textView2);
        WS=(ImageView)findViewById(R.id.imageView);

        ir=(Button)findViewById(R.id.button);

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voy=new Intent(PrincipalAPP.this,OtraClase.class);
                startActivityForResult(voy,INTENT_GET_MSG);


            }
        });

        WS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voy=new Intent(PrincipalAPP.this,OtraActividad.class);
                startActivity(voy);

            }
        });

        Log.i(CLASS_TAG,"PASE POR ONCREATE ACTIVIDAD 1");


    }

    public void onStart(){
        super.onStart();
        Log.i(CLASS_TAG, "PASE POR ONSTART ACTIVIDAD 1");

    }

    public void onResume(){
        super.onResume();
        Log.i(CLASS_TAG, "PASE POR ONRESUME ACTIVIDAD 1");

    }

    public void onPause(){
        super.onPause();
        Log.i(CLASS_TAG, "PASE POR ONPAUSE ACTIVIDAD 1");

    }

    public void onStop(){
        super.onStop();
        Log.i(CLASS_TAG, "PASE POR ONSTOP ACTIVIDAD 1");

    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(CLASS_TAG, "PASE POR ONDESTROY ACTIVIDAD 1");

    }

    public void onRestart(){
        super.onRestart();
        Log.i(CLASS_TAG, "PASE POR ONRESTART ACTIVIDAD 1");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal_ap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //rutina para los datos que vienen de otras actividades

    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==INTENT_GET_MSG){
            if(resultCode== Activity.RESULT_OK){

                String mensajedeRetorno=data.getStringExtra(RETURN_MSG);
                Toast.makeText(getApplicationContext(),"Mensaje: "+mensajedeRetorno,Toast.LENGTH_LONG).show();
                Log.i(CLASS_TAG, "Mensaje: "+mensajedeRetorno);
                mensajeboton.setText(mensajedeRetorno);

            }else{
                Toast.makeText(getApplicationContext(),"Error de Mensaje: ",Toast.LENGTH_LONG).show();
                mensajeboton.setText("Error");
                Log.i(CLASS_TAG, "Error");

            }


        }


    }
}
