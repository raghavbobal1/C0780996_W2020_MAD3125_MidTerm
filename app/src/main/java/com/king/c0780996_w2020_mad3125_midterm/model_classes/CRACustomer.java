package com.king.c0780996_w2020_mad3125_midterm.model_classes;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CRACustomer implements Serializable {
    public long sINNumber;
    public String firstName;
    public String lastName;
    public String fullName;
    public Date birthDate;
    public String gender;
    public int age;
    public LocalDate taxFilingDate;
    public float grossIncome;
    public float federalTax;
    public float provincialTax;
    public float cpp;
    public float ei;
    public float rrspContributed;
    public float carryForwardRRSP;
    public float totalTaxableIncome;
    public float totalTaxPayed;
    public float maxRRSP;


}