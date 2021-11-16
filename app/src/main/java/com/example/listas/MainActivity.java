package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] elementos = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
                "Sabado", "Domingo"};

        //Adaptador que hace de puente entre el widget y los datos

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos el objeto ListView y lo enlazamos el control del xml
        ListView lista = (ListView) findViewById(R.id.listView);
        //Creamos el adaptador pasando como parámetro this(esta actividad)

        //El array que contiene los elementos que va a mostrar
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.lista,elementos);
        //Asociamos el adaptador con la lista
        lista.setAdapter(adaptador);
        //Fijamos el listener de la lista para saber que ha pulsado el usuario
        lista.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> a, View view, int position, long id) {
        //Enlazamos con el textView que nos muestra información en la aplicación
        TextView t = (TextView) findViewById(R.id.textView2);
        //Escribe en el textView la información del elemento clicado.
        t.setText("Has elegido: " + a.getItemAtPosition(position).toString());
    }
}
