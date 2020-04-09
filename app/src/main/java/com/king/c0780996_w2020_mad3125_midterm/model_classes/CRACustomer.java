package com.king.c0780996_w2020_mad3125_midterm.model_classes;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class CRACustomer implements Serializable
{
        public long sinNumber;
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

        public CRACustomer(long sinNumber, String firstName, String lastName, String fullName,
                           Date birthDate, String gender, int age, LocalDate taxFilingDate, float grossIncome, float federalTax,
                           float provincialTax, float cpp, float ei, float rrspContributed, float carryForwardRRSP,
                           float totalTaxableIncome, float totalTaxPayed) {
            this.sinNumber = sinNumber;
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

        public CRACustomer(long sinNumber, String firstName, String lastName,Date birthDate,
                           String gender, int age, LocalDate taxFilingDate, float grossIncome,float rrspContributed)
        {

            this.sinNumber = sinNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = lastName + " " + firstName;
            this.birthDate = birthDate;
            this.gender = gender;
            this.age = age;
            this.taxFilingDate = taxFilingDate;
            this.grossIncome = grossIncome;
            this.rrspContributed = rrspContributed;

        }

    public long getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(long sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getTaxFilingDate() {
        return taxFilingDate;
    }

    public void setTaxFilingDate(LocalDate taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public float getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(float grossIncome) {
        this.grossIncome = grossIncome;
    }

   
}

