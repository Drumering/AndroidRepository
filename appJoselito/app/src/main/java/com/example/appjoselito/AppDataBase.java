package com.example.appjoselito;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ItemDAO itemDAO();
    private static AppDataBase INSTANCE;

    public static synchronized AppDataBase getInstance(Context ctx){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(ctx, AppDataBase.class,"compras-db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
