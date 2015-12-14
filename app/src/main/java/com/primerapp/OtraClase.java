package com.primerapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class OtraClase extends AppCompatActivity {

    public static String CLASS_TAG=OtraClase.class.getName();
    EditText regresar;
    public static String RETURN_MSG="return_msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_clase);

        regresar=(EditText)findViewById(R.id.editText_entrada);

        Log.i(CLASS_TAG,"PASE POR ONCREATE ACTIVIDAD 2");
    }

    public void onStart(){
        super.onStart();
        Log.i(CLASS_TAG, "PASE POR ONSTART ACTIVIDAD 2");

    }

    public void onResume(){
        super.onResume();
        Log.i(CLASS_TAG, "PASE POR ONRESUME ACTIVIDAD 2");

    }



    private void rutinaRegreso() {

       String mensaje=regresar.getText().toString();
      // Toast.makeText(getApplicationContext(),"LO QUE SE ESCRIBIO FUE:"+mensaje,Toast.LENGTH_LONG).show();
       Log.i(CLASS_TAG, "rutinaRegreso   " + mensaje);
       regresar.setText("");
        if(mensaje!=null&& mensaje!="") {
            Intent regreso = new Intent();
            regreso.putExtra(RETURN_MSG, mensaje);
            setResult(Activity.RESULT_OK, regreso);
            OtraClase.this.finish();
        }else{
            Toast.makeText(getApplicationContext(),"EL MENSAJE ESTA VACIO"+mensaje,Toast.LENGTH_LONG).show();
            Log.i(CLASS_TAG, "EL MENSAJE ESTA VACIO");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_otra_clase, menu);
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

            rutinaRegreso();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
