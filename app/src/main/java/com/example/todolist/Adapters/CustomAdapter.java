package com.example.todolist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todolist.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> tasks;
    ArrayList<String> Dates;
    ArrayList<Integer> Priorities;
    LayoutInflater inflater;


    public CustomAdapter(Context applicationContext, ArrayList<String> tasks, ArrayList<Integer> priority, ArrayList<String> Dates) {
        this.context = context;
        this.Dates = Dates;
        this.tasks = tasks;
        this.Priorities = priority;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview, null);
        TextView date = convertView.findViewById(R.id.Date);
        TextView task = convertView.findViewById(R.id.taskName);
        ImageView priority = convertView.findViewById(R.id.Priority);
        date.setText(Dates.get(position));
        task.setText(tasks.get(position));
        priority.setImageResource(Priorities.get(position));

        return convertView;
    }
    }
