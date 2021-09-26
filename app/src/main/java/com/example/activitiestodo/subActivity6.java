package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity6 extends AppCompatActivity {
    EditText etSetdate5, etNumberofParticipants5,etResult_5;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub6);

        Multiply = findViewById(R.id.btnCalculate_5);
        Package_Price = findViewById(R.id.etNum9);
        Number_of_Participants = findViewById(R.id.etNum10);
        Total_Price = findViewById(R.id.etResult_5);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double m,n,o;
                m = Double.parseDouble(Package_Price.getText().toString());
                n = Double.parseDouble(Number_of_Participants.getText().toString());
                o = m*n;
                Total_Price.setText(Double.toString(o));
            }
        });
    }

    public void savePackage(View view){
        String set_date= etSetdate5.getText().toString();
        String number_of_participants= etNumberofParticipants5.getText().toString();
        String package_price = etResult_5.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
           long inserted5 = dbHelper.addInfo(set_date,number_of_participants,package_price);

            if(inserted5>0){
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
            }

        }

    }
}