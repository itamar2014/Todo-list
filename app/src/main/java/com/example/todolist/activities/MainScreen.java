package com.example.todolist.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todolist.Adapters.Adapter;
import com.example.todolist.Adapters.CustomAdapter;
import com.example.todolist.Adapters.CustomAdapter2;
import com.example.todolist.Common.DataModel;
import com.example.todolist.R;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    EditText t;
    ListView taskList;
    ArrayList<String> Tasks = new ArrayList<>();
    ArrayList<String> Dates = new ArrayList<>();
    ArrayList<Integer> Priority = new ArrayList<>();
    CustomAdapter customAdapter;
    DataModel lastSelected ;
    public static final String MyPREFERENCES = "MyPrefs";

    SharedPreferences sharedPreferences;

    ArrayList<DataModel> TodoList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        DataModel m1 = new DataModel("Welcome to The ToDoList App","2020.01.01",R.drawable.highpriority);

        TodoList = new ArrayList<>();
        TodoList.add(m1);




        adapter = new Adapter(this,0,0,TodoList);
        taskList = findViewById(R.id.taskList);
        taskList.setAdapter(adapter);

        taskList.setOnItemClickListener((parent, view, position, id) -> {

            lastSelected = adapter.getItem(position);
            Intent intent = new Intent(MainScreen.this,EditScreen.class);
            intent.putExtra("Task", lastSelected.getTask());
            intent.putExtra("Date", lastSelected.getDate());
            intent.putExtra("Priority",lastSelected.getPriority());
            intent.putExtra("pos",position);
            startActivityForResult(intent,0);
        });

        taskList.setOnItemLongClickListener((parent, view, position, id) -> {
            lastSelected = adapter.getItem(position);
            adapter.remove(lastSelected);
            adapter.notifyDataSetChanged();
            return false;
        });

        //if(getIntent().getExtras()!=null) {
        //    addTask();
        //}

        //customAdapter = new CustomAdapter(getApplicationContext(),Tasks,Priority,Dates);

        //taskList.setAdapter(customAdapter);



    }

    public void NewTask(View view) {
        Intent intent = new Intent(this,EditScreen.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                lastSelected.setTask(data.getExtras().getString("TaskText"));
                lastSelected.setDate(data.getExtras().getString("TaskDate"));
                lastSelected.setPriority(data.getExtras().getInt("Priority"));
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "User canceled", Toast.LENGTH_SHORT).show();
            }else if(resultCode==RESULT_FIRST_USER){
                adapter.remove(lastSelected);
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        }
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                DataModel model = new DataModel(data.getExtras().getString("TaskText"),
                        data.getExtras().getString("TaskDate"),
                        data.getExtras().getInt("Priority"));
                adapter.add(model);
                adapter.notifyDataSetChanged();
            }
        }
    }

}