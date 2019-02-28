package org.dgonzalo.examen_m8_dani_gonzalo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar miToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(miToolbar);
        FragmentManager fm = getSupportFragmentManager();
        MenuFragment frag = new MenuFragment();
        fm.beginTransaction().replace(R.id.fragment_container, frag).commit();
    }

    public List<Plato> mostrar_platos() {

        List<Plato> listado_platos = new ArrayList<>();


        Platos_helper dbHelper = new Platos_helper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(
                ListaPlatoDiseny.InsertPlato.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ListaPlatoDiseny.InsertPlato.COLUMNA_3 + " DESC");

        while(cursor.moveToNext()){

            Plato p = new Plato(
                    cursor.getString(cursor.getColumnIndex(ListaPlatoDiseny.InsertPlato.COLUMNA_1)),
                    cursor.getString(cursor.getColumnIndex(ListaPlatoDiseny.InsertPlato.COLUMNA_2)),
                    cursor.getString(cursor.getColumnIndex(ListaPlatoDiseny.InsertPlato.COLUMNA_3))
            );

            listado_platos.add(p);
        }

        db.close();
        return listado_platos;
    }
}
