package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.database.LabDatabase;
import com.example.roomdatabase.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String DATABASE_NAME = "lab-database";
    Context context;
    EditText entry;
    Button submitButton;
    Button listButton;
    LabDatabase labDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // build database
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        // retrieve persons from the database
        ArrayList<? extends Parcelable> persons = new ArrayList<>(labDB.personDao().getAllPersons());


        // find views
        submitButton = findViewById(R.id.button_submit);
        listButton = findViewById(R.id.button_list);
        entry = findViewById(R.id.edit_text);

        // set button click listeners
        submitButton.setOnClickListener(v -> {
            Intent intent = new Intent();

        });
        listButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonsActivity.class);
            intent.putParcelableArrayListExtra("Persons", persons);
            startActivity(intent);
        });





    }
}