package br.edu.ufrn.meuslivros_part1.RecyclerViewTouchListener;


import android.support.v7.widget.RecyclerView;
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

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    
}
