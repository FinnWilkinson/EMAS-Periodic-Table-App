package com.example.joshhamwee.periodictablemain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayElementDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_element_data);

        //Get the ID Data that was passed from main activity
        Integer id;
        Bundle dataFromMain = getIntent().getExtras();
        id = dataFromMain.getInt("ElementID");

        //create a new database instance
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);

        //Create an element object that relates to the specific ID
        CurrentElement currentElement = new CurrentElement(id, databaseAccess);

        //Temporary TextView with element name
        TextView ElementName = findViewById(R.id.ElementName);
        ElementName.setText(currentElement.shellOccK);
    }
}
