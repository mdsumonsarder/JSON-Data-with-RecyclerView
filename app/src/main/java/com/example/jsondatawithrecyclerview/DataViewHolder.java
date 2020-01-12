package com.example.jsondatawithrecyclerview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataViewHolder extends RecyclerView.ViewHolder {

    TextView title,name;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.row_title);
        name = itemView.findViewById(R.id.row_name);
    }


}
