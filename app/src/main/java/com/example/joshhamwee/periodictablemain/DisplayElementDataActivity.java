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

        //Create textViews to display chosen elements information
        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.name);
        TextView AtomicNumber = findViewById(R.id.AtomicNumber);
        AtomicNumber.setText("Atomic Number:                   " + currentElement.atomicNumber);
        TextView AtomicSymbol = findViewById(R.id.AtomicSymbol);
        AtomicSymbol.setText("Atomic Symbol: " + currentElement.atomicSymbol);
        TextView AtomicMass = findViewById(R.id.AtomicMass);
        AtomicMass.setText("Atomic Mass: " + currentElement.atomicMass);
        TextView CrystalStruct = findViewById(R.id.CrystalStruct);
        CrystalStruct.setText("Crystal Structure: " + currentElement.crystalStructure);
        TextView ShellK = findViewById(R.id.ShellOccK);
        ShellK.setText("Shell Occupancy K: " + currentElement.shellOccK);
        TextView ShellL = findViewById(R.id.ShellOccL);
        ShellL.setText("Shell Occupancy L: " + currentElement.shellOccL);
        TextView ShellM = findViewById(R.id.ShellOccM);
        ShellM.setText("Shell Occupancy M: " + currentElement.shellOccM);
        TextView ShellN = findViewById(R.id.ShellOccN);
        ShellN.setText("Shell Occupancy N: " + currentElement.shellOccN);
        TextView ShellO = findViewById(R.id.ShellOccO);
        ShellO.setText("Shell Occupancy O: " + currentElement.shellOccO);
        TextView ShellP = findViewById(R.id.ShellOccP);
        ShellP.setText("Shell Occupancy P: " + currentElement.shellOccP);
        TextView ShellQ = findViewById(R.id.ShellOccQ);
        ShellQ.setText("Shell Occupancy Q: " + currentElement.shellOccQ);
        TextView ValencyCommon = findViewById(R.id.ValencyCommon);
        ValencyCommon.setText("Valency Common: " + currentElement.valencyCommon);
        TextView Valencies = findViewById(R.id.Valencies);
        Valencies.setText("Valencies : " + currentElement.valencies);
        TextView MeltingPoint = findViewById(R.id.MeltingPoint);
        MeltingPoint.setText("Melting Point: " + currentElement.meltingPoint);
        TextView BoilingPoint = findViewById(R.id.BoilingPoint);
        BoilingPoint.setText("Boiling Point: " + currentElement.boilingPoint);
        TextView Density = findViewById(R.id.Density);
        Density.setText("Density: " + currentElement.density);
        TextView IonicRadius = findViewById(R.id.IonicRadius);
        IonicRadius.setText("Ionic Radius in Common Valence state (nm): " + currentElement.ionicRadius);
        TextView KBeta = findViewById(R.id.KBeta);
        //need to add a header on display page to say what these values refer to
        KBeta.setText("K Beta: " + currentElement.kBeta);
        TextView KAlpha = findViewById(R.id.KAlpha);
        KAlpha.setText("K Alpha: " + currentElement.kAlpha);
        TextView LGamma23 = findViewById(R.id.LGamma23);
        LGamma23.setText("L Gamma 2/3: " + currentElement.lGamma23);
        TextView LGamma1 = findViewById(R.id.LGamma1);
        LGamma1.setText("L Gamma 1: " + currentElement.lGamma1);
        TextView LBeta4 = findViewById(R.id.LBeta4);
        LBeta4.setText("L Beta 4: " + currentElement.lBeta4);
        TextView LBeta3 = findViewById(R.id.LBeta3);
        LBeta3.setText("L Beta 3: " + currentElement.lBeta3);
        TextView LBeta2 = findViewById(R.id.LBeta2);
        LBeta2.setText("L Beta 2: " + currentElement.lBeta2);
        TextView LBeta1 = findViewById(R.id.LBeta1);
        LBeta1.setText("L Beta 1: " + currentElement.lBeta1);
        TextView LAlpha = findViewById(R.id.LAlpha);
        LAlpha.setText("L Alpha: " + currentElement.lAlpha);
        TextView MGamma = findViewById(R.id.MGamma);
        MGamma.setText("M Gamma: " + currentElement.mGamma);
        TextView MBeta = findViewById(R.id.MBeta);
        MBeta.setText("M Beta: " + currentElement.mBeta);
        TextView MAlpha = findViewById(R.id.MAlpha);
        MAlpha.setText("M Alpha: " + currentElement.mAlpha);
        //add another header to say these are the absorbtion edges
        TextView KEdge = findViewById(R.id.KEdge);
        KEdge.setText("K Edge: " + currentElement.kEdge);
        TextView L3Edge = findViewById(R.id.L3Edge);
        L3Edge.setText("L3 Edge: " + currentElement.l3Edge);
        TextView L2Edge = findViewById(R.id.L2Edge);
        L2Edge.setText("L2 Edge: " + currentElement.l2Edge);
        TextView L1Edge = findViewById(R.id.L1Edge);
        L1Edge.setText("L1 Edge: " + currentElement.l1Edge);
        TextView M5Edge = findViewById(R.id.M5Edge);
        M5Edge.setText("M5 Edge: " + currentElement.m5Edge);
        TextView M4Edge = findViewById(R.id.M4Edge);
        M4Edge.setText("M4 Edge: " + currentElement.m4Edge);
        TextView M3Edge = findViewById(R.id.M3Edge);
        M3Edge.setText("M3 Edge: " + currentElement.m3Edge);
        TextView M2Edge = findViewById(R.id.M2Edge);
        M2Edge.setText("M2 Edge: " + currentElement.m2Edge);
        TextView M1Edge = findViewById(R.id.M1Edge);
        M1Edge.setText("M1 Edge: " + currentElement.m1Edge);

        TextView KLM_Energies_Header = findViewById(R.id.KLM_Energies_Header);
        KLM_Energies_Header.setText("KLM Energies:");
        KLM_Energies_Header.setTextColor(ContextCompat.getColor(this,R.color.textBlack));
        KLM_Energies_Header.setTextSize(18);

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
