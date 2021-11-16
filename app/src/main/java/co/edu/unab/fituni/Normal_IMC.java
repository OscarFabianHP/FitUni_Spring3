package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Normal_IMC extends AppCompatActivity {
    private static final int[] NORMAL_DRAWABLE = {R.drawable.normal_imc_mujer, R.drawable.normal_imc_mujer2, R.drawable.normal_imc_mujer3,
    R.drawable.normal_imc_hombre, R.drawable.normal_imc_hombre2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_imc);
        Random random = new Random();
        int imgNormal = random.nextInt(5); //elige numero aleatorio de 0 a 4

        TextView resultado = (TextView) findViewById(R.id.textView);
        ImageView imagen = (ImageView) findViewById(R.id.imageNormal);

        Double imc = MainActivity.getImc(); //trae el valor IMC desde MainActivity
        imagen.setImageResource(NORMAL_DRAWABLE[imgNormal]); //establece la imagen imc normal
        resultado.setText(String.format("IMC: %.1f tienes Peso Normal", imc ));

        Button botonVolverNormal= (Button) findViewById(R.id.button);
        botonVolverNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //termina actividad para que vulva al activity main
            }
        });
    }
}