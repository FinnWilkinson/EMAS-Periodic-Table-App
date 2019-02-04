package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.content.ContextCompat;

import java.nio.channels.NotYetBoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;


public class DisplayElementDataActivity extends AppCompatActivity {

    Toolbar toolbar;
    //NavigationView navigationView;
    //Lists of different elements to determine colours
    private static final Set<Integer> AlkMetals = new HashSet<>(Arrays.asList(new Integer[]{1,3,11,19,37,55,87}));
    private static final Set<Integer> AlkEMetals = new HashSet<>(Arrays.asList(new Integer []{4,12,20,38,56,88}));
    private static final Set<Integer> TranMetals = new HashSet<>(Arrays.asList(new Integer []{21,22,23,24,25,26,27,28,29,30,
    39,40,41,42,43,45,46,47,48,72,73,74,75,76,77,78,79,80}));
    private static final Set<Integer> Metaloids = new HashSet<>(Arrays.asList(new Integer []{13,31,32,49,50,51,81,82,83,84}));
    private static final Set<Integer> NonMetals = new HashSet<>(Arrays.asList(new Integer []{5,6,7,8,9,14,15,16,17,33,34,35,52,53,85}));
    private static final Set<Integer> NobleGases = new HashSet<>(Arrays.asList(new Integer []{2,10,18,36,54,86}));
    //redundant --> may find another use later remove if not
   // private static final Set<Integer> HeavyEl = new HashSet<>(Arrays.asList(new Integer []{57,58,59}))


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_element_data);

        //Sets up the toolbar on this activity
        setUpToolbar();

        //Get the ID Data that was passed from main activity or search activity
        Bundle dataFromMain = getIntent().getExtras();
        Integer atomicNumber = dataFromMain.getInt("ElementID");                  //get passed atomic number
        Integer elementSize = dataFromMain.getInt("ElementIDSearch");   //gets passed atomic number
        if(elementSize != 0){
            atomicNumber = elementSize;
        }

        //create a new database instance
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        //Create an element object that relates to the specific ID
        CurrentElement currentElement = new CurrentElement(atomicNumber, databaseAccess);

        //Temporary TextView with element name
        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.name);
        TextView AtomicNumber = findViewById(R.id.AtomicNumber);
        AtomicNumber.setText("Atomic Number: " + currentElement.atomicNumber);
        TextView AtomicSymbol = findViewById(R.id.AtomicSymbol);
        AtomicSymbol.setText("Atomic Symbol: " + currentElement.atomicSymbol);
        TextView AtomicMass = findViewById(R.id.AtomicMass);
        AtomicMass.setText("Atomic Mass: " + currentElement.atomicMass);


        //should probably define a separate function to set up colour-- too much repetition
        if(AlkMetals.contains(atomicNumber)) {
            ElementName.setTextColor(ContextCompat.getColor(this, R.color.pastelPink));
        }
        else if(AlkEMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelOrange));
        }
        else if(TranMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelYellow));
        }
        else if(Metaloids.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelBlue));
        }
        else if(NonMetals.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelPurple));
        }
        else if(NobleGases.contains(atomicNumber)){
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGrey));
        }
        else{
            ElementName.setTextColor(ContextCompat.getColor(this,R.color.pastelGreen));
        }
    }

    /********** this is repeated code, probs should find a way around it. hehh..... ***/


    private void setUpToolbar() {
        //Find the toolbar by the specific id
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            if (getSupportActionBar()!=null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
