package com.example.selectorcolores;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView tv_color, tv_cantidad;
    private SeekBar sb_alpha, sb_red, sb_green, sb_blue;
    private Integer azul = 0, verde = 0, rojo = 0, alpha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        sb_alpha.setOnSeekBarChangeListener(this);
        sb_red.setOnSeekBarChangeListener(this);
        sb_green.setOnSeekBarChangeListener(this);
        sb_blue.setOnSeekBarChangeListener(this);
    }

    private void actualizarColor() {
        tv_color.setBackgroundColor(android.graphics.Color.argb(alpha, rojo, verde, azul));
        tv_cantidad.setText("Cantidad: rbga(" + rojo + ", " + verde + ", " + azul + ", " + alpha + ")");
    }

    private void inicializar() {
        tv_color = findViewById(R.id.tv_color);
        tv_cantidad = findViewById(R.id.tv_cantidad);
        sb_alpha = findViewById(R.id.sb_alpha);
        sb_red = findViewById(R.id.sb_red);
        sb_green = findViewById(R.id.sb_green);
        sb_blue = findViewById(R.id.sb_blue);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.sb_alpha:
                alpha = i;
                break;
            case R.id.sb_red:
                rojo = i;
                break;
            case R.id.sb_green:
                verde = i;
                break;
            case R.id.sb_blue:
                azul = i;
                break;
        }
        actualizarColor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}