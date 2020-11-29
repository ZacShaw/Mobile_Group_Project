package ca.gbc.comp3074.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuNav:
                        Toast.makeText(MainActivity.this, "Implementing Menu Text", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navLac:
                        Toast.makeText(MainActivity.this, "Location Find is Loading", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.conTact:
                        setContentView(R.layout.activity_about);

                }
                return true;
            }
        });
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