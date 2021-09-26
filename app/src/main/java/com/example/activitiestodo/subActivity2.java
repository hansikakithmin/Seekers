package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity2 extends AppCompatActivity {
    EditText etSetdate1, etNumberofParticipants1,etResult;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        etSetdate1 = findViewById(R.id.etSetdate1);
        etNumberofParticipants1 = findViewById(R.id.etNumberofparticipants1);
        etResult = findViewById(R.id.etResult);


        Multiply = findViewById(R.id.btnCalculate);
        Package_Price = findViewById(R.id.etNum1);
        Number_of_Participants = findViewById(R.id.etNum2);
        Total_Price = findViewById(R.id.etResult);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a,b,c;
                a = Double.parseDouble(Package_Price.getText().toString());
                b = Double.parseDouble(Number_of_Participants.getText().toString());
                c = a*b;
                Total_Price.setText(Double.toString(c));
            }
        });

    }
    public void savePackage(View view){
        String set_date= etSetdate1.getText().toString();
        String number_of_participants= etNumberofParticipants1.getText().toString();
        String package_price = etResult.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
           long inserted = dbHelper.addInfo(set_date,number_of_participants,package_price);

           if(inserted>0){
               Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
           }


        }

    }
}