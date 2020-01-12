package com.example.jsondatawithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder>{

    ArrayList<DataList> list;
    Context context;

    public DataAdapter() {

    }

    public DataAdapter(ArrayList<DataList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.rawlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        DataList currentlist = list.get(position);
        holder.title.setText(currentlist.getName());
        holder.name.setText(currentlist.getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
