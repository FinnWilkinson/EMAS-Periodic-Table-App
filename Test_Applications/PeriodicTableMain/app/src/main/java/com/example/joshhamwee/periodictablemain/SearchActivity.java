package com.example.joshhamwee.periodictablemain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Assign the list view from the xml a variable
        ListView elementsList = (ListView) findViewById(R.id.listViewElements);
        ArrayList<String> arrayElements = new ArrayList<>();
        arrayElements.addAll(Arrays.asList(getResources().getStringArray(R.array.array_elements))); //Add elements to the list view

        //Create new array adapter for the list View
        adapter = new ArrayAdapter<String>(
                SearchActivity.this,
                android.R.layout.simple_list_item_1,
                arrayElements);
        elementsList.setAdapter(adapter);

        //Create an onClickListener for each item that opens up a new activity
        elementsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                handelListItemClick(selectedItem);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void handelListItemClick(String selectedItem) {
        String[] splitElementName = selectedItem.split(" - ");
        Intent intent = new Intent(this,DisplayElementDataActivity.class); //Create the intent that opens the new activity
        intent.putExtra("ElementIDSearch",Integer.parseInt(splitElementName[2]));  //Put extra data into the intent so that next activity knows what element was clicked on
        startActivity(intent); //Execute the intent
    }
}
