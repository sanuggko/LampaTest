package com.sng.lampatest.Activities;

/**
 * Created by Alexandr on 22.01.2015.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sng.lampatest.R;
import com.sng.lampatest.SupportClasses.ImageViewerAdapter;

import java.util.ArrayList;

public class ImageViewerActivity extends Activity {

    private ArrayList<Integer> imageIDs;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer_layout);

        imageIDs = new DescriptionActivity().initArray();

        viewPager = (ViewPager) findViewById(R.id.pager);
        int position = getIntent().getIntExtra("id", 0);

        ImageViewerAdapter adapter = new ImageViewerAdapter(getApplicationContext(), imageIDs);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.closeBtn) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
