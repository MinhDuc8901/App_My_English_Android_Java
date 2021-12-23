package com.example.myenglish.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.myenglish.Model.NoteModel;

import java.util.ArrayList;

public class NoteDataSource {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private String[] allColumns = {NoteSQLite.COLUMN_ID,NoteSQLite.COLUMN_NOTE};
    private Context context;

    public NoteDataSource(Context context) {
        this.context = context;
        sqLiteOpenHelper = new NoteSQLite(context);
    }

    public void open (){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public  void close (){
        sqLiteDatabase.close();
    }

    public void addNewNote(String note){
        ContentValues values = new ContentValues();
        values.put(NoteSQLite.COLUMN_NOTE,note);
        sqLiteDatabase.insert(NoteSQLite.TABLE_NAME,null,values);
        Toast.makeText(this.context,"thêm note mới thành công",Toast.LENGTH_SHORT).show();
    }
    public  void deleteNote(NoteModel note){
        sqLiteDatabase.delete(NoteSQLite.TABLE_NAME, NoteSQLite.COLUMN_ID+"="+note.getId(),null);
        Toast.makeText(this.context,"xóa ghi chú thành công",Toast.LENGTH_SHORT).show();

    }

    public ArrayList<NoteModel> getAllNotes(){
        ArrayList<NoteModel> arr = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(NoteSQLite.TABLE_NAME,allColumns,null,null,null,null,null);
        if(cursor==null){
            return null;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            NoteModel model = cursorToModel(cursor);
            arr.add(model);
            cursor.moveToNext();
        }
        return arr;
    }

    public NoteModel cursorToModel(Cursor cursor){
        NoteModel model = new NoteModel();
        model.setId(cursor.getInt(0));
        model.setNote(cursor.getString(1));
        return model;
    }

}
