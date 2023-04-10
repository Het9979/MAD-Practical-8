package com.example.a8_94;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.IMG_BTN1)
    ImageButton btn_cspit;
    @BindView(R.id.IMG_BTN2)
    ImageButton btn_cmpica;
    @BindView(R.id.IMG_BTN3)
    ImageButton btn_depstar;
    @BindView(R.id.IMG_BTN4)
    ImageButton btn_pdpis;
    @BindView(R.id.IMG_BTN5)
    ImageButton btn_i2im;
    @BindView(R.id.IMG_BTN6)
    ImageButton btn_rpcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        btn_cspit.setOnClickListener(v->{
            callByInstituteName("CSPIT");
        });
        btn_depstar.setOnClickListener(v->{
            callByInstituteName("DEPSTAR");
        });
        btn_cmpica.setOnClickListener(v->{
            callByInstituteName("CMPICA");
        });
        btn_pdpis.setOnClickListener(v->{
            callByInstituteName("PDPIS");
        });
        btn_i2im.setOnClickListener(v ->{
            callByInstituteName("I2IM");
        });
        btn_rpcp.setOnClickListener(v ->{
            callByInstituteName("RPCP");
        });
    }
    private void callByInstituteName(String instituteName){
        Log.d("----------------------->",instituteName);
        Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
        intent.putExtra("iName",instituteName);
        startActivity(intent);
    }
}

