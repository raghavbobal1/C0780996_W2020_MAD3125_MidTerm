package com.king.c0780996_w2020_mad3125_midterm.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_midterm.R;
import com.king.c0780996_w2020_mad3125_midterm.RequiredClasses.CRACustomer;
import com.king.c0780996_w2020_mad3125_midterm.UtilityClasses.Formatter;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;

public class DetailsEntryActivity extends AppCompatActivity
{
    private Button btn_submit;
    private Button btn_clear;
    private Button btn_ok;

    private Spinner spinner_gender;
    private String gender;

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
        variableInitialization();
        setValue();
        datePicker();
        warningDOF();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                fieldChecker();
            }
        });


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

        ed_lnametext.addTextChangedListener(new TextWatcher()
        {
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

        ed_grossincometext.addTextChangedListener(new TextWatcher()
        {
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

        ed_dobtext.addTextChangedListener(new TextWatcher()
        {
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
                        getGender(),
                        ed_dobtext.getText().toString(),
                        Double.parseDouble(ed_grossincometext.getText().toString()),
                        Double.parseDouble(ed_rrsptext.getText().toString()));
                Intent mIntent = new Intent(DetailsEntryActivity.this, TaxCalculationDetailsActivity.class);
                mIntent.putExtra("CRACustomer", craCustomer);
                startActivity(mIntent);
            }
        }
    }

    private String getGender()
    {
        int genderSpinnerPosition = spinner_gender.getSelectedItemPosition();
        gender = String.valueOf(spinner_gender.getItemAtPosition(genderSpinnerPosition));
        return gender;
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

    private void warningDOF()
    {
        ed_doftext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(DetailsEntryActivity.this)
                        .setTitle("INVALID")
                        .setMessage("You cannot change this field.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    private void datePicker()
    {
        ed_dobtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        DetailsEntryActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                String date ="";
                month = month + 1;
                String monthName = getMonth(month);
                if(day<10) {
                    date = "0"+day + "-" + monthName + "-" + year;
                }
                else
                {
                    date = day + "-" + monthName + "-" + year;
                }
                ed_dobtext.setText(date);
            }
        };
    }

    public static String getMonth(int monthNum)
    {
        String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthName[monthNum-1];
    }

    private int ageCalculation(String s)
    {
        int age = 0;
        if(!ed_dobtext.getText().toString().isEmpty())
        {
            s = ed_dobtext.getText().toString();
            age = LocalDate.now().getYear() - Formatter.getInstance().stringToDate(s).getYear();
            return age;
        }
        Toast.makeText(DetailsEntryActivity.this, age, Toast.LENGTH_SHORT).show();
        return age;
    }

    public void fieldClear()
    {
        ed_sintext.getText().clear();
        ed_fnametext.getText().clear();
        ed_lnametext.getText().clear();
        ed_dobtext.getText().clear();
        ed_grossincometext.getText().clear();
        ed_rrsptext.getText().clear();
        ed_sin.setError(null);
        ed_dob.setError(null);
        ed_fname.setError(null);
        ed_lname.setError(null);
        ed_grossincome.setError(null);
        ed_rrsp.setError(null);

    }

    public void removeFields()
    {
        ed_sin.setEnabled(false);
        ed_fname.setEnabled(false);
        ed_lname.setEnabled(false);
        ed_dob.setEnabled(false);
        ed_grossincome.setEnabled(false);
        ed_rrsp.setEnabled(false);
    }

    public void getBackFields()
    {
        ed_sin.setEnabled(true);
        ed_fname.setEnabled(true);
        ed_lname.setEnabled(true);
        ed_dob.setEnabled(true);
        ed_grossincome.setEnabled(true);
        ed_rrsp.setEnabled(true);

    }
}

