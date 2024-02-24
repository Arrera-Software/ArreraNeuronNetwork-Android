package com.arrera.neuronnetwork;

import java.text.SimpleDateFormat;
import java.util.Date;
public class CArreraDate {
    private Date date;

    public  CArreraDate ()
    {
        this.date = new Date();
    }

    public int getHour()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return  Integer.parseInt(sdf.format(timestamp));
    }
    public int getMin()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return  Integer.parseInt(sdf.format(timestamp));
    }

    public int getnbMonth()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("M");
        return  Integer.parseInt(sdf.format(timestamp));
    }

    public String getNameMonth()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String formattedMonth = sdf.format(new Date(timestamp));
        return  formattedMonth ;
    }

    public int getDay()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return  Integer.parseInt(sdf.format(timestamp));
    }

    public String getNameDayWeek ()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String formattedMonth = sdf.format(new Date(timestamp));
        return  formattedMonth ;
    }

    public int getYear()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return  Integer.parseInt(sdf.format(timestamp));
    }

    public String getDate()
    {
        long timestamp =  this.date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy");
        String formattedMonth = sdf.format(new Date(timestamp));
        return  formattedMonth ;
    }
}
