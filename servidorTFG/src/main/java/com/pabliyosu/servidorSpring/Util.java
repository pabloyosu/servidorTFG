package com.pabliyosu.servidorSpring;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    //Métodos útiles para parsear fechas
    public static String fechaAtexto(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return dateFormat.format(date);
    }
    public static Date parseFecha(String fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        try {
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String fechaAtextoInsert(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

        return dateFormat.format(date);
    }
    public static Date textoAFechaParse(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String textoAFechaParaPintar(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        return dateFormat.format(date);
    }
}
