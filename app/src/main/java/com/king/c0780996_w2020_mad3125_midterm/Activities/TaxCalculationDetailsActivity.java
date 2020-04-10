package com.king.c0780996_w2020_mad3125_midterm.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.king.c0780996_w2020_mad3125_midterm.R;
import com.king.c0780996_w2020_mad3125_midterm.RequiredClasses.CRACustomer;
import com.king.c0780996_w2020_mad3125_midterm.UtilityClasses.Formatter;
import com.king.c0780996_w2020_mad3125_midterm.UtilityClasses.TaxCalculation;

import org.joda.time.LocalDate;

public class TaxCalculationDetailsActivity extends AppCompatActivity
{
    TextView textRRSP, textSin, textFullName, textDOB, textGender, textAge, textGrossIncome, textFedTax, textProvTax, textCPP, textEI, textCFRrsp, textTotalTaxable, textTotalTaxPaid;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_calc);
        TaxVariableInitialization();
        Intent intent = getIntent();
        CRACustomer craCustomer = intent.getParcelableExtra("CRACustomer");
        String firstName = craCustomer.getFirstName();
        String formattedFirstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        String lastName = craCustomer.getLastName().toUpperCase();
        String fullName = lastName + ", " +formattedFirstName;
        textFullName.setText(fullName);
        textSin.setText(craCustomer.getSIN());
        textGrossIncome.setText("$ " + Formatter.getInstance().doubleFormatter(craCustomer.getGrossIncome()));
        textDOB.setText(craCustomer.getBirthDate());
        textGender.setText(craCustomer.getGender());
        textAge.setText(String.valueOf(getAge()));

        TaxCalculation taxCalculation = new TaxCalculation(craCustomer.getGrossIncome(), craCustomer.getRrspContributed());

        double totalTaxableIncome = 0.0d;
        double maxRRSP =  0.18d * craCustomer.getGrossIncome();
        double EI = taxCalculation.calcEI(craCustomer.getGrossIncome());
        double CPP = taxCalculation.calcCPP(craCustomer.getGrossIncome());
        double RRSP = craCustomer.getRrspContributed();

        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            totalTaxableIncome = craCustomer.getGrossIncome() - (CPP + EI + maxRRSP);
        }
        else
        {
            totalTaxableIncome = craCustomer.getGrossIncome() - (CPP + EI + RRSP);
        }

        double provincialTax = taxCalculation.complexCalcTaxProvince(totalTaxableIncome);
        double federalTax = taxCalculation.calcTaxFederal(totalTaxableIncome) * totalTaxableIncome;
        double totalTax = provincialTax + federalTax;

        textProvTax.setText("$ " + Formatter.getInstance().doubleFormatter(provincialTax));
        textFedTax.setText("$ " + Formatter.getInstance().doubleFormatter(federalTax));
        textCPP.setText("$ " + Formatter.getInstance().doubleFormatter(CPP));
        textEI.setText("$ " + Formatter.getInstance().doubleFormatter(EI));
        textTotalTaxPaid.setText("$ " +Formatter.getInstance().doubleFormatter(totalTax));
        textRRSP.setText("$ " +Formatter.getInstance().doubleFormatter(craCustomer.getRrspContributed()));
        textTotalTaxable.setText("$ " +Formatter.getInstance().doubleFormatter(totalTaxableIncome));

        if(craCustomer.getRrspContributed() > maxRRSP)
        {
            Double finalCarry = craCustomer.getRrspContributed() - maxRRSP;
            textCFRrsp.setText("$ " +"-"+Formatter.getInstance().doubleFormatter(finalCarry));
            textCFRrsp.setTextColor(getResources().getColor(R.color.colorRed));
            textCFRrsp.setTypeface(null, Typeface.BOLD);
        }
        else
        {
            Double finalCarry =  maxRRSP - craCustomer.getRrspContributed();
            textCFRrsp.setText("$ " +Formatter.getInstance().doubleFormatter(finalCarry));
        }
    }

    public int getAge()
    {
        int age = 0;
        String bDate = textDOB.getText().toString();
        age = LocalDate.now().getYear() - Formatter.getInstance().stringToDate(bDate).getYear();
        return age;
    }

    public void TaxVariableInitialization()
    {
        textFullName = findViewById(R.id.textFullName);
        textSin = findViewById(R.id.textSin);
        textDOB = findViewById(R.id.textDOB);
        textGender = findViewById(R.id.textGender);
        textAge = findViewById(R.id.textAge);
        textGrossIncome = findViewById(R.id.textGrossIncome);
        textFedTax = findViewById(R.id.textFedTax);
        textProvTax = findViewById(R.id.textProvTax);
        textCPP = findViewById(R.id.textCPP);
        textCFRrsp = findViewById(R.id.textCFRrsp);
        textRRSP = findViewById(R.id.textRRSP);
        textEI = findViewById(R.id.textEI);
        textTotalTaxable = findViewById(R.id.textTotalTaxable);
        textTotalTaxPaid = findViewById(R.id.textTotalTaxPaid);
    }
}

