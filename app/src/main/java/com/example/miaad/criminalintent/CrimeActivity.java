package com.example.miaad.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends AppCompatActivity {
    /*

    // 2a version, hereda de SingleFragmentActivity
    //Borrar onCreate
        @Override
        protected Fragment createFragment() {
            return new CrimeFragment();
        }


        // 1st version of CrimeActivity
        // Ha de heredar de AppCompatActivity
        // Called when the activity is first created.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_crime);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment) .commit();
        }
    }

}
