package com.coffeewithandroid.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.coffeewithandroid.recyclerview.Adapters.RecyclerViewAdapter;
import com.coffeewithandroid.recyclerview.Data.SampleData;
import com.coffeewithandroid.recyclerview.Template.OnItemClickListener;
import com.coffeewithandroid.recyclerview.Template.OnItemLongClickListener;
import com.coffeewithandroid.recyclerview.Template.RecyclerViewTouchHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SampleData> sampleDataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    //Handles Touch Events on RecyclerView
    private RecyclerViewTouchHandler handler;

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
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        //recyclerView.addItemDecoration(new RecyclerViewSeparator(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(recyclerViewAdapter);

        //Calling method to initializing Data in arraylist
        getData();

        //Initialise the Handler with context and RecyclerView
        handler=new RecyclerViewTouchHandler(this,recyclerView);

        //Add Action to perform on Click Events Using OnItemClickListener created
        handler.setOnClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View V, int position) {
                //Method gives a reference of Clicked List Item and the Adapter position
                //Action to be performed on click
                Toast.makeText(getBaseContext(),"Item "+(position+1)+" is Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        //Add Action to perform on Click Events Using OnItemClickListener created
        handler.setOnlongClickListener(new OnItemLongClickListener() {
            @Override
            public void onClick(View V, int position) {
                //Method gives a reference of Clicked List Item and the Adapter position
                //Action to be performed on long click
                Toast.makeText(getBaseContext(),"Item "+(position+1)+" is Long Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Method used to populate Arraylist with sample data
    private void getData() {

        for (int i = 0; i < arrTitle.length; i++) {
            SampleData sampleData = new SampleData(arrTitle[i], arrDate[i], "");
            sampleDataList.add(sampleData);
        }

        //Notifies the attached observers that the underlying data has been changed and any View reflecting the data set should refresh itself.
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
