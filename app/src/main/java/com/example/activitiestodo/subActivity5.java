package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity5 extends AppCompatActivity {
    EditText etSetdate4, etNumberofParticipants4,etResult_4;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub5);

        Multiply = findViewById(R.id.btnCalculate_4);
        Package_Price = findViewById(R.id.etNum7);
        Number_of_Participants = findViewById(R.id.etNum8);
        Total_Price = findViewById(R.id.etResult_4);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double j,k,l;
                j = Double.parseDouble(Package_Price.getText().toString());
                k = Double.parseDouble(Number_of_Participants.getText().toString());
                l = j*k;
                Total_Price.setText(Double.toString(l));
            }
        });
    }
    public void savePackage(View view){
        String set_date= etSetdate4.getText().toString();
        String number_of_participants= etNumberofParticipants4.getText().toString();
        String package_price = etResult_4.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            long inserted4 = dbHelper.addInfo(set_date,number_of_participants,package_price);

            if(inserted4>0){
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
            }

        }

    }
}