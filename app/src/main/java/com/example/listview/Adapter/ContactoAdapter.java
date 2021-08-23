package com.example.listview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.Models.Contacto;
import com.example.listview.R;

import java.util.List;

public class ContactoAdapter extends BaseAdapter {

   private List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }


    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto_adapter, parent, false);

        Contacto item = (Contacto) getItem(position);

        TextView nombre = (TextView) view.findViewById(R.id.TextViewNombre);
        TextView apellido = (TextView) view.findViewById(R.id.TextViewApeliido);
        TextView direccion = (TextView) view.findViewById(R.id.TextViewDireccion);
        TextView telefono = (TextView) view.findViewById(R.id.TextViewTelefono);

        nombre.setText(item.getNombre());
        apellido.setText(item.getApellido());
        direccion.setText(item.getDireccion());
        telefono.setText(String.valueOf(item.getTelefono()));

        return view;
    }
}
