package com.example.miaad.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    /*public static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";*/
    private static final String EXTRA_CRIME_ID = "com.example.miaad.criminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);

        return intent;
    }

    @Override
    protected Fragment createFragment() {
        /*PASAR EXTRA (id del Crime) al CrimeFragment*/
        /*FORMA 2 --> OK*/
        /*CrimeActivity has to know plenty about CrimeFragment,
        including that it has a newInstance(UUID) method. This is fine.
        Hosting activities should know the specifics of how to host their fragments,
        but fragments should not have to know specifics about their activities.
        At least, not if you want to maintain the flexibility of independent fragments.*/
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);
    }

        // 1st version of CrimeActivity
        // Ha de heredar de AppCompatActivity
        // Called when the activity is first created.
    /*
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
    }*/

}
