package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myenglish.Controller.LessionWorkAdapter;
import com.example.myenglish.R;

import java.util.ArrayList;

public class NoteEnglish extends AppCompatActivity {
    private ArrayList<String> arr = new ArrayList<>();
    private ArrayList<String> arrSearch = new ArrayList<>();
    private ListView lstLession;
    private LessionWorkAdapter adapter;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_english);
        initialData();

        lstLession = (ListView) findViewById(R.id.lst_lession_work);
        adapter = new LessionWorkAdapter(arr,this);
        lstLession.setAdapter(adapter);

        edtSearch = (EditText) findViewById(R.id.edt_search_work);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchLession(edtSearch.getText().toString());
            }
        });

    }
    private void searchLession(String input){
        if(input.trim().length()>0){
            arrSearch.clear();
            for(int i=0;i<arr.size();i++){
                if(arr.get(i).trim().toLowerCase().contains(input.trim().toLowerCase())){
                    arrSearch.add(arr.get(i));
                }
            }
            adapter = new LessionWorkAdapter(arrSearch,this);
            lstLession.setAdapter(adapter);
        }
        else {
            adapter = new LessionWorkAdapter(arr,this);
            lstLession.setAdapter(adapter);
        }
    }

    private void initialData(){
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Bye : tam biet");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
        arr.add("Hello : xin chao");
    }

}