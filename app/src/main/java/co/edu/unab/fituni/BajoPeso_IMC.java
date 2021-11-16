package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class BajoPeso_IMC extends AppCompatActivity {
    private static final int[] FLACO_DRAWABLE = {R.drawable.flaca, R.drawable.flaco, R.drawable.flacoagudelo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajo_peso_imc);

        Random random = new Random();
        int imgBajop = random.nextInt(3); //elige numero aleatorio de 0 a 4

        TextView resultado = (TextView) findViewById(R.id.textView4);
        ImageView imagen = (ImageView) findViewById(R.id.imageBajopeso);
        Double imc = MainActivity.getImc(); //trae el valor IMC desde MainActivity
        imagen.setImageResource(FLACO_DRAWABLE[imgBajop]);

        resultado.setText(String.format("IMC: %.1f tienes Bajo peso", imc ));

        Button botonVolverBajop = (Button) findViewById(R.id.buttonBajopVolver);
        botonVolverBajop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //termina actividad para que vulva al activity main
            }
        });
    }
}