package com.example.glenjeffrey.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mamadou.tutor.R;

import utilisateur.DummyData;

public class MainActivity extends AppCompatActivity {

    private final int STUDENT = 1;
    private final int TUTOR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DummyData();
    }
    public void studingLoginPage (View view) {
        // go to student login page
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("UserType", STUDENT);
        startActivity(intent);
    }
    public void tutorLoginPage (View view) {
        // go to student login page
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("UserType", TUTOR);
        startActivity(intent);
    }
}
