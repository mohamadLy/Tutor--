package com.example.mamadou.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import utilisateur.Domaine;
import utilisateur.Tuteur;

public class TutorDetails extends AppCompatActivity {

    private List<Tuteur> experience = new LinkedList<>();
    private Intent intent;
    private TextView myFullName;
    private TextView myProgramOfStudy;
    private TextView mySchool;
    private TextView myEmail;
    private TextView myUsername;
    private TextView myPostalCode;
    private TextView myPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.appTitle);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().collapseActionView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        populateTutor();
        populateListView();

        myPostalCode = (TextView) findViewById(R.id.my_postal_codeTutor);
        myProgramOfStudy = (TextView) findViewById(R.id.degreeTutor);
        myFullName = (TextView) findViewById(R.id.tutorFullName);
        myEmail = (TextView) findViewById(R.id.my_emailTutor);
        mySchool = (TextView) findViewById(R.id.universityTitle);
        myPhoneNumber = (TextView) findViewById(R.id.my_phone_numberTutor);
        myUsername = (TextView) findViewById(R.id.userNameTutor);

        myFullName.setText(TutorMainPage.tutor.getPrenom() + " " + TutorMainPage.tutor.getNom());
        //mySchool.setText(me.getSchool);
        // myProgramOfStudy.setText(me.getProgramOfStudy);
        myEmail.setText(TutorMainPage.tutor.getEmail());
        myUsername.setText(TutorMainPage.tutor.getUsername());
        //myPostalCode.setText(me.getCodePostal());
        //myPhoneNumber.setText(me.getNumeroTelephone());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_main_page, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem); // <-- change your code to this
        // Configure the search info and add any event listeners
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(TutorDetails.this, "option", Toast.LENGTH_SHORT).show();
                break;
        }
        return true; //super.onOptionsItemSelected(item);
    }

    private void populateTutor() {
        for (int i = 0; i < 5; i++) {
            experience.add(new Tuteur("jds","dsei"));
        }
    }
    private void populateListView() {
        ArrayAdapter<Tuteur> adapter = new MyAdapter();
        ListView listView = (ListView) findViewById(R.id.listViewExperience);
        listView.setAdapter(adapter);
    }

    private class MyAdapter extends ArrayAdapter<Tuteur> {

        public MyAdapter() {
            super(TutorDetails.this, R.layout.experience_items, experience);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.experience_items, parent, false);
            }
            // finding the current tutor
            Tuteur currentTutor = experience.get(position);
            // find the icone
            ImageView profile = (ImageView) convertView.findViewById(R.id.profilePicture);
            //profile.setImageResource(currentTutor.getIdUtilisateur());
            return convertView;
            //return super.getView(position, convertView, parent);

        }
    }
}
