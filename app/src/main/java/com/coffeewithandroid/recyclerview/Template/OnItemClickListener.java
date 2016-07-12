package com.coffeewithandroid.recyclerview.Template;

import android.view.View;

/**<p>
 * Created by Angad Singh on 13-07-2016.
 * </p>
 */

//Interface to be used when a Click is perfomed on
//a recycler view item.
public interface OnItemClickListener
{   //We will call this function in RecyclerViewTouchHandlerClass
    //and Override in our MainActivity to perform tasks on click
    //events.
    void onClick(View V, int position);
}
