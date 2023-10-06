package com.example.act7_listview_marcos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ArrayList<String> names;
    private Button btnSumar;
    private EditText etN1, etN2;
    private ListView listview;

    private int n1, n2, sumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.lvNombres); // Mandamos a traer nuesta ListView
        btnSumar = findViewById(R.id.btnSumar);

        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);

        names = new ArrayList<String>();
        btnSumar.setOnClickListener(this);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String textN1 = etN1.getText().toString();
        String textN2 = etN2.getText().toString();

        n1 = Integer.parseInt(textN1);
        n2 = Integer.parseInt(textN2);
        sumar = n1 + n2;

        if(view.getId() == R.id.btnSumar) {
            names.add(n1 + " + " + n2 + " = " + sumar);
            // estoy actualizando la lista cada vez que el boton es precionado
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
            listview.setAdapter(adapter);

            etN1.setText(""); // limpio las cajas de texto
            etN2.setText("");
            etN1.requestFocus(); // dejo el cursor en el la primera caja de texto
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), names.get(i) , Toast.LENGTH_SHORT).show();
    }
}