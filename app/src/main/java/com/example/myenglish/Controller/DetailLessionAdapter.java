package com.example.myenglish.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myenglish.Model.LessionModel;
import com.example.myenglish.R;

import java.util.ArrayList;

public class DetailLessionAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<LessionModel> arr;

    public DetailLessionAdapter(Context context, ArrayList<LessionModel> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view  = inflater.inflate(R.layout.lession_dettail_item,container,false);


        WebView webView = (WebView) view.findViewById(R.id.web_view);
        String url = "file:///android_asset/"+ arr.get(position).lessionName+".htm";
        url = url.replace(" ","%20");
        webView.loadUrl(url);
        // hien thi zoom in zoom out
        webView.getSettings().setBuiltInZoomControls(true);
        container.addView(view);
        return view;
    }
}
