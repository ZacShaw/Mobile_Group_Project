package ca.gbc.comp3074.assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper db = null;
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "tasks_db";

    public static synchronized DatabaseHelper getInstance(Context context){
        if (db == null){
            db = new DatabaseHelper(context.getApplicationContext());
        }
        return db;
    }

    private DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tasks.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + Tasks.TABLE_NAME);
        onCreate(db);
    }

    public long insertTask(String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tasks.COLUMN_NAME, name);
        values.put(Tasks.COLUMN_ADDRESS, address);

        long id = db.insert(Tasks.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Tasks getTask(long id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Tasks.TABLE_NAME,
                new String[] {Tasks.COLUMN_ID, Tasks.COLUMN_NAME, Tasks.COLUMN_ADDRESS},
                Tasks.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor!= null){
            cursor.moveToFirst();
            Tasks task = new Tasks(cursor.getInt(cursor.getColumnIndex(Tasks.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(Tasks.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(Tasks.COLUMN_ADDRESS)));

            cursor.close();
            return task;
        }else{
            return null;
        }
    }

    public List<Tasks> getAllTasks(){
        List<Tasks> tasks = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Tasks.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null){
            if (cursor.moveToFirst()){
                do{
                    Tasks task = new Tasks(cursor.getInt(cursor.getColumnIndex(Tasks.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndex(Tasks.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(Tasks.COLUMN_ADDRESS)));
                    tasks.add(task);
                }while(cursor.moveToNext());
            }
        }
        db.close();
        return tasks;
    }

}
