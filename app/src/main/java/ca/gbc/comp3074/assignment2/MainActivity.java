package ca.gbc.comp3074.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void about(View view) {
        Intent intent = new Intent(this, AboutView.class);
        startActivity(intent);
    }

    public void account(View view) {
        Intent intent = new Intent(this, AccountView.class);
        startActivity(intent);
    }

    public void list(View view) {
        Intent intent = new Intent(this, ListView.class);
        startActivity(intent);
    }
    public void map(View view) {
        Intent intent = new Intent(this, MapsMarkerActivity.class);
        startActivity(intent);
    }
    public void introduction(View view) {
        Intent intent = new Intent(this, introductionGame.class);
        startActivity(intent);
    }
}