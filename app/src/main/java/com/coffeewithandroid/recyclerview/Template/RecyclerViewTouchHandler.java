package com.coffeewithandroid.recyclerview.Template;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**<p>
 * Created by Angad Singh on 13-07-2016.
 * </p>
 */

public class RecyclerViewTouchHandler implements RecyclerView.OnItemTouchListener {
    //The listener that is used to notify when gestures occur.
    private GestureDetector gestureDetector;

    private RecyclerView mRecyclerView;
    private Context context;

    //Here are our Interfaces
    private OnItemClickListener clickListener;
    private OnItemLongClickListener mOnlongClickListener;

    public RecyclerViewTouchHandler(Context context, RecyclerView recyclerView) {
        this.context=context;
        mRecyclerView=recyclerView;

        //Adding touch interface on RecyclerView
        mRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //Called Whenever a touch event is performed on RecyclerView

        //Pick X and Y coordinates from MotionEvent and get a reference of child
        //under those coordinates in RecyclerView
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        //To prevent from NullPointerExceptions
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            //Pass on the reference of detected child view and Position of the
            //child list item in the Adapter,

            //Note: RecyclerView can dynamically add or remove an Item. Hence it
            //is better to return the adapter position although there are other
            //methods too like getChildLayoutPosition
            clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public void setOnClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setOnlongClickListener(OnItemLongClickListener onlongClickListener) {
        //A long click listener has been Attatched to the RecyclerView,
        //Detect gesture on the device screen. SimpleOnGestureListener provides
        //two methods to detect a single click and long press
        this.mOnlongClickListener = onlongClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                //Again pick X and Y coordinates from MotionEvent and get a reference of child
                //under those coordinates in RecyclerView

                View child = mRecyclerView.findChildViewUnder(e.getX(), e.getY());

                //Just to prevent from any NullPointerExceptions
                if (child != null && mOnlongClickListener != null) {
                    //Pass on the reference of detected child View and Position of the
                    //child list item in the Adapter,

                    //Reminder: RecyclerView can dynamically add or remove an Item. Hence it
                    //is better to return the adapter position although there are other
                    //methods too like getChildLayoutPosition
                    mOnlongClickListener.onClick(child, mRecyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }
}

