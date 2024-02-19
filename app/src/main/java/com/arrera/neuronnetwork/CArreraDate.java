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
}
