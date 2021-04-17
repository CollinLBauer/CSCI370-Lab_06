package com.example.roomdatabase.asyncs;

import android.os.AsyncTask;

import com.example.roomdatabase.entity.Person;

public class InsertTask extends AsyncTask<Person, Void, Void> {

    

    @Override
    protected Void doInBackground(Person... persons) {
        database.personDao().insertPerson(person);
        return null;
    }
}
