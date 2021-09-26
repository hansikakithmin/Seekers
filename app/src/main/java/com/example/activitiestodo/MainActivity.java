package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActivity2();
            }
        });

        button= findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActivity3();
            }
        });

        button= findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActivity4();
            }
        });

        button= findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActiviy5();
            }
        });

        button= findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActiviy6();
            }
        });

        button= findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensubActiviy7();
            }
        });
    }
    public void opensubActivity2(){
        Intent intent = new Intent(this,subActivity2.class);
        startActivity(intent);
    }

    public void opensubActivity3(){
        Intent intent = new Intent(this,subActivity3.class);
        startActivity(intent);
    }

    public void opensubActivity4(){
        Intent intent = new Intent(this,subActivity4.class);
        startActivity(intent);
    }

    public void opensubActiviy5(){
        Intent intent = new Intent(this,subActivity5.class);
        startActivity(intent);
    }

    public void opensubActiviy6(){
        Intent intent = new Intent(this,subActivity6.class);
        startActivity(intent);
    }

    public void opensubActiviy7(){
        Intent intent = new Intent(this,subActivity7.class);
        startActivity(intent);
    }
}