package tomerbu.itworks.edu.sqlitedemos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dev on 08/03/2016.
 */
public class NotesDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "NotesDb";
    private static final int DB_VERSION = 3;


    public NotesDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLES:
        db.execSQL("CREATE TABLE Notes(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "                   title TEXT NOT NULL," +
                "                   content TEXT NOT NULL," +
                "                   userId INT NOT NULL);");

        db.execSQL("CREATE TABLE User(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "                   name TEXT NOT NULL," +
                "                   lastName TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Notes;");
        db.execSQL("DROP TABLE User;");
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
