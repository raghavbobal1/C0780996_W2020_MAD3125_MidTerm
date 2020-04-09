package com.king.c0780996_w2020_mad3125_midterm.user_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_midterm.R;
import com.king.c0780996_w2020_mad3125_midterm.model_classes.CRACustomer;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DetailsEntryActivity extends AppCompatActivity
{
    private Button btn_submit;
    private Button btn_clear;
    private Button btn_ok;

    private Spinner spinner_gender;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private TextInputLayout ed_sin;
    private TextInputEditText ed_sintext;

    private TextInputLayout ed_fname;
    private TextInputEditText ed_fnametext;

    private TextInputLayout ed_lname;
    private TextInputEditText ed_lnametext;

    private TextInputLayout ed_dob;
    private TextInputEditText ed_dobtext;

    private TextInputLayout ed_dof;
    private TextInputEditText ed_doftext;

    private TextInputLayout ed_grossincome;
    private TextInputEditText ed_grossincometext;

    private TextInputLayout ed_rrsp;
    private TextInputEditText ed_rrsptext;

    private TextView textWarning;

    @Override
    protected void onStart()
    {
        super.onStart();
        //clearAll():
        ed_sintext.setError(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void textWatch()
    {
        ed_sintext.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!sinValidations(ed_sintext.getText().toString()))
                {
                    ed_sintext.setError("SIN is Invalid");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_sin.setError(null);
            }
        });

        ed_fnametext.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_fname.setError(null);
            }
        });

        ed_lnametext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_lname.setError(null);
            }
        });

        ed_grossincometext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_grossincome.setError(null);
            }
        });

        ed_dobtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_dob.setError(null);
            }
        });

        ed_rrsptext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_rrsp.setError(null);
            }
        });
    }

        private void variableInitialization()
        {
            ed_rrsptext = findViewById(R.id.ed_rrsptext);
            ed_rrsp = findViewById(R.id.ed_rrsp);
            ed_dobtext = findViewById(R.id.ed_dobtext);
            ed_dob = findViewById(R.id.ed_dob);
            ed_grossincometext = findViewById(R.id.ed_grossincometext);
            ed_grossincome = findViewById(R.id.ed_grossincome);
            ed_lnametext = findViewById(R.id.ed_lnametext);
            ed_lname = findViewById(R.id.ed_lname);
            ed_fnametext = findViewById(R.id.ed_fnametext);
            ed_fname = findViewById(R.id.ed_fname);
            ed_sintext = findViewById(R.id.ed_sintext);
            ed_sin = findViewById(R.id.ed_sin);
            ed_doftext = findViewById(R.id.ed_doftext);
            ed_dof = findViewById(R.id.ed_dof);
            spinner_gender = findViewById(R.id.spinner_gender);
            btn_clear = findViewById(R.id.btn_clear);
            btn_submit = findViewById(R.id.btn_submit);
            btn_ok = findViewById(R.id.btn_ok);
            textWarning = findViewById(R.id.textWarning);
        }

        private void setValue()
        {
            LocalDate date = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MMM-yyyy");
            ed_doftext.setText(date.toString(dtf));

            textWarning.setVisibility(View.INVISIBLE);
            btn_ok.setVisibility(View.INVISIBLE);
        }


    public void fieldChecker()
    {
        boolean flagOne = false;
        if(ed_sintext.getText().toString().isEmpty())
        {
            ed_sin.setError("Enter your SIN Number");
            flagOne = true;
            return;
        }
        if(ed_fnametext.getText().toString().isEmpty())
        {
            ed_fname.setError("Enter your first name");
            flagOne = true;
            return;
        }
        if(ed_lnametext.getText().toString().isEmpty())
        {
            ed_lname.setError("Enter your last name");
            flagOne = true;
            return;
        }
        if(ed_dobtext.getText().toString().isEmpty())
        {
            ed_dob.setError("Enter your date of birth");
            flagOne = true;
            return;
        }
        if(ed_grossincometext.getText().toString().isEmpty())
        {
            ed_grossincome.setError("Enter your gross income");
            flagOne = true;
            return;
        }
        if(ed_rrsptext.getText().toString().isEmpty())
        {
            ed_rrsp.setError("Enter your RRSP");
            flagOne = true;
            return;
        }

        if(!flagOne)
        {
            int flagTwo = 0;
            if(ageCalculation(ed_dobtext.getText().toString()) < 18)
            {
                flagTwo = 1;
                textWarning.setVisibility(View.VISIBLE);
                btn_clear.setVisibility(View.INVISIBLE);
                btn_submit.setVisibility(View.INVISIBLE);
                btn_ok.setVisibility(View.VISIBLE);
                ed_dob.setError("Invalid date of birth");
            }

            if(!sinValidations(ed_sintext.getText().toString()))
            {
                flagTwo = 1;
                ed_sin.setError("Invalid SIN number");
            }

            if(flagTwo == 0)
            {
                CRACustomer craCustomer = new CRACustomer(ed_sintext.getText().toString(),
                        ed_fnametext.getText().toString(),
                        ed_lnametext.getText().toString(),
                        genderFetch(),
                        .getText().toString(),
                        Double.parseDouble(ed_grossincometext.getText().toString()),
                        Double.parseDouble(ed_rrsptext.getText().toString()));
                Intent mIntent = new Intent(DetailsEntryActivity.this, TaxCalculationDetailsActivity.class);
                mIntent.putExtra("CRACustomer", craCustomer);
                startActivity(mIntent);
            }
        }
    }

    public boolean sinValidations(String s)
    {
        int sinFlag = 0;
        if(ed_sintext.getText().toString().matches("^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$"))
        {
            sinFlag = 1;
            return true;
        }
        if(sinFlag == 0)
        {
            return false;
        }
        return true;
    }


}
