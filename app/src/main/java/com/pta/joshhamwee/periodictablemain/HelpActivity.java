package com.pta.joshhamwee.periodictablemain;

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
        //listDataHeader.add("About Us");

        List<String> filterfunctions = new ArrayList<>();
        filterfunctions.add("To filter between the different crystals and machines, on the home page click on the top right hand dropdown menu. The elements will be filtered based on of they are within the crystal's range, and elements within this range will be distinguished by colour.");
        filterfunctions.add("To search for an element, click on the icon in the top right hand corner of the home page. You can search for an element by name, atomic symbol, and atomic number.");

        List<String> changinginstrument = new ArrayList<>();
        changinginstrument.add("Once you have selected an element from either the periodic table or the search function then you will be presented with the element data page.");
        changinginstrument.add("To switch between the different instruments to change the units of the data, select the drop down menu that you require, again in the top right.");

       // List<String> aboutus = new ArrayList<>();
       // aboutus.add("EMAS is a non-profit organisation that required an application to be able to easily access alot of data.");
       // aboutus.add("This application was a project created for a Software Product Engineering module at the University of Bristol by Josh Hamwee, Sharlene D'Silva, Andrei Bogdan, Finn Wilkinson and Kshitiv Upmanyu.");

        listHash.put(listDataHeader.get(0),filterfunctions);
        listHash.put(listDataHeader.get(1),changinginstrument);
       // listHash.put(listDataHeader.get(2),aboutus);

        listAdapter = new com.pta.joshhamwee.periodictablemain.ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

    }
    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar); //Find the toolbar
        setSupportActionBar(toolbar); //Start the toolbar
        toolbar.bringToFront();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Help");
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
                                drawerLayout.closeDrawer(GravityCompat.START); //Close the drawer
                                break;
                            case R.id.about_us:
                                menuItem.setChecked(true);
                                openAboutUsActivity(); //Open about us activity on click
                                break;
                        }
                        return false;
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
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

    //When about us page is selected from drawer, start the new activity
    private void openAboutUsActivity(){
        Intent intent = new Intent(this, AboutUsActivity.class); //Create the intent that opens the new activity
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
