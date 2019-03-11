package com.pta.joshhamwee.onbuttonclickactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Integer id;
        System.out.println("Test");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle dataFromMain = getIntent().getExtras();
        //if(dataFromMain != null) {
        id = dataFromMain.getInt("id");
        //}
        System.out.println(id);

        currentElement current = new currentElement(id);

        TextView header = new TextView(this);

        header = (TextView) findViewById(R.id.elementHeader);
        header.setText(current.getName());

    }
}
