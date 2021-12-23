package com.example.myenglish.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myenglish.Model.LessionModel;
import com.example.myenglish.R;

import java.util.ArrayList;

public class LessionAdapter extends BaseAdapter {
    private ArrayList<LessionModel> arr;
    private Context context;
    public LessionAdapter(Context context, ArrayList<LessionModel> arr){
        this.context  = context;
        this.arr=arr;
    }

    @Override
    public int getCount() {
        return this.arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return arr.get(i).id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.context);

        View rowView = inflater.inflate(R.layout.lession_item,viewGroup,false);
        TextView lblName =   rowView.findViewById(R.id.lbl_lession);
        lblName.setText(this.arr.get(i).lessionName);
        return rowView;
    }
}
