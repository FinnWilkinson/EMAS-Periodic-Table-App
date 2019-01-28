package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    //Array of button id's to iterate over all buttons and set on click listeners
    private final int[] button_ids = {
            R.id.H,R.id.He,R.id.Li,R.id.Be,R.id.B,R.id.C,R.id.N,R.id.O,R.id.F,R.id.Ne,R.id.Na,R.id.Mg,R.id.Al,R.id.Si,R.id.P,R.id.S,R.id.Cl,R.id.Ar,
            R.id.K,R.id.Ca,R.id.Sc,R.id.Ti,R.id.V,R.id.Cr,R.id.Mn,R.id.Fe,R.id.Co,R.id.Ni,R.id.Cu,R.id.Zn,R.id.Ga,R.id.Ge,R.id.As,R.id.Se,R.id.Br,R.id.Kr,
            R.id.Rb,R.id.Sr,R.id.Y,R.id.Zr,R.id.Nb,R.id.Mo,R.id.Tc,R.id.Ru,R.id.Rh,R.id.Pd
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "YOU CLICKED A THING AND NOW IM HERE HELLO", Toast.LENGTH_SHORT).show();
                        break;
                    //add more cases here
                }

                return false;
            }
        });

        //For loop to create onClickListeners for each button
        //Override the onClick method to openActivityDisplayElementData
        for (final int id:button_ids){
            ImageButton button = (ImageButton) findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivityDisplayElementData(id);
                }
            });
        }

        //Create a button listener to open the search activity
        ImageButton searchButton = (ImageButton) findViewById(R.id.imageImageButton6);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActivity();
            }
        });
    }

    //When an element is clicked on, open new activiuty
    private void openActivityDisplayElementData(int id){
        Intent intent = new Intent(this,DisplayElementDataActivity.class); //Create the intent that opens the new activity
        intent.putExtra("ElementID",id);  //Put extra data into the intent so that next activity knows what element was clicked on
        startActivity(intent); //Execute the intent
    }

    //Handle on click listener for opening search activity
    private void openSearchActivity(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


}
