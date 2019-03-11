package com.pta.joshhamwee.onbuttonclickactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private static final int[] button_ids = {
            R.id.b1,
            R.id.b2,
            R.id.b3,
            R.id.b4,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (final int id : button_ids) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println(id);
                    openActivity2(id);

                }
            });
        }
    }


    public void openActivity2(Integer id){
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }


}
