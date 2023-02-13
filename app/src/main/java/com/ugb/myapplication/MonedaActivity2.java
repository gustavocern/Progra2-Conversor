package com.ugb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MonedaActivity2 extends AppCompatActivity {
    Button btn;
    TextView temp;
    Spinner spn;
    conversores miConversor = new conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda2);

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtcantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                spn = findViewById(R.id.spnde);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = findViewById(R.id.lblrespuesta);
                temp.setText("Respuesta: "+ miConversor.convertir(0, de, a, cantidad));
            }
        });

    }

}
class conversores{
    double[][] valores = {
            {1, 7.84, 24.63, 36.51, 581.78, 8.75, 0.93, 130.54, 82.52, 0.82},//monedas

            //{1, 1000, 1000000, 1000000000, 1e-12, 10.0  , 2204.62, 35.274, 1.016, 5000000},//Masa
            //{1, 0.01, 0.0010, 1000, 0.1, 0.001, 0.000001, 0.000353147, 0.0610237441, 0.0000100  },//Volumen
            //{1, 0.1, 0.01, 1e-5, 10, 10000, 1e+7, 1e+10, 5.3996e-6, 6.2137e-6},//longitud
            //{8, 8e-6, 8e-12, 8e-12, 1, 0.001, 1e-6, 1e-9, 1e-12, 1e-15},//Almacenamiento
           // {1, 1e-6, 1e-9, 1e-12, 1.6667e-14, 2.7778e-16, 1.1574e-17, 1.6534e-18, 3.8052e-19, 3.171e-20 },//Tiempo
    };
    public double convertir (int opcion, int de, int a, double cantidad){
        return valores [opcion][a] / valores [opcion][de]* cantidad;
    }
}