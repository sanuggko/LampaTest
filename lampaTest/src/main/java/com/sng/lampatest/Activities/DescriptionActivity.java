package com.sng.lampatest.Activities;

/**
 * Created by Alexandr on 22.01.2015.
 */
import android.app.ActionBar;
import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.sng.lampatest.R;
import com.sng.lampatest.SupportClasses.GridAdapter;

import java.util.ArrayList;


public class DescriptionActivity extends Activity {

    private TextView taskNumberTxt;
    private TextView fullTaskDescriptionTxt;

    private String taskNumber;
    private String fullTaskDescription;
    private String[] tempArray;

    private GridView gridView;
    private GridAdapter customGridAdapter;

    private ArrayList<Integer> imageIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_layout);

        taskNumberTxt = (TextView) findViewById(R.id.taskNumberTxt2);
        fullTaskDescriptionTxt = (TextView) findViewById(R.id.fullDescriptionTxt);

        Intent intent = getIntent();
        tempArray = intent.getStringExtra("fullDescription").split("_");

        taskNumber = tempArray[0];
        fullTaskDescription = tempArray[1];

        taskNumberTxt.setText(taskNumber);
        fullTaskDescriptionTxt.setText(fullTaskDescription);

        gridView = (GridView) findViewById(R.id.gridView);
        customGridAdapter = new GridAdapter(this, R.layout.custom_grid_layout, initArray());
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startImageViewerActivity(position);
            }

        });

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(" ");
    }

    public ArrayList<Integer> initArray () {
        imageIDs = new ArrayList<Integer>();

        imageIDs.add(R.drawable.pic1);
        imageIDs.add(R.drawable.pic2);
        imageIDs.add(R.drawable.pic3);
        imageIDs.add(R.drawable.pic4);
        imageIDs.add(R.drawable.pic5);

        return imageIDs;
    }

    public void startImageViewerActivity (int  position){
        Intent intent = new Intent(getApplicationContext(), ImageViewerActivity.class);
        intent.putExtra("id",position);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
