package com.example.mamadou.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import utilisateur.Utilisateur;

public class StudentDetails extends AppCompatActivity {

    private TextView myFullName;
    private TextView myProgramOfStudy;
    private TextView mySchool;
    private TextView myEmail;
    private TextView myUsername;
    private TextView myPostalCode;
    private TextView myPhoneNumber;
    //private static Utilisateur student;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        myPostalCode = (TextView) findViewById(R.id.my_postal_code);
        myProgramOfStudy = (TextView) findViewById(R.id.programOfStudy);
        myFullName = (TextView) findViewById(R.id.My_name_on_student_details);
        myEmail = (TextView) findViewById(R.id.my_email);
        mySchool = (TextView) findViewById(R.id.school_on_student_details);
        myPhoneNumber = (TextView) findViewById(R.id.my_phone_number);
        myUsername = (TextView) findViewById(R.id.userName);

        myFullName.setText(StudentMainPage.student.getNom() + " " + StudentMainPage.student.getNom());
        //mySchool.setText(me.getSchool);
       // myProgramOfStudy.setText(me.getProgramOfStudy);
        myEmail.setText(StudentMainPage.student.getEmail());
        myUsername.setText(StudentMainPage.student.getUsername());
        //myPostalCode.setText(me.getCodePostal());
        //myPhoneNumber.setText(me.getNumeroTelephone());
    }
}
