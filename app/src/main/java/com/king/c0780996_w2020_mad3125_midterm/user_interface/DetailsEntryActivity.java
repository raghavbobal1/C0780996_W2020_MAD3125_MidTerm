package com.king.c0780996_w2020_mad3125_midterm.user_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.king.c0780996_w2020_mad3125_midterm.R;

public class DetailsEntryActivity extends AppCompatActivity
{
    private Button btn_submit;
    private Button btn_clear;
    private Button btn_ok;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
