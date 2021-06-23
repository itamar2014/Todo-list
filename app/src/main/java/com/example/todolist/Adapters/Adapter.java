package com.example.todolist.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todolist.Common.DataModel;
import com.example.todolist.R;

import java.util.List;

public class Adapter extends ArrayAdapter<DataModel> {
    Context context;
    List<DataModel> objects;

    public Adapter(Context context, int resource, int textViewResourceId, List<DataModel>objects){
        super(context,resource,textViewResourceId,objects);

        this.context = context;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.listview,parent,false);

        TextView TaskCon = view.findViewById(R.id.taskName);
        TextView Date = view.findViewById(R.id.Date);
        ImageView Priority = view.findViewById(R.id.Priority);

        DataModel temp = objects.get(position);
        TaskCon.setText(temp.getTask());
        Date.setText(temp.getDate());
        Priority.setImageResource(temp.getPriority());
        return view;

    }
}
