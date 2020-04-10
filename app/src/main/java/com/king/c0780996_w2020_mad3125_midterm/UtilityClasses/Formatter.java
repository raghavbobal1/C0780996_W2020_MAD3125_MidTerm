package com.king.c0780996_w2020_mad3125_midterm.UtilityClasses;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Formatter
{
    private static Formatter repoObj = new Formatter();
    public static Formatter getInstance() {
        return repoObj;
    }
    private Formatter()
    { }

    public LocalDate stringToDate(String aDate)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-yyyy");
        return formatter.parseLocalDate(aDate);
    }

    public String doubleFormatter(Double d)
    {
        return String.format("%.2f", d);
    }
}

