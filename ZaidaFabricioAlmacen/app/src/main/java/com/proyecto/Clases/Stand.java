package com.proyecto.Clases;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Stand
{
    private String standID;

    private String prodcut = "Default";
    private int quantity = 0;
    private Calendar day = null;

    private String unit = "minuto(s)";

    //Definidas
    private int howManyScans;
    private int howManyFilled;
    private Boolean status; //True = ocupado, se muestran las estadisticas

    private final Double capacity = 5.0;
    public static final String separator = ",";

    public Stand()
    {
    }

    public void restoreSavedData(String fabricio) throws ParseException
    {
        String[] zaida = fabricio.split( separator );
        this.prodcut = zaida[0];
        this.quantity = Integer.parseInt( zaida[1] );
        this.day = toCalendar( zaida[2] );
        this.howManyScans = Integer.parseInt( zaida[3] );
        this.howManyFilled = Integer.parseInt( zaida[4] );

        this.standID = zaida[5];
    }

    private Calendar toCalendar(String date) throws ParseException
    {
        if ( !date.equals(""))
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            cal.setTime( sdf.parse( date ) );
            return cal;
        }
        else return null;

    }


    //Void Methods-------------------------------------------------------------
    //Add
    public void addFill()
    {
        this.howManyFilled += 1;
    }

    public void addScan()
    {
        this.howManyScans += 1;
    }

    public void addProduct()
    {
        this.quantity += 1;
    }

    //Remove
    public void removeProduct()
    {
        this.quantity -= 1;
    }

    //Change
    public void changeName( String name )
    {
        this.prodcut = name;
    }

    public void changeDate()
    {
        this.day = Calendar.getInstance();
    }

    public void changeStatus(String stat)
    {
        this.status = stat.equals("ocupado");
    }

    //Double Methids-----------------------------------------------------------
    public Double getpercentage()
    {
        return (this.quantity / capacity) * 100;
    }

    //Getters------------------------------------------------------------------
    
    public String getID()
    {
        return  this.standID;
    }

    public String getProduct()
    {
        return this.prodcut;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getDay()
    {
        return "" + this.day.getTime();
    }

    public int getScans()
    {
        return this.howManyScans;
    }

    public int getFill()
    {
        return this.howManyFilled;
    }

    public Boolean getStatus()
    {
        return this.status;
    }


    private long getLastScan()
    {
        Date temp = this.day.getTime();
        Calendar now = Calendar.getInstance();
        Date temp1 = now.getTime();
        long diff = temp.getTime() - temp1.getTime();

        TimeUnit tu = TimeUnit.MINUTES;
        long difference = tu.convert( diff, TimeUnit.MILLISECONDS );

        if ( diff >= 60 && diff < 1440 )
        {
            tu = TimeUnit.HOURS;
            difference = tu.convert( diff, TimeUnit.MILLISECONDS );
            this.unit = "Hora(s)";
        }
        else
        {
            tu = TimeUnit.HOURS;
            difference = tu.convert( diff, TimeUnit.MILLISECONDS );
            this.unit = "Hora(s)";
        }

        return difference;
    }

    public  String getScanText()
    {
        if ( this.day == null )
        {
            return  "No se ha escaneado";
        }
        else
        {
            return "Escaneado hace: " + (getLastScan() * -1) + " " + this.unit;
        }
    }

    public String getText()
    {
        return "Producto: " + this.prodcut + "\n\nCantidad: " + this.quantity + "\n\nNumero de escaneos: " + getScans() + "\n\nCapacidad al " + getpercentage() + "%\n\n" + getScanText();
    }
}
