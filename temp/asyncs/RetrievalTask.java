package com.example.roomdatabase.asyncs;

import android.content.Intent;
import android.os.AsyncTask;

import com.example.roomdatabase.PersonsActivity;
import com.example.roomdatabase.entity.Person;

import java.util.ArrayList;

public class RetrievalTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
        return null;
    }
}
