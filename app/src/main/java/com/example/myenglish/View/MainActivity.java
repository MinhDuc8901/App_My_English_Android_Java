package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myenglish.Controller.LessionAdapter;
import com.example.myenglish.Model.LessionModel;
import com.example.myenglish.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    public final int NORMAL_MODE =0;
    public final int SEARCH_MODE = 1;
    private int currenMode = NORMAL_MODE;


    public static ArrayList<LessionModel> arr = new ArrayList<>();
    private ArrayList<LessionModel> arrSearch = new ArrayList<>();
    private ListView lstLession;
    private LessionAdapter adapter;
    private EditText editSearch;

    private Button btnSearch,btnNote,btnGame,btnnoteeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();
        btnSearch = (Button) findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);

        btnNote = (Button) findViewById(R.id.btn_note);
        btnNote.setOnClickListener(this);

        btnGame = (Button) findViewById(R.id.btn_game);
        btnGame.setOnClickListener(this);

        btnnoteeng = findViewById(R.id.btn_note_eng);
        btnnoteeng.setOnClickListener(this);


        lstLession = (ListView) findViewById(R.id.lst_lession);
        adapter = new LessionAdapter(this,arr);
        lstLession.setAdapter(adapter);

        editSearch = (EditText) findViewById(R.id.edi_search);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchLession(editSearch.getText().toString());

            }
        });

        lstLession.setOnItemClickListener(this);


    }

    private void searchLession(String input){
        if(input.trim().length()>0){
            arrSearch.clear();
            for(int i=0;i<arr.size();i++){
                if(arr.get(i).lessionName.trim().toLowerCase().contains(input.trim().toLowerCase())){
                    arrSearch.add(arr.get(i));
                }
            }
            currenMode = SEARCH_MODE;
            adapter = new LessionAdapter(this,arrSearch);
            lstLession.setAdapter(adapter);
        }
        else {
            currenMode= NORMAL_MODE;
            adapter = new LessionAdapter(this,arr);
            lstLession.setAdapter(adapter);
        }
    }

    private void initialData(){

        arr.add(new LessionModel(1,"About"));
        arr.add(new LessionModel(1,"Asking questions 1"));
        arr.add(new LessionModel(1,"Asking questions 2"));
        arr.add(new LessionModel(1,"Can have and could have"));
        arr.add(new LessionModel(1,"Can"));
        arr.add(new LessionModel(1,"Could"));
        arr.add(new LessionModel(1,"For"));
        arr.add(new LessionModel(1,"For 2"));
        arr.add(new LessionModel(1,"Going to or will"));
        arr.add(new LessionModel(1,"Had better"));
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, LessionDetail.class);
//        if(currenMode==NORMAL_MODE){
//            intent.putExtra("lession_id",arr.get(i).id);
//        }
//        else{
//            intent.putExtra("lession_id",arrSearch.get(i).id);
//        }
//        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        intent.putExtra("lession_id",i);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.btn_search){
            Intent intent = new Intent(this, SearchWeb.class);
            startActivity(intent);
        }
        if(id==R.id.btn_note){
            Intent intent = new Intent(this, Translator.class);
            startActivity(intent);
        }
        if(id==R.id.btn_game){
            Intent intent = new Intent(this, English.class);
            startActivity(intent);
        }
        if(id==R.id.btn_note_eng){
            Intent intent = new Intent(this, NoteWord.class);
            startActivity(intent);
        }


    }
}