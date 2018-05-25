package com.aprendiz.ragp.guiaturistica.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.guiaturistica.Detalle_items;
import com.aprendiz.ragp.guiaturistica.MainActivity;
import com.aprendiz.ragp.guiaturistica.R;
import com.aprendiz.ragp.guiaturistica.models.AdapterMa;
import com.aprendiz.ragp.guiaturistica.models.Constants;
import com.aprendiz.ragp.guiaturistica.models.GestorDB;
import com.aprendiz.ragp.guiaturistica.models.Sitios;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRS.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRS extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static Sitios tmpS= new Sitios();
    private OnFragmentInteractionListener mListener;

    public FragmentRS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRS.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRS newInstance(String param1, String param2) {
        FragmentRS fragment = new FragmentRS();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_r, container, false);
        final List<Sitios> datoslista1= new ArrayList<>();
        final List<Sitios> datoslista2= new ArrayList<>();
        final List<Sitios> datoslista3= new ArrayList<>();
        List<Sitios> datosSitios= getData();
        final RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        Button btnS = v.findViewById(R.id.btnswitch);
        final TextView textdesL= v.findViewById(R.id.txtcontenidoC);
        final ImageView image1= v.findViewById(R.id.imageCo);
        for (int i=0;i<8;i++){
            datoslista1.add(datosSitios.get(i));

        }

        for (int i=8;i<16;i++){
            datoslista2.add(datosSitios.get(i));

        }

        for (int i=16;i<datosSitios.size();i++){
            datoslista3.add(datosSitios.get(i));

        }


        AdapterMa adapterMa = new AdapterMa(datoslista1);

        if (MainActivity.orien== Surface.ROTATION_90 || MainActivity.orien== Surface.ROTATION_270){
            Constants.mode_listener=Constants.mode_land;

        }else{
            Constants.mode_listener=Constants.mode_list;
        }
        if (MainActivity.cargaR==1){
            adapterMa = new AdapterMa(datoslista1);
            recyclerView.setAdapter(adapterMa);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);

            if (MainActivity.orien== Surface.ROTATION_180 || MainActivity.orien== Surface.ROTATION_0) {
                final AdapterMa finalAdapterMa;
                btnS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Constants.mode_listener == Constants.mode_list) {
                            Constants.mode_listener = Constants.mode_grid;
                            AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                            recyclerView.setAdapter(adapterMa1);
                            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                            recyclerView.setHasFixedSize(true);
                        }
                        if (Constants.mode_listener == Constants.mode_grid) {
                            Constants.mode_listener = Constants.mode_list;
                            AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                            recyclerView.setAdapter(adapterMa1);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                            recyclerView.setHasFixedSize(true);
                        }
                    }
                });
            }

            adapterMa.setMlistener(new AdapterMa.OnClickListener() {
                @Override
                public void itemClick(int position) {
                    tmpS=datoslista1.get(position);

                    if (MainActivity.orien== Surface.ROTATION_90 || MainActivity.orien== Surface.ROTATION_270){
                        image1.setImageResource(datoslista1.get(position).getImagen());
                        textdesL.setText(datoslista1.get(position).getDescripcion());

                    }else{
                        Intent intent = new Intent(getActivity(), Detalle_items.class);
                        startActivity(intent);
                    }
                }
            });


        }

        if (MainActivity.cargaR==2){
            adapterMa = new AdapterMa(datoslista2);
            recyclerView.setAdapter(adapterMa);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);

            if (MainActivity.orien== Surface.ROTATION_180 || MainActivity.orien== Surface.ROTATION_0) {
                final AdapterMa finalAdapterMa;
                btnS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Constants.mode_listener == Constants.mode_list) {
                            Constants.mode_listener = Constants.mode_grid;
                            AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                            recyclerView.setAdapter(adapterMa1);
                            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                            recyclerView.setHasFixedSize(true);
                        }
                        else {
                            if (Constants.mode_listener == Constants.mode_grid) {
                                Constants.mode_listener = Constants.mode_list;
                                AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                                recyclerView.setAdapter(adapterMa1);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                recyclerView.setHasFixedSize(true);
                            }
                        }
                    }
                });
            }


            adapterMa.setMlistener(new AdapterMa.OnClickListener() {
                @Override
                public void itemClick(int position) {
                    tmpS=datoslista2.get(position);
                    if (MainActivity.orien== Surface.ROTATION_90 || MainActivity.orien== Surface.ROTATION_270){
                        image1.setImageResource(datoslista2.get(position).getImagen());
                        textdesL.setText(datoslista2.get(position).getDescripcion());
                    }else{
                        Intent intent1 = new Intent(getActivity(), Detalle_items.class);
                        startActivity(intent1);
                    }
                }
            });


        }

        if (MainActivity.cargaR==3){
            adapterMa = new AdapterMa(datoslista3);
            recyclerView.setAdapter(adapterMa);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);

            if (MainActivity.orien== Surface.ROTATION_180 || MainActivity.orien== Surface.ROTATION_0) {
                final AdapterMa finalAdapterMa;
                btnS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (Constants.mode_listener == Constants.mode_list) {
                            Constants.mode_listener = Constants.mode_grid;
                            AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                            recyclerView.setAdapter(adapterMa1);
                            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                            recyclerView.setHasFixedSize(true);
                        }else {
                            if (Constants.mode_listener == Constants.mode_grid) {
                                Constants.mode_listener = Constants.mode_list;
                                AdapterMa adapterMa1 = new AdapterMa(datoslista1);
                                recyclerView.setAdapter(adapterMa1);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                                recyclerView.setHasFixedSize(true);
                            }
                        }
                    }
                });
            }


            adapterMa.setMlistener(new AdapterMa.OnClickListener() {
                @Override
                public void itemClick(int position) {
                    tmpS=datoslista3.get(position);
                    if (MainActivity.orien== Surface.ROTATION_90 || MainActivity.orien== Surface.ROTATION_270){
                        image1.setImageResource(datoslista3.get(position).getImagen());
                        textdesL.setText(datoslista3.get(position).getDescripcion());
                    }else{
                        Intent intent1 = new Intent(getActivity(), Detalle_items.class);
                        startActivity(intent1);
                    }
                }
            });


        }

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public List<Sitios> getData() {
        GestorDB gestorDB = new GestorDB(getContext());
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DATOS",null);
        List<Sitios> results = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Sitios sitios = new Sitios();
                sitios.setImagen(Integer.parseInt(cursor.getString(0)));
                sitios.setNombre((cursor.getString(1)));
                sitios.setDescripcion_c((cursor.getString(2)));
                sitios.setUbicacion((cursor.getString(3)));
                sitios.setDescripcion((cursor.getString(4)));

                results.add(sitios);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return results;
    }
}
