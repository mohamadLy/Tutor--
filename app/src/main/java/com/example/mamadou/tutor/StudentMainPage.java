package com.example.mamadou.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import utilisateur.DummyData;
import utilisateur.Tuteur;


public class StudentMainPage extends AppCompatActivity {

    private static final int STUDENT = 1;
    private static final int TUTOR = 2;
    Intent intent;
    private int idUser;
    private int userType;
    private String Username = "Username";
    private String name = "name";
    private List<Tuteur> tuteurs = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__main__page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle(R.string.appTitle);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().collapseActionView();
        populateTutor();
        populateListView();
        intent = getIntent();
        idUser = intent.getIntExtra("idUser", 0);

        CoverFlow coverFlow = (CoverFlow) findViewById(R.id.cf_coverflow);

        CoverImageAdapter coverImageAdapter = new CoverImageAdapter(this);

//		coverImageAdapter.createReflectedImages();

        coverFlow.setAdapter(coverImageAdapter);
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position,
                                    long arg3) {
                Toast.makeText(StudentMainPage.this, String.valueOf(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //welcome user
        welcome();
    }

    private void welcome() {
        userType = intent.getIntExtra("userType", 0);
        if (userType == STUDENT) {
            String firstName = intent.getStringExtra(Username);
            Toast.makeText(StudentMainPage.this, "Bonjour " + firstName,
                    Toast.LENGTH_LONG).show();
        }
        else if(userType == TUTOR){
            String firstName = DummyData.DUMMY_CREDENTIALS.get(idUser + 1).getPrenom();
            String lastName = DummyData.DUMMY_CREDENTIALS.get(idUser + 1).getNom();
            Toast.makeText(StudentMainPage.this, "Bonjour " + firstName + " " + lastName
                    , Toast.LENGTH_LONG).show();
        }
    }

    public void populateBill(View view) {
        Intent intent = new Intent(StudentMainPage.this, Bill.class);
        startActivity(intent);
    }

    public void populateCalendar(View view) {
        Intent intent = new Intent(StudentMainPage.this, Calendar.class);
        startActivity(intent);
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
                Toast.makeText(StudentMainPage.this, "option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                break;
            case R.id.action_disconnect:
                Intent intent = new Intent(StudentMainPage.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true; //super.onOptionsItemSelected(item);
    }
    private void populateTutor() {
        for (int i = 0; i < 5; i++) {
            tuteurs.add(new Tuteur("Mamadou", "Ly"));
        }
    }
    private void populateListView() {
        ArrayAdapter<Tuteur> adapter = new MyAdapter();
        ListView listView = (ListView) findViewById(R.id.listViewBestTutor);
        listView.setAdapter(adapter);
    }

    private class MyAdapter extends ArrayAdapter<Tuteur> {

        public MyAdapter() {
            super(StudentMainPage.this, R.layout.tutor_item_view,  tuteurs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.tutor_item_view, parent, false);
            }
            // finding the current tutor
            Tuteur currentTutor =  tuteurs.get(position);
            // find the icone
            ImageView profile = (ImageView)convertView.findViewById(R.id.profilePicture);
            //profile.setImageResource(currentTutor.getIdUtilisateur());
            return convertView;
            //return super.getView(position, convertView, parent);
        }
    }
    public void detailsOnMeStudent( View view) {
        Intent intent = new Intent(StudentMainPage.this, StudentDetails.class);
        startActivity(intent);
    }

    public void onHome( View view) {
        Intent intent = new Intent(StudentMainPage.this, StudentMainPage.class);
        startActivity(intent);
    }

    public void onCourses( View view) {
        Intent intent = new Intent(StudentMainPage.this, Courses.class);
        startActivity(intent);
    }
    public void onBills( View view) {
        Intent intent = new Intent(StudentMainPage.this, Bill.class);
        startActivity(intent);
    }
    public void onCalendar(View view) {
        Intent intent = new Intent(StudentMainPage.this, Calendar.class);
        startActivity(intent);
    }

}
