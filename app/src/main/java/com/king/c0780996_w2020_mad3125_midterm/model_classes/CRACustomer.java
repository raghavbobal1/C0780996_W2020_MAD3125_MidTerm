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
    
    public CRACustomer(long personSINNumber, String firstName, String lastName, String fullName,
                       Date birthDate, String gender, int age, LocalDate taxFilingDate, float grossIncome, float federalTax,
                       float provincialTax, float cpp, float ei, float rrspContributed, float carryForwardRRSP,
                       float totalTaxableIncome, float totalTaxPayed) {
        this.sINNumber = personSINNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.taxFilingDate = taxFilingDate;
        this.grossIncome = grossIncome;
        this.federalTax = federalTax;
        this.provincialTax = provincialTax;
        this.cpp = cpp;
        this.ei = ei;
        this.rrspContributed = rrspContributed;
        this.carryForwardRRSP = carryForwardRRSP;
        this.totalTaxableIncome = totalTaxableIncome;
        this.totalTaxPayed = totalTaxPayed;
    }

}