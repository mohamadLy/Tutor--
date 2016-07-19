package com.example.glenjeffrey.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import utilisateur.Tuteur;

public class Courses extends AppCompatActivity {

    private List<Tuteur> tuteurs = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.title_activity_courses);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().collapseActionView();

        populateTutor();
        populateListView();
    }

    private void populateTutor() {
        for (int i = 0; i < 9; i++) {
            tuteurs.add(new Tuteur("Mamadou", "Ly"));
        }
    }
    private void populateListView() {
        ArrayAdapter<Tuteur> adapter = new MyAdapter();
        ListView listView = (ListView) findViewById(R.id.listViewCourses);
        listView.setAdapter(adapter);
    }

    private class MyAdapter extends ArrayAdapter<Tuteur> {

        public MyAdapter() {
            super(Courses.this, R.layout.item_course,  tuteurs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_course, parent, false);
            }
            // finding the current tutor
            Tuteur currentTutor =  tuteurs.get(position);
            // find the icone
            //ImageView profile = (ImageView)convertView.findViewById(R.id.profilePicture);
            //profile.setImageResource(currentTutor.getIdUtilisateur());
            return convertView;
            //return super.getView(position, convertView, parent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_main_page, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem); // <-- change your code to this
        // Configure the search info and add any event listeners
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                //Toast.makeText(StudentMainPage.this, "option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                break;
            case R.id.action_disconnect:
                Intent intent = new Intent(Courses.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true; //super.onOptionsItemSelected(item);
    }
}
