package br.edu.ufrn.meuslivros_part1.RecyclerViewTouchListener;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener{

    //Interface para métodos disponibilizados ao Recycler view
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    //Objeto da interface criada acima
    OnItemClickListener clicklistener;
    GestureDetector myGesture;

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        myGesture.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    //constructor
    public RecyclerViewTouchListener(Context context, final RecyclerView view, OnItemClickListener listener){

        clicklistener = listener;
        myGesture = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e){
                super.onSingleTapUp(e);

                View childView = view.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && clicklistener != null){
                    clicklistener.onItemClick(childView, view.getChildAdapterPosition(childView));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e){
                super.onLongPress(e);

                View childView = view.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && clicklistener != null){
                    clicklistener.onItemLongClick(childView, view.getChildAdapterPosition(childView));
                }
            }
        });
    }

    
}
