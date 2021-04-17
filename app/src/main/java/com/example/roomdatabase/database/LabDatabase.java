package com.example.roomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.dao.PersonDao;
import com.example.roomdatabase.entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();

}
