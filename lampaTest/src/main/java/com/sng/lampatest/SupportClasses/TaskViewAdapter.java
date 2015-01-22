package com.sng.lampatest.SupportClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sng.lampatest.Models.TaskModel;
import com.sng.lampatest.R;

import java.util.ArrayList;


/**
 * Created by Alexandr on 21.01.2015.
 */
public class TaskViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TaskModel> taskModels;

    public TaskViewAdapter(Context context, ArrayList<TaskModel> taskModels){
        this.context = context;
        this.taskModels = taskModels;
    }

    @Override
    public int getCount() {
        return taskModels.size();
    }

    @Override
    public Object getItem(int position) {
        return taskModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_item_layout, null);
        }

        TaskModel task = taskModels.get(position);

        TextView taskNumberTxt = (TextView) view.findViewById(R.id.taskNumberTxt);
        TextView smallTaskDescriptionTxt = (TextView) view.findViewById(R.id.smallDescriptionTxt);

        taskNumberTxt.setText(task.getTaskNumber() + (position + 1));
        smallTaskDescriptionTxt.setText(task.getSmallDescription());

        return view;
    }
}
