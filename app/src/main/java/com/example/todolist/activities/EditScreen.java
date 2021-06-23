package com.example.todolist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.todolist.R;

import java.util.Calendar;
import com.example.todolist.Common.common;

public class EditScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView DisplayDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    private EditText TaskTxt;
    private RadioButton DeadLine;
    private RadioButton HighPriority;
    private int Priority;
    Button cancel,delete,update;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);

        //Date
        DisplayDate = findViewById(R.id.DatePick);
        DisplayDate.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    EditScreen.this,
                    android.R.style.Theme_DeviceDefault_Dialog,
                    onDateSetListener,
                    year,month,day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        onDateSetListener = (view, year, month, dayOfMonth) -> {
            month = month+1;
            String date = month + "/" + dayOfMonth + "/" + year;
            DisplayDate.setText(date);

        };
        //End of Date

        TaskTxt = findViewById(R.id.TextInput);
        DeadLine = findViewById(R.id.DeadLine);

        DeadLine.setOnCheckedChangeListener((buttonView, isChecked) -> CalVisibility());
        HighPriority = findViewById(R.id.HighPriority);

        HighPriority.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked)
                Priority = R.drawable.highpriority;
            Priority = R.drawable.regularpriority;
        });


        cancel = findViewById(R.id.Cancel);
        delete = findViewById(R.id.DeleteTASK);
        update = findViewById(R.id.Update);
        update.setOnClickListener(this);
        cancel.setOnClickListener(this);
        delete.setOnClickListener(this);

        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            TaskTxt.setText(intent.getExtras().getString("Task"));
            DisplayDate.setText(intent.getExtras().getString("Date"));
            pos = intent.getExtras().getInt("pos");
            HighPriority.setChecked(intent.getExtras().getInt("Priority") == R.drawable.highpriority);
        }
    }

    private void CalVisibility(){
        if(DisplayDate.getVisibility()==View.VISIBLE)
            DisplayDate.setVisibility(View.INVISIBLE);
        DisplayDate.setVisibility(View.VISIBLE);
    }


    public void UpdateCommon(View view) {
        Intent intent = new Intent(EditScreen.this,MainScreen.class);
        intent.putExtra("TaskText",TaskTxt.getText().toString().trim());
        intent.putExtra("TaskDate", DisplayDate.getText().toString().trim());
        intent.putExtra("Priority", DeadLine.isChecked());
        intent.putExtra("p1os", pos);
        setResult(RESULT_OK,intent);
        finish();

    }

    @Override
    public void onClick(View v) {
        if(cancel==v){
            setResult(RESULT_CANCELED,null);
            finish();
        }
        if(update==v){
            Intent intent = new Intent(EditScreen.this,MainScreen.class);
            intent.putExtra("TaskText",TaskTxt.getText().toString().trim());
            intent.putExtra("TaskDate", DisplayDate.getText().toString().trim());
            intent.putExtra("Priority", (HighPriority.isChecked())? R.drawable.highpriority:R.drawable.regularpriority);
            intent.putExtra("Pos", pos);
            setResult(RESULT_OK,intent);
            finish();
        }
        if(delete==v){
            Intent intent = new Intent(EditScreen.this,MainScreen.class);
            intent.putExtra("ToDelete",true);

            setResult(RESULT_FIRST_USER,intent);
            finish();
        }
    }
}






















