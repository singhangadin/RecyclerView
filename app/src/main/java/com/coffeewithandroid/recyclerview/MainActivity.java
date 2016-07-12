package com.coffeewithandroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coffeewithandroid.recyclerview.Adapters.RecyclerViewAdapter;
import com.coffeewithandroid.recyclerview.Data.SampleData;
import com.coffeewithandroid.recyclerview.Template.RecyclerViewSeparator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SampleData> sampleDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    /*
    * Creating Sample Data to load in Recycler View
    **/
    private String[] arrTitle = {"Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"};
    private String[] arrDate = {"01-01-2016", "01-02-2016", "01-03-2016", "01-04-2016", "01-05-2016", "01-06-2016", "01-07-2016", "01-01-2016", "01-02-2016", "01-03-2016", "01-04-2016", "01-05-2016", "01-06-2016", "01-07-2016"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Recycler View and Adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerViewAdapter = new RecyclerViewAdapter(sampleDataList);

        //Setting up Layout Manager to Recyler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //This is used to setup Divider line after every Recycler View Item
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecyclerViewSeparator(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(recyclerViewAdapter);

        //Calling method to initializing Data in arraylist
        getData();

    }

    //Method used to populate Arraylis with sample data
    private void getData() {

        for (int i = 0; i < arrTitle.length; i++) {
            SampleData sampleData = new SampleData(arrTitle[i], arrDate[i], "");
            sampleDataList.add(sampleData);
        }

        //Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself.
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
