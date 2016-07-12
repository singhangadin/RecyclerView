package com.coffeewithandroid.recyclerview.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coffeewithandroid.recyclerview.Data.SampleData;
import com.coffeewithandroid.recyclerview.R;

import java.util.List;

/**
 * Created by Antarjot on 7/12/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private List<SampleData> sampleDataList;

    //Constructor
    public RecyclerViewAdapter(List<SampleData> sampleDataList){
        this.sampleDataList = sampleDataList;
    }

    //Returns View
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //data_row is the template we are using for item in Recycler View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

        return new myViewHolder(v);
    }

    //Method to bind every item in recycler view to relevant data in Arraylist initialized in MainActivity
    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        SampleData sampleData = sampleDataList.get(position);
        holder.title.setText(sampleData.getTitle());
        holder.date.setText(sampleData.getDate());

        //Provides information to devices with Accessibility Enable, Like
        //in form of Speech using Text-to-Speech for visually Impaired Users
        holder.imgButton.setContentDescription(sampleData.getTitle());
    }

    //Returns the number of items in Recycler View
    @Override
    public int getItemCount() {
        return sampleDataList.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        //Textviews in data_row.xml
        public TextView title, date;
        public ImageView imgButton;

        public myViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            imgButton = (ImageView) itemView.findViewById(R.id.imgButton);
        }
    }


}