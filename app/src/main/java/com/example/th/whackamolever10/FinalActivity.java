package com.example.th.whackamolever10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    Button btnPlayAgain;
    TextView tvHighestScore;
    private int highestScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        String value = intent.getStringExtra("score"); //if it's a string you stored.
        final TextView txtScore = findViewById(R.id.tvFinalScore);
        txtScore.setText(value+"");

        btnPlayAgain = findViewById(R.id.buttonPlayAgain);
        tvHighestScore = findViewById(R.id.tvHighestScore);


        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        });

    }
}
