package com.codepath.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edText = findViewById(R.id.edText);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        edText.setText(getIntent().getStringExtra(MainActivity.KEY_TEXT));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra(MainActivity.KEY_TEXT, edText.getText().toString());
                intent.putExtra(MainActivity.KEY_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_POSITION));

                setResult(RESULT_OK,intent);

                finish();

            }
        });
    }
}
