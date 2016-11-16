package com.jcapax.jcarlosporcel.testrecyclerview;

import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jcarlos.porcel on 14/11/2016.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.PersonaViewHolder> {

    List<Persona> lista;

    public Adaptador(List<Persona> lista) {
        this.lista = lista;
    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre;
        TextView txtEdad;

        public PersonaViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtEdad   = (TextView) itemView.findViewById(R.id.txtEdad);

        }
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.row_item, parent, false);

        PersonaViewHolder holder = new PersonaViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        holder.txtNombre.setText(lista.get(position).getNombre());
        holder.txtEdad.setText(Integer.toString(lista.get(position).getEdad()));
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }
}
