package co.edu.unab.fituni;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.versionedparcelable.VersionedParcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IndiceMasaMuscular implements Parcelable {
    private Double estatura;
    private Double peso;
    private Double imc;
    private String fecha;

    public IndiceMasaMuscular(Double estatura, Double peso, Double imc, String fecha) {
        this.estatura = estatura;
        this.peso = peso;
        this.imc = imc;
        this.fecha = fecha;
    }

    public IndiceMasaMuscular(Parcel in){
        //String[] data = new String[4];
        //SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

        //in.readStringArray(data);
        estatura = in.readDouble(); //Double.parseDouble(data[0]);
        peso = in.readDouble();//Double.parseDouble(data[1]);
        imc = in.readDouble();//Double.parseDouble(data[2]);
        //try {
            fecha = in.readString();//dateFormat.parse(data[3]);
       // } catch (ParseException e) {
         //   e.printStackTrace();
        //}

    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getEstatura() {
        return estatura;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getImc() {
        return imc;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(estatura);
        dest.writeDouble(peso);
        dest.writeDouble(imc);
        dest.writeString(fecha.toString());
    }

    public static final Parcelable.Creator<IndiceMasaMuscular> CREATOR =
            new Parcelable.Creator<IndiceMasaMuscular>() {
        public IndiceMasaMuscular createFromParcel(Parcel in){
            return new IndiceMasaMuscular(in);
        }

                @Override
                public IndiceMasaMuscular[] newArray(int size) {
                    return new IndiceMasaMuscular[size];
                }
            };
}
