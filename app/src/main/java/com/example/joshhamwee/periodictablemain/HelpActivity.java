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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelpActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setUpToolbar(); //Function that handles the toolbar, see below
        setUpList(); //Function that handles the FAQ's
    }

    private void setUpList(){
        listView = (ExpandableListView)findViewById(R.id.help_view);
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Filter Functions");
        listDataHeader.add("Changing Instrument");
        listDataHeader.add("About Us");
        listDataHeader.add("Privacy Policy");

        List<String> faqs = new ArrayList<>();
        faqs.add("These are a list of FAQ's and other useful information!");

        List<String> androidStudio = new ArrayList<>();
        androidStudio.add("Expandable ListView");
        androidStudio.add("Google Map");
        androidStudio.add("Chat Application");
        androidStudio.add("Firebase ");

        List<String> xamarin = new ArrayList<>();
        xamarin.add("Xamarin Expandable ListView");
        xamarin.add("Xamarin Google Map");
        xamarin.add("Xamarin Chat Application");
        xamarin.add("Xamarin Firebase ");

        List<String> uwp = new ArrayList<>();
        uwp.add("UWP Expandable ListView");
        uwp.add("UWP Google Map");
        uwp.add("UWP Chat Application");
        uwp.add("UWP Firebase ");

        listHash.put(listDataHeader.get(0),faqs);
        listHash.put(listDataHeader.get(1),androidStudio);
        listHash.put(listDataHeader.get(2),xamarin);
        listHash.put(listDataHeader.get(3),uwp);

        listAdapter = new com.example.joshhamwee.periodictablemain.ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

    }
    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar); //Find the toolbar
        setSupportActionBar(toolbar); //Start the toolbar
        toolbar.bringToFront();

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
