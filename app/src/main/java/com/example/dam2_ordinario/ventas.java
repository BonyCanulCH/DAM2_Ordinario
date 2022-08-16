package com.example.dam2_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ventas extends AppCompatActivity {
    Button revisarBD;
    TextView mostrarInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        revisarBD = (Button) findViewById(R.id.btQuery);
        mostrarInfo = (TextView) findViewById(R.id.impRows);

        revisarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchData();
            }
        });
    }

    private void searchData(){
        BDOrdSQLiteAdmin ordBD = new BDOrdSQLiteAdmin(this, "OrdinarioBD", null, 1);
        SQLiteDatabase baseDatos = ordBD.getReadableDatabase();

        try{
            Cursor cursor = baseDatos.rawQuery("SELECT * FROM productos", null);
            String i="";
            while (cursor.moveToNext()){
                i+="Nombre :"+cursor.getString(1)+"\nPrecio:"+cursor.getString(2)+"\nCantidad:"+cursor.getString(3)+"\nImagen:"+cursor.getString(4)+"\n \n";
            }

            cursor.close();
            mostrarInfo.setText(i);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Falla"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}