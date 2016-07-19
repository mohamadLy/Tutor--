package com.example.glenjeffrey.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddCompetence extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_competence);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        // Spinner element
        Spinner spinner1 = (Spinner) findViewById(R.id.coursEnGenie);
        Spinner spinner2 = (Spinner) findViewById(R.id.coursEnScience);
        Spinner spinner3 = (Spinner) findViewById(R.id.coursEnArt);
        Spinner spinner4 = (Spinner) findViewById(R.id.coursEnSocialScience);

        // Spinner click listener
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categoriesGenie = new ArrayList<String>();
        categoriesGenie.add("Chemical Engineering");
        categoriesGenie.add("Software Engineering");
        categoriesGenie.add("Computer Engineering");
        categoriesGenie.add("Mechanical Engineering");
        categoriesGenie.add("Civil Engineering");

        // Spinner Drop down elements
        List<String> categoriesScience = new ArrayList<String>();
        categoriesScience.add("Biology");
        categoriesScience.add("Physics");
        categoriesScience.add("Mathematics");
        categoriesScience.add("Chemistry");

        // Spinner Drop down elements
        List<String> categoriesSocialScience = new ArrayList<String>();
        categoriesSocialScience.add("Political Science");
        categoriesSocialScience.add("Anthropology");
        categoriesSocialScience.add("Criminology");
        categoriesSocialScience.add("Sociology");

        // Spinner Drop down elements
        List<String> categoriesArt = new ArrayList<String>();
        categoriesArt.add("English");
        categoriesArt.add("French");
        categoriesArt.add("Geography");
        categoriesArt.add("History");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterGenie = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesGenie);
        ArrayAdapter<String> dataAdapterScience = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesScience);
        ArrayAdapter<String> dataAdapterSocialScience = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesSocialScience);
        ArrayAdapter<String> dataAdapterArt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesArt);

        // Drop down layout style - list view with radio button
        dataAdapterGenie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterScience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterSocialScience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterArt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapterGenie);
        spinner2.setAdapter(dataAdapterScience);
        spinner3.setAdapter(dataAdapterSocialScience);
        spinner4.setAdapter(dataAdapterArt);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), item + " added", Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void saveCompetence(View view) {
        Toast.makeText(this, " Competence added", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AddCompetence.this, TutorMainPage.class);
        startActivity(intent);
    }
}
