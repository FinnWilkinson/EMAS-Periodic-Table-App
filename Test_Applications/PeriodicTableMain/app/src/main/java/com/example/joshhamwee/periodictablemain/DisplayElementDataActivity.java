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

import java.util.Hashtable;


public class DisplayElementDataActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;

    private final int[] button_ids = {
            R.id.H,R.id.He,R.id.Li,R.id.Be,R.id.B,R.id.C,R.id.N,R.id.O,R.id.F,R.id.Ne,R.id.Na,R.id.Mg,R.id.Al,R.id.Si,R.id.P,R.id.S,R.id.Cl,R.id.Ar,
            R.id.K,R.id.Ca,R.id.Sc,R.id.Ti,R.id.V,R.id.Cr,R.id.Mn,R.id.Fe,R.id.Co,R.id.Ni,R.id.Cu,R.id.Zn,R.id.Ga,R.id.Ge,R.id.As,R.id.Se,R.id.Br,R.id.Kr,
            R.id.Rb,R.id.Sr,R.id.Y,R.id.Zr,R.id.Nb,R.id.Mo,R.id.Tc,R.id.Ru,R.id.Rh,R.id.Pd
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_element_data);

        //Sets up the toolbar on this activity
        setUpToolbar();

        //Get the ID Data that was passed from main activity or search activity
        Bundle dataFromMain = getIntent().getExtras();
        Integer id = dataFromMain.getInt("ElementID");
        Integer elementSize = dataFromMain.getInt("ElementIDSearch");

        if(elementSize > 0){
            id = button_ids[elementSize-1];
        }

        //create a new database instance
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        //Create an element object that relates to the specific ID
        CurrentElement currentElement = new CurrentElement(id, databaseAccess);

        //Temporary TextView with element name
        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.name);
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
