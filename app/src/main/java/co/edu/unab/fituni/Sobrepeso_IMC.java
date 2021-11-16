package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Sobrepeso_IMC extends AppCompatActivity {
    private static final int[] SOBREPESO_DRAWABLE = {R.drawable.sobrepeso_mujer, R.drawable.sobrepeso_mujer2, R.drawable.sobrepeso_mujer3,
    R.drawable.sobrepeso_hombre, R.drawable.sobrepeso_hombre2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobrepeso_imc);
        Random random = new Random();
        int imgSobrep = random.nextInt(5); //elige numero aleatorio de 0 a 4

        TextView resultado = (TextView) findViewById(R.id.textView2);
        ImageView imagen = (ImageView) findViewById(R.id.imageSobrepeso);
        Double imc = MainActivity.getImc();  //trae el valor IMC desde MainActivity
        imagen.setImageResource(SOBREPESO_DRAWABLE[imgSobrep]); //establece la imagen imc sobrepeso

        resultado.setText(String.format("IMC: %.1f tienes Sobrepeso", imc ));

        Button botonVolverSobrep= (Button) findViewById(R.id.buttonSobrepVolver);
        botonVolverSobrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //termina actividad para que vulva al activity main
            }
        });
     }
}