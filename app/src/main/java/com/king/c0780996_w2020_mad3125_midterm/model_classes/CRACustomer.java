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
        public double grossIncome;
        public double federalTax;
        public double provincialTax;
        public double cpp;
        public double ei;
        public double rrspContributed;
        public double carryForwardRRSP;
        public double totalTaxableIncome;
        public double totalTaxPayed;
        public double maxRRSP;

        public CRACustomer(long sinNumber, String firstName, String lastName, String fullName,
                           Date birthDate, String gender, int age, LocalDate taxFilingDate, double grossIncome, double federalTax,
                           double provincialTax, double cpp, double ei, double rrspContributed, double carryForwardRRSP,
                           double totalTaxableIncome, double totalTaxPayed) {
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
                           String gender, int age, LocalDate taxFilingDate, double grossIncome,double rrspContributed)
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public LocalDate getTaxFilingDate() {
        return taxFilingDate;
    }

    public void setTaxFilingDate(LocalDate taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getTotalTaxableIncome() {

        if (getRrspContributed()>getMaxRRSP()){
            this.totalTaxableIncome = getGrossIncome()-(getCpp()+getEi()+getMaxRRSP());
        }else{
            this.totalTaxableIncome = getGrossIncome()-(getCpp()+getEi()+getRrspContributed());
        }

        return totalTaxableIncome;
    }

    public void setTotalTaxableIncome(double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public double getTotalTaxPayed() {

        this.totalTaxPayed = getFederalTax() + getProvincialTax();
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(double totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }


    public double getProvincialTax() {

        if (getTotalTaxableIncome()<=10582){
            this.provincialTax = 0.0;
        }else if(getTotalTaxableIncome()>=10582.01 && getTotalTaxableIncome()<=43906) {
            this.provincialTax = 0.0 + (getTotalTaxableIncome() - 10582.01) * 0.0505;
        }else if(getTotalTaxableIncome()>=43906.01 && getTotalTaxableIncome()<=87813) {
            this.provincialTax = 0.0 + (33323.99 * 0.0505) + ((getTotalTaxableIncome()-43906.01) * 0.0915);
        }else if(getTotalTaxableIncome()>=87813.01 && getTotalTaxableIncome()<=150000){
            this.provincialTax = 0.0 + (33323.99 * 0.0505) + (43906.99 * 0.0915) + ((getTotalTaxableIncome()-87813.01) * 0.1116 );
        }else if(getTotalTaxableIncome()>=150000.01 && getTotalTaxableIncome()<=220000){//
            this.provincialTax = 0.0 + + (33323.99 * 0.0505) + (43906.99 * 0.0915) + (62186.99 * 0.1116) + ((getTotalTaxableIncome()-150000.01) * 0.1216);
        }
        else {
            this.provincialTax = 0.0 + + (33323.99 * 0.0505) + (43906.99 * 0.0915) + (62186.99 * 0.1116) + (69999.99 * 0.1216) + ((getTotalTaxableIncome()-220000.01) * 0.1316);
        }

        return provincialTax;
    }

    public void setProvincialTax(double provincialTax) {
        this.provincialTax = provincialTax;
    }

    public double getFederalTax()
    {
        if (getTotalTaxableIncome()<=12069){
            this.federalTax = 0.0;
        }else if(getTotalTaxableIncome()>=12069.01 && getTotalTaxableIncome()<=47630) {
            this.federalTax = 0.0 + (getTotalTaxableIncome() - 12069.01) * 0.15;
        }else if(getTotalTaxableIncome()>=47630.01 && getTotalTaxableIncome()<=95259) {
            this.federalTax = 0.0 + (35560.99 * 0.15) + ((getTotalTaxableIncome()-47630.01) * 0.2050);
        }else if(getTotalTaxableIncome()>=95259.01 && getTotalTaxableIncome()<=147667){
            this.federalTax = 0.0 + (35560.99 * 0.15) + (47628.99 * 0.2050) + ((getTotalTaxableIncome()-95259.01) * 0.26 );
        }else if(getTotalTaxableIncome()>=147667.01 && getTotalTaxableIncome()<=210371){
            this.federalTax = 0.0 + + (35560.99 * 0.15) + (47628.99 * 0.2050) + (52407.99 * 0.26) + ((getTotalTaxableIncome()-147667.01) * 0.29);
        }
        else {
            this.federalTax = 0.0 + + (35560.99 * 0.15) + (47628.99 * 0.2050) + (52407.99 * 0.26) + (62703.99 * 0.29) + ((getTotalTaxableIncome()-210371.01) * 0.33);
        }

        return federalTax;
    }

    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }

    public double getEi() {
        double eiGrossModel = this.grossIncome;
        if (eiGrossModel <53100.0){
            this.ei = eiGrossModel * 0.0162;
        }else{
            this.ei = 53100 * 0.0162;
        }
        return ei;
    }

    public void setEi(double ei) {
        this.ei = ei;
    }

    public double getCpp() {

        double cppGrossModel = this.grossIncome;
        if(cppGrossModel < 57400.0){
            this.cpp = cppGrossModel * 0.0510;
        }
        else{
            this.cpp = 57400 * 0.0510;
        }
        return cpp;
    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
    }

    public double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

    public double getCarryForwardRRSP() {


        double rrspContri = this.rrspContributed;

        this.carryForwardRRSP = getMaxRRSP() - rrspContri;

        return carryForwardRRSP;
    }
    public double getMaxRRSP() {
        this.maxRRSP = this.grossIncome * 0.18;
        return maxRRSP;
    }

    public void setMaxRRSP(double maxRRSP) {
        this.maxRRSP = maxRRSP;
    }

    public void setCarryForwardRRSP(double carryForwardRRSP) {
        this.carryForwardRRSP = carryForwardRRSP;
    }



    @Override
    public String toString() {
        return "CRACustomer{" +
                "personSINNumber=" + sinNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", taxFilingDate=" + taxFilingDate +
                ", grossIncome=" + grossIncome +
                ", federalTax=" + federalTax +
                ", provincialTax=" + provincialTax +
                ", cpp=" + cpp +
                ", ei=" + ei +
                ", rrspContributed=" + rrspContributed +
                ", carryForwardRRSP=" + carryForwardRRSP +
                ", totalTaxableIncome=" + totalTaxableIncome +
                ", totalTaxPayed=" + totalTaxPayed +
                '}';
    }
}

