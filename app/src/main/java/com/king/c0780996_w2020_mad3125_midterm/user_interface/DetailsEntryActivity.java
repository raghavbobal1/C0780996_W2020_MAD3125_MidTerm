package com.king.c0780996_w2020_mad3125_midterm.user_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_midterm.R;

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






    }
