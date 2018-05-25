package com.aprendiz.ragp.guiaturistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.guiaturistica.fragments.FragmentRS;
import com.aprendiz.ragp.guiaturistica.models.Sitios;

public class Detalle_items extends AppCompatActivity {
    Sitios sitios = new Sitios();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sitios = FragmentRS.tmpS;
        setContentView(R.layout.activity_detalle_items);
        ImageView imageView = findViewById(R.id.imgDetalle);
        TextView txtNomrbe = findViewById(R.id.txtNombreD);
        TextView txtDes = findViewById(R.id.txtDescripcionD);
        imageView.setImageResource(sitios.getImagen());
        txtNomrbe.setText(sitios.getNombre());
        txtDes.setText(sitios.getDescripcion_c());
    }
}
