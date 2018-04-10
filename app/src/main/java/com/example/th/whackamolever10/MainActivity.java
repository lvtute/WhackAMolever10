package com.example.th.whackamolever10;


import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    final int HOLE = 0; // dang la cai lo~
    final int POW = 1;
    final int MOLE = 2; // dang la con chuot
    int Diem = 0;
    int Mang = 3;
    int level = 1;

    boolean isSmashed =true;
    int timeStep = 2000;

    static ArrayList<ScoreBoard> scoreArray = new ArrayList<>();


    GridView grid;
    ArrayList<Image> imageArrayList;
    ImageAdapter adapter;

    TextView txtDiem;
    TextView txtMang;

    TextView txtLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hihihi

        AnhXa();
        txtMang.setText("Lives: "+Mang);
        adapter = new ImageAdapter(this, R.layout.grid_item, imageArrayList);
        grid.setAdapter(adapter);

        final CountDownTimer timer = new CountDownTimer(20000, timeStep) {
            @Override
            public void onTick(long millisUntilFinished) {
                final int currentPosition = generateRandomNumber(0, 8);


                if (!isSmashed){
                    Mang--;
                    if (Mang==-1){
                        ScoreBoard newScore = new ScoreBoard("Thuan",  Diem);
                        scoreArray.add(newScore);


                        Intent myIntent = new Intent(MainActivity.this, FinalActivity.class);
                        myIntent.putExtra("score", Diem+""); //Optional parameters
                        startActivity(myIntent);
                        finish();

                    }
                    txtMang.setText("Lives: "+Mang);
                }
                isSmashed=false;

                changeImage(R.drawable.mole, currentPosition, MOLE);



            }

            @Override
            public void onFinish() {

                this.start();

            }
        }.start();

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tinhDiem(position);


                changeImage(R.drawable.pow, position, POW);


            }
        });
    }

    private void AnhXa() {
        grid = findViewById(R.id.grid);


        txtLevel = findViewById(R.id.tvLevel);
        txtDiem = findViewById(R.id.tvScore);
        txtMang = findViewById(R.id.tvLive);


        imageArrayList = new ArrayList<>();
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));
        imageArrayList.add(new Image(R.drawable.hole, HOLE));


    }

    private int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        int result = rand.nextInt(max - min + 1) + min;
        return result;
    }

    private void changeImage(int imgId, final int position, int state) {
        imageArrayList.set(position, new Image(imgId, state));
        adapter.notifyDataSetChanged();

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageArrayList.set(position, new Image(R.drawable.hole, HOLE));
                adapter.notifyDataSetChanged();
            }
        }, timeStep-50);


    }

    private void tinhDiem(int position){
        if (imageArrayList.get(position).getState() == MOLE) {

            Diem++;
            txtDiem.setText("Score: "+Diem);
            if ((Diem>level*5)&&(level<=10)){
                level++;
                timeStep-=180;
            }
            txtLevel.setText("Level "+level);
            isSmashed=true;
        }


    }
}
