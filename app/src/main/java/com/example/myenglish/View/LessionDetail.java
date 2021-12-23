package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myenglish.Controller.DetailLessionAdapter;
import com.example.myenglish.R;

public class LessionDetail extends AppCompatActivity {
    private ViewPager viewPager;
    private DetailLessionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lession_detail);

        viewPager  = (ViewPager) findViewById(R.id.view_pager);
        adapter = new DetailLessionAdapter(this, MainActivity.arr);

        viewPager.setAdapter(adapter);

        int id = getIntent().getExtras().getInt("lession_id");
        viewPager.setCurrentItem(id);

    }
}