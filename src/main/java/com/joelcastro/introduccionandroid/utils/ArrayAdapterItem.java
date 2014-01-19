package com.joelcastro.introduccionandroid.utils;

/**
 * Created by alu03009 on 21/11/13.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joelcastro.introduccionandroid.R;

import java.io.InputStream;

public class ArrayAdapterItem extends ArrayAdapter<ItemListParada> {

    Context mContext;
    int layoutResourceId;
    ItemListParada data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, ItemListParada[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }


        ItemListParada objectItem = data[position];


        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.itemName);
        textViewItem.setTag(objectItem.itemId);



        new DownloadImageTask((ImageView) convertView.findViewById(R.id.image4List))
                .execute(objectItem.urlImage);
        return convertView;

    }



}