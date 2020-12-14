package ca.gbc.comp3074.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        //DatabaseHelper db = DatabaseHelper.getInstance(this);


        Button addTaskBtn = findViewById(R.id.btnAddTask);

    }
    public void addTask(View view){
        Intent intent = new Intent(this, AddTask.class);
        startActivity(intent);
    }

}
