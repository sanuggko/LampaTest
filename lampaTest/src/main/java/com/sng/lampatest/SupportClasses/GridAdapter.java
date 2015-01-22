package com.sng.lampatest.SupportClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.sng.lampatest.R;

import java.util.ArrayList;

/**
 * Created by Alexandr on 22.01.2015.
 */
public class GridAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();
    private ImageView image;

    public GridAdapter(Context context, int layoutResourceId,
                       ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);
            image = (ImageView) row.findViewById(R.id.image);
            row.setTag(image);
        } else {
            image = (ImageView) row.getTag();
        }


        image.setImageResource((Integer) data.get(position));
        return row;
    }

}
