package ca.gbc.comp3074.assignment2;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setupHyperlink();
    }
    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.gitHub);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
