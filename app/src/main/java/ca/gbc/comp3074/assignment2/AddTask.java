package ca.gbc.comp3074.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        final EditText name = findViewById(R.id.editTextLocationName);
        final EditText address = findViewById(R.id.editTextAddress);
        Button addTask = findViewById(R.id.btnAddTask);
        final DatabaseHelper db = DatabaseHelper.getInstance(this);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertTask(name.getText().toString(), address.getText().toString());
            }
        });

    }

}
