package com.aprendiz.ragp.guiaturistica.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.guiaturistica.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterMa extends RecyclerView.Adapter<AdapterMa.Holder> {
    List<Sitios> sitiosList = new ArrayList<>();
    private OnClickListener mlistener;
    public interface OnClickListener{
        void itemClick(int position);
    }

    public AdapterMa(List<Sitios> sitiosList) {
        this.sitiosList = sitiosList;
    }

    public void setMlistener(OnClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        int clistener=R.layout.item_list;
        if (Constants.mode_listener==Constants.mode_list){
            clistener=R.layout.item_list;
        }
        if (Constants.mode_listener==Constants.mode_grid){
            clistener=R.layout.item_g;
        }

        if (Constants.mode_listener==Constants.mode_land){
            clistener=R.layout.item_h;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(clistener,parent,false);
        Holder myHolder = new Holder(view,mlistener);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.connectData(sitiosList.get(position));
    }

    @Override
    public int getItemCount() {
        return sitiosList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView = itemView.findViewById(R.id.imgL);
        TextView txtnombre = itemView.findViewById(R.id.txtNombreL);
        TextView txtdescripcion = itemView.findViewById(R.id.txtDescripcionL);
        TextView txtubicacion = itemView.findViewById(R.id.txtUbicacionL);

        public Holder(View itemView, final OnClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.itemClick(position);
                        }
                    }
                }
            });
            }


        public void connectData(Sitios sitios){
            imageView.setImageResource(sitios.getImagen());
            txtnombre.setText(sitios.getNombre());
            if(Constants.mode_listener==Constants.mode_list) {
                txtdescripcion.setText(sitios.getUbicacion());
                txtubicacion.setText(sitios.getDescripcion_c());
            }
            if(Constants.mode_listener==Constants.mode_grid) {
                txtubicacion.setText(sitios.getUbicacion());
            }


        }


    }



}
