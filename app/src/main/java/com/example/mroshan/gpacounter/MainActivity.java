package com.example.mroshan.gpacounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String result;

    RadioGroup ResultRadioGroup;
    RadioButton ARadioButton;
    RadioButton BRadioButton;
    RadioButton CRadioButton;
    RadioButton FRadioButton;

    RadioButton SubARadioButton;
    RadioButton SubBRadioButton;
    RadioButton SubCRadioButton;

    TextView GPA ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Double subcredit,gpa = null;


        ARadioButton = (RadioButton) findViewById(R.id.AradioButton);
        BRadioButton = (RadioButton) findViewById(R.id.BradioButton);
        CRadioButton = (RadioButton) findViewById(R.id.CradioButton);
        FRadioButton = (RadioButton) findViewById(R.id.FradioButton);

        SubARadioButton = (RadioButton) findViewById(R.id.SubAradioButton);
        SubBRadioButton = (RadioButton) findViewById(R.id.SubBradioButton);
        SubCRadioButton = (RadioButton) findViewById(R.id.SubCradioButton);

        if(SubARadioButton.isChecked()){
            subcredit = 4.0;

            if (ARadioButton.isChecked()){
                gpa = (4.0 * 4)/2;
            }
            else if (BRadioButton.isChecked()){
                gpa = (3.0 * 4)/2;
            }
            else if (CRadioButton.isChecked()){
                gpa = (2.0 * 4)/2;
            }
            else{
                gpa = 0.0;
            }
        }
        if (SubBRadioButton.isChecked()){
            subcredit = 2.5;

            if (ARadioButton.isChecked()){
                gpa = (4.0 * 3.5)/2;
            }
            else if (BRadioButton.isChecked()){
                gpa = (3.0 * 3.5)/2;
            }
            else if (CRadioButton.isChecked()){
                gpa = (2.0 * 3.5)/2;
            }
            else{
                gpa = 0.0;
            }
        }
        if (SubCRadioButton.isChecked()){
            subcredit = 3.0;

            if (ARadioButton.isChecked()){
                gpa = (4.0 * 3.0)/2;
            }
            else if (BRadioButton.isChecked()){
                gpa = (3.0 * 3.0)/2;
            }
            else if (CRadioButton.isChecked()){
                gpa = (2.0 * 3.0)/2;
            }
            else{
                gpa = 0.0;
            }
        }

        GPA = (TextView)findViewById(R.id.GPA);

        GPA.setText(gpa.toString());


    }

}
