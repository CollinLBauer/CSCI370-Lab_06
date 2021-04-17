package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.database.LabDatabase;
import com.example.roomdatabase.entity.Person;

public class MainActivity extends AppCompatActivity {

    final String DATABASE_NAME = "Lab_Database";
    Context context;
    EditText entry;
    Button submitButton;
    Button listButton;
    RoomDatabase labDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // find views
        submitButton = findViewById(R.id.button_submit);
        listButton = findViewById(R.id.button_list);
        entry = findViewById(R.id.edit_text);

        // set button click listeners
        submitButton.setOnClickListener(v -> {
            Intent intent = new Intent();

        });
        listButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, Person.class);
            startActivity(intent);
        });

        // build database
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

    }
}