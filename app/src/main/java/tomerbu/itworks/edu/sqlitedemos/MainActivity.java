package tomerbu.itworks.edu.sqlitedemos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tomerbu.itworks.edu.sqlitedemos.controllers.NotesRecyclerFragment;
import tomerbu.itworks.edu.sqlitedemos.db.NotesDbHelper;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragment_layout, new NotesRecyclerFragment()).
                commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onClick() {
        insertNotes();

    }

    private void insertNotes() {
        NotesDbHelper helper = new NotesDbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues data = new ContentValues();
            data.put("title", "Title " );
            data.put("content", "Loerm Ipsum ");
            data.put("userId", 1);
        db.insert("Notes", null, data);
    }

    private void showAllUsers() {
        NotesDbHelper helper = new NotesDbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("User", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex("ID"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String lastName = cursor.getString(cursor.getColumnIndex("lastName"));

            String s = String.format("id: %s name: %s lastName: %s", id, name, lastName);
            Log.d("ITWorks", s);
        }
        cursor.close();
    }


    private void insertUsers() {
        NotesDbHelper helper = new NotesDbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();


        ContentValues data = new ContentValues();
        for (int i = 1; i < 10; i++) {
            data.put("name", "Forest" + i);
            data.put("lastName", "Gump" + i);
        }
        db.insert("User", null, data);
    }
}
