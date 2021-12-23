package com.example.myenglish.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myenglish.R;

import java.util.ArrayList;

public class LessionWorkAdapter extends BaseAdapter {
    private ArrayList<String> arr;
    private Context context;

    public LessionWorkAdapter(ArrayList<String> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(this.context);
        View rowView = inflater.inflate(R.layout.lession_item_work, viewGroup,false);
        TextView lblName = (TextView) rowView.findViewById(R.id.lbl_lession_work);
        lblName.setText(this.arr.get(i));
        return rowView;
    }
}
