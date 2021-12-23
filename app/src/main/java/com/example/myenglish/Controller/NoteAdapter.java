package com.example.myenglish.Controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.myenglish.Model.NoteModel;
import com.example.myenglish.R;
import com.example.myenglish.View.NoteWord;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private ArrayList<NoteModel> arr;

    public NoteAdapter(Context context, ArrayList<NoteModel> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return this.arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        View rowView = view;
//        if(rowView==null){
//            LayoutInflater inflater = ((Activity) this.context).getLayoutInflater();
//            rowView = inflater.inflate(R.layout.note_item,viewGroup,false);
//
//        }
        LayoutInflater inflater= LayoutInflater.from(this.context);
        View rowView = inflater.inflate(R.layout.note_item, viewGroup,false);
        TextView btnnote = rowView.findViewById(R.id.txt_note_edt);
        ImageView btndelete = rowView.findViewById(R.id.btn_deletenote);

        btndelete.setTag(arr.get(i));
        btndelete.setOnClickListener(this);

        btnnote.setText(arr.get(i).getNote());
        return rowView;
    }

    @Override
    public void onClick(View view) {
        ((NoteWord) this.context).deleteNote((NoteModel) view.getTag());
    }
}
