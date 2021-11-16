package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Obesidad_IMC extends AppCompatActivity {

    private static final int[] OBESO_DRAWABLE = {R.drawable.obeso, R.drawable.obeso2, R.drawable.obesa, R.drawable.obesa2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidad_imc);
        Random random = new Random();
        int imgObeso = random.nextInt(4); //elige numero aleatorio de 0 a 4

        TextView resultado = (TextView) findViewById(R.id.textView3);
        ImageView imagen = (ImageView) findViewById(R.id.imageObeso);
        Double imc = MainActivity.getImc(); //trae el valor IMC desde MainActivity
        imagen.setImageResource(OBESO_DRAWABLE[imgObeso]); //establece la imagen imc Obesidad

        resultado.setText(String.format("IMC: %.1f tienes Obesidad", imc ));

        Button botonVolverObeso= (Button) findViewById(R.id.buttonObesoVolver);
        botonVolverObeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //termina actividad para que vulva al activity main
            }
        });
    }
}