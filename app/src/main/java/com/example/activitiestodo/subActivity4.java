package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity4 extends AppCompatActivity {
    EditText etSetdate3, etNumberofParticipants3,etResult_3;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        Multiply = findViewById(R.id.btnCalculate_3);
        Package_Price = findViewById(R.id.etNum5);
        Number_of_Participants = findViewById(R.id.etNum6);
        Total_Price = findViewById(R.id.etResult_3);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double g,h,i;
                g = Double.parseDouble(Package_Price.getText().toString());
                h = Double.parseDouble(Number_of_Participants.getText().toString());
                i = g*h;
                Total_Price.setText(Double.toString(i));
            }
        });
    }

    public void savePackage(View view){
        String set_date= etSetdate3.getText().toString();
        String number_of_participants= etNumberofParticipants3.getText().toString();
        String package_price = etResult_3.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            long inserted3=dbHelper.addInfo(set_date,number_of_participants,package_price);

            if(inserted3>0){
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
            }

        }

    }
}