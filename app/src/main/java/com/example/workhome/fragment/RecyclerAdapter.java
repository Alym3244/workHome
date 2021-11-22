package com.example.workhome.fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.workhome.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
Context context;
List<TaskModel>list = new ArrayList<>();
public RecyclerAdapter(Context context) {
    this.context = context;

}
    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_task,parent,false);
        return new RecyclerViewHolder(view);
    }
public void addTask(TaskModel taskModel){
        this.list.add(taskModel);
        notifyDataSetChanged();

}
    @Override
    public void onBindViewHolder( RecyclerViewHolder holder, int position) {
holder.txtTitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtDescription;

        public RecyclerViewHolder( View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.item_title_txt);
            txtDescription = itemView.findViewById(R.id.item_description_txt);
        }
    }
}
