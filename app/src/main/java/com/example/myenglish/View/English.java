package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myenglish.R;

public class English extends AppCompatActivity implements View.OnClickListener {
    private ImageView btnPlay ,btnOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        btnPlay = (ImageView) findViewById(R.id.btn_play);
        btnOut = (ImageView) findViewById(R.id.btn_out);

        btnOut.setOnClickListener(this);

        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn_play){
            Intent intent = new Intent(this, EnglishPlay.class);
            startActivity(intent);
        }
        if(id == R.id.btn_out){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}