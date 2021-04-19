package com.example.roomdatabase;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PersonsActivity extends AppCompatActivity {

    final String TAG = "PersonsActivity";

    Context context;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);

        Log.i(TAG, "Activity created");


        context = getApplicationContext();

        listView = findViewById(R.id.personName);

        ArrayList<?> i = (ArrayList<?>) this.getIntent().getExtras().get("Persons");

        ArrayAdapter<?> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, i);

        listView.setAdapter(adapter);
    }
}
