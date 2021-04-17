package com.example.roomdatabase.asyncs;

import android.os.AsyncTask;

public class InsertTask extends AsyncTask {


    @Override
    protected Object doInBackground(Object[] objects) {
        database.personDao().insertPerson(person);
        return null;
    }
}
