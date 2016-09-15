package com.roshan.sgpacounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshan on 8/19/2016.
 */


public class StudentDetails extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        addStudent();
        //spinner element
        Spinner level = (Spinner) findViewById(R.id.spinnerLevel);
        //spinner click listener
        level.setOnItemSelectedListener(this);

        //spinner drop down
        List<String> categories = new ArrayList<String>();
        categories.add("Level 1");
        categories.add("Level 2");
        categories.add("Level 3");
        categories.add("Level 4");
        categories.add("Level 5");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        level.setAdapter(adapter);

        Spinner sem = (Spinner) findViewById(R.id.spinnerSem);
        //spinner click listener
        sem.setOnItemSelectedListener(this);

        //spinner drop down
        List<String> semester = new ArrayList<String>();
        semester.add("semester 1");
        semester.add("semester 2");
        semester.add("semester 3");

        ArrayAdapter adapterSem = new ArrayAdapter(this, android.R.layout.simple_spinner_item, semester);
        adapterSem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sem.setAdapter(adapterSem);

        Spinner sub = (Spinner) findViewById(R.id.spinnerSub);
        //spinner click listener
        sub.setOnItemSelectedListener(this);

        //spinner drop down
        List<String> subject = new ArrayList<String>();
        subject.add("subject 1");
        subject.add("subject 2");
        subject.add("subject 3");

        ArrayAdapter adpsubject = new ArrayAdapter(this, android.R.layout.simple_spinner_item, subject);
        adpsubject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sub.setAdapter(adpsubject);

        Spinner result = (Spinner) findViewById(R.id.spinnerResult);
        //spinner click listener
        result.setOnItemSelectedListener(this);

        //spinner drop down
        List<String> res = new ArrayList<String>();
        res.add("A+");
        res.add("A");
        res.add("A-");
        res.add("B+");
        res.add("B");
        res.add("B-");
        res.add("C+");
        res.add("C");
        res.add("C-");
        res.add("D");
        res.add("F");
        res.add("I");

        ArrayAdapter adpresult = new ArrayAdapter(this, android.R.layout.simple_spinner_item, res);
        adpresult.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        result.setAdapter(adpresult);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (view.getId()) {
            case 1:

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addStudent() {
        DBHelper dbHelper = new DBHelper(this);
        Log.d("Insert: ", "Inserting ..");
        dbHelper.addStudent(new Student("134092p", "Roshan Maddumage", "uomroshan@gmail.com", "13"));
        dbHelper.addStudent(new Student("134102b", "Lahiru Manulanka", "lahiru@gmail.com", "13"));
        dbHelper.addStudent(new Student("135071j", "K.T.N.B.Peris", "nimesha@gmail.com", "13"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Student> contacts = dbHelper.getAllStudents();

        for (Student cn : contacts) {
            String log = "Id: " + cn.getStudent_ID() + " ,Name: " + cn.getName() + " ,Email: " + cn.getEmail() + " ,Batch : " + cn.getBatch();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
