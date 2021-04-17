package com.example.roomdatabase.asyncs;

import android.content.Intent;
import android.os.AsyncTask;

public class RetrievalTask extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] objects) {
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
