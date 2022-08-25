package com.proyecto.Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class OptimizedStand
{
    private String content;
    private Calendar day;

    private final String spacer = ",";

    public static final String enter = "\n\n";

    public OptimizedStand()
    {
        this.content = "Default text";
        this.day = null;
    }

    public void restoreData(String fabricio) throws ParseException
    {
        String[] zaida = fabricio.split(spacer);

        this.content = zaida[0];
        this.day = toCalendar( zaida[2] );
    }

    public Calendar toCalendar(String date) throws ParseException
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        cal.setTime( sdf.parse( date ) );
        return cal; 
    }

    public String getText()
    {
        return this.content + spacer + day.toString();
    }

}
