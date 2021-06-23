package com.example.todolist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todolist.Common.DataModel;
import com.example.todolist.R;

import java.util.ArrayList;

public class CustomAdapter2 extends ArrayAdapter<DataModel> implements View.OnClickListener {
    private ArrayList<DataModel> dataset;
    Context context;



    private static class ViewHolder{
        TextView date;
        TextView task;
        ImageView Priority;
    }
    public CustomAdapter2(ArrayList<DataModel> data, Context context){
        super(context, R.layout.listview);
        this.dataset = data;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        DataModel object = getItem(position);
        DataModel dataModel = object;

    }
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataModel dataModel = getItem(position);
        ViewHolder viewHolder;


        final View result;
        if(convertView==null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview, parent, false);
            viewHolder.task = convertView.findViewById(R.id.taskName);
            viewHolder.date = convertView.findViewById(R.id.Date);
            viewHolder.Priority = convertView.findViewById(R.id.Priority);

            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.down_from_top);
        lastPosition = position;

        viewHolder.task.setText(dataModel.getTask());
        viewHolder.date.setText(dataModel.getDate());
        viewHolder.Priority.setImageResource(dataModel.getPriority());
        return convertView;

    }
}
