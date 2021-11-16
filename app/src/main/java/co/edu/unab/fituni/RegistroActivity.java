package co.edu.unab.fituni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ArrayList<IndiceMasaMuscular> list = getIntent().getParcelableArrayListExtra("datosLista");
        ImcAdapter adapter = new ImcAdapter(this, R.layout.item_layout, list);
        ListView listView = (ListView)findViewById(R.id.listaReg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IndiceMasaMuscular regItem = list.get(position); //obtendo elemento que corrsponde al item clickeado;
                Intent intent = new Intent(RegistroActivity.this, ImcDetails.class );
                intent.putExtra("regItem", regItem);
                //intent.putExtras(savedInstanceState);
                startActivity(intent);
            }
        });
    }
}