package com.example.joshhamwee.onbuttonclickactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonHydrogen;
    private Button buttonHelium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonHydrogen = (Button) findViewById(R.id.openActivity2_0);
        buttonHelium = (Button) findViewById(R.id.openActivity2_1);
        buttonHydrogen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2(1);
            }
        });
        buttonHelium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2(2);
            }
        });
    }

    public void openActivity2(Integer id){
        Intent intent = new Intent(this,Activity2.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

}
