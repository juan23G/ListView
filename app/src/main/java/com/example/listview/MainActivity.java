package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listview.Adapter.ContactoAdapter;
import com.example.listview.Models.Contacto;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;
    private List<Contacto> lista;
    //private SwipeRefreshLayout sflLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContactos = findViewById(R.id.listaContactos);
        //sflLista = (SwipeRefreshLayout) findViewById(R.id.sflLista);

        cargarLista();

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto item = lista.get(position);

                String leyenda = "Telefono: "+ item.getTelefono()+" - Nombre: " + item.getNombre() + ", "+item.getApellido();

                Snackbar.make(view,leyenda,Snackbar.LENGTH_SHORT).show();
            }
        });

        /*sflLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarLista();
                sflLista.setRefreshing(false);
            }
        });*/

    }

    private void cargarLista(){

        final List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(1, "juan", "cazaux", "2515", "gentilli"));
        contactos.add(new Contacto(2, "katarina", "dagas", "444", "noxus"));
        contactos.add(new Contacto(3, "rengar", "kazik", "111", "targon"));
        contactos.add(new Contacto(4, "lux", "garen", "333", "demacia"));
        contactos.add(new Contacto(5, "velkoz", "ziggs", "999", "vacio"));

        listaContactos.setAdapter(new ContactoAdapter(contactos));
    }
}