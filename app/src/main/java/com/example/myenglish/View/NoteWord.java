package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myenglish.Controller.NoteAdapter;
import com.example.myenglish.Controller.NoteDataSource;
import com.example.myenglish.Model.NoteModel;
import com.example.myenglish.R;

import java.util.ArrayList;

public class NoteWord extends AppCompatActivity implements View.OnClickListener {
    private Button btnadd;
    private EditText edtNote;
    private ListView lstNote;
    private TextView lblNote;

    private NoteDataSource dataSource;
    private ArrayList<NoteModel> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_word);
        btnadd = findViewById(R.id.btn_addnote);
        edtNote = findViewById(R.id.txt_note);
        lstNote = findViewById(R.id.List_note);

        btnadd.setOnClickListener(this);

        dataSource = new NoteDataSource(this);
        dataSource.open();
        arr=dataSource.getAllNotes();
        if(arr!=null){
            NoteAdapter adapter = new NoteAdapter(this,arr);
            lstNote.setAdapter(adapter);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.btn_addnote){
            String note = edtNote.getText().toString();
            if(note.trim().length()>0){
                dataSource.addNewNote(note);
                arr=dataSource.getAllNotes();
                if(arr!=null){
                    NoteAdapter adapter = new NoteAdapter(this,arr);
                    lstNote.setAdapter(adapter);
                }
                edtNote.setText("");

            }
            else {
                Toast.makeText(this,"hãy nhập vào để có thể thêm note ",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void deleteNote(NoteModel note){
        dataSource.deleteNote(note);
        arr=dataSource.getAllNotes();
        if(arr!=null){
            NoteAdapter adapter = new NoteAdapter(this,arr);
            lstNote.setAdapter(adapter);
        }
        Toast.makeText(this,"xóa thành công",Toast.LENGTH_SHORT).show();
    }
}