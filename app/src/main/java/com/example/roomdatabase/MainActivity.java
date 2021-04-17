package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.database.LabDatabase;
import com.example.roomdatabase.entity.Person;

import java.util.ArrayList;


/* Okay, so...
 * I was able to get threading working,
 * but I couldn't figure out how the AsyncTasks were supposed to work.
 * Researching things myself led me to simply creating threads within the click listeners.
 * Which, you know, it works, but perhaps not in the way the lab seems to want.
 * The lab instructions were really unclear on how that part was supposed to be implemented.
 * Admittedly, maybe paying closer attention to the threading lab would have helped.
 */
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

        // find views
        submitButton = findViewById(R.id.button_submit);
        listButton = findViewById(R.id.button_list);
        entry = findViewById(R.id.edit_text);
        context = getApplicationContext();

        // build database
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        // set button click listeners
        submitButton.setOnClickListener(v -> {
            String name = entry.getText().toString();

            if (!name.equals("")) {
                new Thread(() -> {
                    Person person = new Person();
                    person.setName(name);
                    labDB.personDao().insertPerson(person);
                }).start();
            }
            else {
                Toast.makeText(context, "Invalid name", Toast.LENGTH_SHORT).show();
            }
        });
        listButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonsActivity.class);

            class MyRunnable implements Runnable {
                private ArrayList<? extends Parcelable> persons;

                @Override
                public void run() {
                    persons = new ArrayList<>(labDB.personDao().getAllPersons());
                }

                public ArrayList<? extends Parcelable> getPersons() {
                    return persons;
                }
            }

            MyRunnable myRunnable = new MyRunnable();

            Thread myThread = new Thread(myRunnable);
            myThread.start();

            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            intent.putParcelableArrayListExtra("Persons", myRunnable.getPersons());
            startActivity(intent);

        });

    }
}