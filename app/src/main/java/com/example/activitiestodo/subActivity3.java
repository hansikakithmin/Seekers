package com.example.activitiestodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activitiestodo.database.DBHelper;

public class subActivity3 extends AppCompatActivity {
    EditText etSetdate2, etNumberofParticipants2,etResult_2;
    private Button calculate;
    private EditText Package_Price;
    private EditText Number_of_Participants;
    private EditText Total_Price;
    private View Multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        Multiply = findViewById(R.id.btnCalculate_2);
        Package_Price = findViewById(R.id.etNum3);
        Number_of_Participants = findViewById(R.id.etNum4);
        Total_Price = findViewById(R.id.etResult_2);

        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double d,e,f;
                d = Double.parseDouble(Package_Price.getText().toString());
                e = Double.parseDouble(Number_of_Participants.getText().toString());
                f = d*e;
                Total_Price.setText(Double.toString(f));
            }
        });
    }
    public void savePackage(View view){
        String set_date= etSetdate2.getText().toString();
        String number_of_participants= etNumberofParticipants2.getText().toString();
        String package_price = etResult_2.getText().toString();
        DBHelper dbHelper = new DBHelper(this);

        if(set_date.isEmpty()||number_of_participants.isEmpty()||package_price.isEmpty()){
            Toast.makeText(this, "Enter Values", Toast.LENGTH_SHORT).show();
        }else{
            long inserted2 = dbHelper.addInfo(set_date,number_of_participants,package_price);

            if(inserted2>0){
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"failed to insert",Toast.LENGTH_SHORT).show();
            }

        }

    }
}