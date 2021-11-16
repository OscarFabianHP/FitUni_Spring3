package co.edu.unab.fituni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImcAdapter extends BaseAdapter {
    private Context context;
    private int layoutID;
    private List<IndiceMasaMuscular> list;

    public ImcAdapter(Context context, int layoutID, List<IndiceMasaMuscular> list){
        this.context=context;
        this.layoutID = layoutID;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View  view = inflater.inflate(layoutID, null);

        ImageView imageImc = (ImageView) view.findViewById(R.id.imageIconReg);
        TextView textImc = (TextView) view.findViewById(R.id.textImcReg);
        TextView textFecha = (TextView) view.findViewById(R.id.textFechaReg);

        IndiceMasaMuscular imcReg = list.get(position); //obtiene elemnto de la lista de registros

        double imc = imcReg.getImc(); //obtinen el IMC de la lista
        textImc.setText(String.format("IMC:%n%.1f", imc));
        textFecha.setText(String.format("FECHA:%n%s", imcReg.getFecha()));

        if(imc<18.5)
            imageImc.setImageResource(R.drawable.delgadoicon);
        else if(imc>=18.5 && imc<=24.9)
            imageImc.setImageResource(R.drawable.normalicon2);
        else if(imc>=25.0 && imc<=29.9)
            imageImc.setImageResource(R.drawable.sobrepesoicon);
        else if(imc>29.9)
            imageImc.setImageResource(R.drawable.gordoicon);

        return view;
    }
}
