package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class HelpActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setUpToolbar(); //Function that handles the toolbar, see below

    }

    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar); //Find the toolbar
        setSupportActionBar(toolbar); //Start the toolbar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( //On click listener for each item in the menu
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) { //Switch case for each item in the menu
                            case R.id.home:
                                menuItem.setChecked(true);
                                openMainActivity(); //Open main activity on click
                                break;
                            case R.id.graph:
                                menuItem.setChecked(true);
                                openEnergyActivity(); //Open energy activity on click
                                break;
                            case R.id.help:
                                menuItem.setChecked(true); //Do nothing
                                break;
                        }
                        return false;
                    }
                }
        );
    }

    //When main page is selected from drawer, start the new activity
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    //When energy page is selected from drawer, start the new activity
    private void openEnergyActivity(){
        Intent intent = new Intent(this, EnergyActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    //When the search button is clicked, start the search
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START); //When drawer button is clicked, open the drawer
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
