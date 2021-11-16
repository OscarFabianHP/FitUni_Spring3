package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText estaturaText;
    private EditText pesoText;
    private static Double imc;
    private ArrayList<IndiceMasaMuscular> listaReg;
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy KK:mm:ss a", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaReg = new ArrayList<>(); //crea lista donde se añadiran los registros
        estaturaText = (EditText) findViewById(R.id.editTextNumber);
        pesoText = (EditText) findViewById(R.id.editTextNumber2);

        Button botonCalcular = (Button) findViewById(R.id.button2);
        Button botonRegistros = (Button) findViewById(R.id.button3);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imcCalcular();
               Intent intentResultado = new Intent(MainActivity.this, ResultadoImc.class);
               startActivity(intentResultado);
               estaturaText.setText(""); //limpia el campo estatura
               pesoText.setText(""); //limpia el campo peso
               estaturaText.requestFocus(); //posiciona focus del cursor en campo estatura
            }
        });

        botonRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
               intent.putParcelableArrayListExtra("datosLista", listaReg);
               //intent.putExtras(savedInstanceState);
               startActivity(intent);
            }
        });
    }

    //metodo calcula IMC y añade los datos a la lista de registro
    private void imcCalcular(){
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        Double peso=0.0;
        Double estatura=0.0;
        //Date fecha=null; //inicializa fecha

        estatura = Double.parseDouble(estaturaText.getText().toString().trim())/100;
        peso = Double.parseDouble(pesoText.getText().toString().trim());
        imc = peso/(Math.pow(estatura, 2));
        //String imcFormated = decimalFormat.format(imc)  ;
        //Double imcD = Double.parseDouble(imcFormated);
        //try {
         String fecha =  dateFormat.format(Calendar.getInstance().getTime()); //obtiene fecha y hora actual
        //} catch (ParseException e) {
         //   e.printStackTrace();
        //}
        listaReg.add(new IndiceMasaMuscular(estatura, peso, imc , fecha)); //añade registro nuevo a lista
    }

    public static Double getImc() {
        return imc;
    }
}