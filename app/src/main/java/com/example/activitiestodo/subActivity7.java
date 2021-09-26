package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity7 extends AppCompatActivity {
    EditText etSetdate6, etNumberofParticipants6,etResult_6;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub7);

        Multiply = findViewById(R.id.btnCalculate_6);
        Package_Price = findViewById(R.id.etNum11);
        Number_of_Participants = findViewById(R.id.etNum12);
        Total_Price = findViewById(R.id.etResult_6);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double p,q,r;
                p = Double.parseDouble(Package_Price.getText().toString());
                q = Double.parseDouble(Number_of_Participants.getText().toString());
                r = p*q;
                Total_Price.setText(Double.toString(r));
            }
        });
    }
    public void savePackage(View view){
        String set_date= etSetdate6.getText().toString();
        String number_of_participants= etNumberofParticipants6.getText().toString();
        String package_price = etResult_6.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            long inserted6=dbHelper.addInfo(set_date,number_of_participants,package_price);

            if(inserted6>0){
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
            }

        }

    }
}