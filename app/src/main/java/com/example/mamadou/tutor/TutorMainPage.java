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
import android.widget.Toast;

import utilisateur.DummyData;
import utilisateur.Tuteur;

public class TutorMainPage extends AppCompatActivity {

    private static final int STUDENT = 1;
    private static final int TUTOR = 2;
    Intent intent;
    private int idUser;
    private int userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_main_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().collapseActionView();
        getSupportActionBar().setTitle(R.string.appTitle);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().collapseActionView();
        intent = getIntent();
        idUser = intent.getIntExtra("userId", 0);


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
                Toast.makeText(TutorMainPage.this, "option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                break;
            case R.id.action_disconnect:
                Intent intent = new Intent(TutorMainPage.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true; //super.onOptionsItemSelected(item);
    }
    public void detailsOnMe(View view) {
        Intent intent = new Intent(this, TutorDetails.class);
        startActivity(intent);
    }
    public void addCompetence(View view) {
        Intent intent = new Intent(this, AddCompetence.class);
        startActivity(intent);
    }
    public void onCalendar(View view) {
        Intent intent = new Intent(TutorMainPage.this, Calendar.class);
        startActivity(intent);
    }
    public void onHome( View view) {
        Intent intent = new Intent(TutorMainPage.this, TutorMainPage.class);
        startActivity(intent);
    }
    public void onBills(View view) {
        Intent intent = new Intent(TutorMainPage.this, Bill.class);
        startActivity(intent);
    }

    public void onMyTutoring(View view) {
        Intent intent = new Intent(TutorMainPage.this, MyTutoring.class);
        startActivity(intent);
    }

}
