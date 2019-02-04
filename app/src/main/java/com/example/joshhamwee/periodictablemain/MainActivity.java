package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    //Array of button id's to iterate over all buttons and set on click listeners
    Integer[] listOfIds = {
            R.id.H,R.id.He,R.id.Li,R.id.Be,R.id.B,R.id.C,R.id.N,R.id.O,R.id.F,R.id.Ne,R.id.Na,R.id.Mg,R.id.Al,R.id.Si,R.id.P,R.id.S,R.id.Cl,R.id.Ar,
            R.id.K,R.id.Ca,R.id.Sc,R.id.Ti,R.id.V,R.id.Cr,R.id.Mn,R.id.Fe,R.id.Co,R.id.Ni,R.id.Cu,R.id.Zn,R.id.Ga,R.id.Ge,R.id.As,R.id.Se,R.id.Br,R.id.Kr,
            R.id.Rb,R.id.Sr,R.id.Y,R.id.Zr,R.id.Nb,R.id.Mo,R.id.Tc,R.id.Ru,R.id.Rh,R.id.Pd, R.id.Ag, R.id.Cd, R.id.In, R.id.Sn, R.id.Sb, R.id.Te, R.id.I, R.id.Xe,
            R.id.Cs, R.id.Ba, R.id.La, R.id.Ce, R.id.Pr, R.id.Nd, R.id.Pm, R.id.Sm, R.id.Eu, R.id.Gd, R.id.Tb, R.id.Dy, R.id.Ho, R.id.Er, R.id.Tm, R.id.Yb, R.id.Lu,
            R.id.Hf, R.id.Ta, R.id.W, R.id.Re, R.id.Os, R.id.Ir, R.id.Pt, R.id.Au, R.id.Hg, R.id.Tl, R.id.Pb, R.id.Bi, R.id.Po, R.id.At, R.id.Rn,
            R.id.Fr, R.id.Ra, R.id.Ac, R.id.Th, R.id.Pa, R.id.U, R.id.Np, R.id.Pu, R.id.Am, R.id.Cm, R.id.Bk, R.id.Cf, R.id.Es, R.id.Fm, R.id.Md, R.id.No, R.id.Lr


    };
    private ArrayList<Integer> button_ids = new ArrayList<>(Arrays.asList(listOfIds));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar(); //Function that handles the toolbar, see below
        setUpElements(); //Function that handles each button for the elemnts

    }

    //When an element is clicked on, open new activity
    private void openActivityDisplayElementData(int id){
        Intent intent = new Intent(this,DisplayElementDataActivity.class); //Create the intent that opens the new activity
        intent.putExtra("ElementID",button_ids.indexOf(id) + 1);  //Put extra data into the intent so that next activity knows what element was clicked on
        startActivity(intent); //Execute the intent
    }

    //When help page is selected from drawer, start the new activity
    private void openHelpActivity(){
        Intent intent = new Intent(this, HelpActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }

    private void openEnergyActivity(){
        Intent intent = new Intent(this, EnergyActivity.class); //Create the intent that opens the new activity
        startActivity(intent); //Execute the intent
    }


    private void setUpElements(){
        //For loop to create onClickListeners for each button
        //Override the onClick method to openActivityDisplayElementData
        for (final int id:button_ids){
            ImageButton button = (ImageButton) findViewById(id);
            button.bringToFront();
            button.setOnClickListener(null);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivityDisplayElementData(id);
                }
            });
        }
    }

    private void setUpToolbar(){
        drawerLayout = findViewById(R.id.drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.home:
                                menuItem.setChecked(true);
                                break;
                            case R.id.graph:
                                menuItem.setChecked(true);
                                openEnergyActivity();
                                break;
                            case R.id.help:
                                menuItem.setChecked(true);
                                openHelpActivity();
                                break;
                        }
                        return false;
                    }
                }
        );
    }

    //Create an option for the search button in the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    //When the search button is clicked, start the search
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_m:
                //start search dialog
                super.onSearchRequested();
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
