package com.example.a8_94;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.t3_spinner)
    Spinner spinner;
    @BindView(R.id.t3_btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        String s = getIntent().getStringExtra("iName");

        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        arrayList.add("Not Selected");
        if(s.equals("CSPIT")) {
            arrayList.add("IT");
            arrayList.add("CSE");
            arrayList.add("CE");
        }else if(s.equals("DEPSTAR")){
            arrayList.add("DP-IT");
            arrayList.add("DP-CSE");
            arrayList.add("DP-CE");
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_list_item_1, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);
                spinner.setOnItemSelectedListener(this);


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String s = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),s , Toast.LENGTH_SHORT).show();
        btn.setOnClickListener(v->{
            if(s.equals("IT")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://charusat.ac.in/cspit/it/"));
                startActivity(intent);
            }
            else if(s.equals("CSE")){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://charusat.ac.in/cspit/cse/"));
                startActivity(intent);
            }
            else if(s.equals("CE")){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://charusat.ac.in/cspit/ce/"));
                startActivity(intent);
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}