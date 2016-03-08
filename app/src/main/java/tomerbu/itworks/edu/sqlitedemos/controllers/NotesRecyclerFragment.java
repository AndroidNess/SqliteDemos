package tomerbu.itworks.edu.sqlitedemos.controllers;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import tomerbu.itworks.edu.sqlitedemos.R;
import tomerbu.itworks.edu.sqlitedemos.db.NotesDbHelper;
import tomerbu.itworks.edu.sqlitedemos.models.Note;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesRecyclerFragment extends Fragment {


    @Bind(R.id.rvNotes)
    RecyclerView rvNotes;

    public NotesRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_notes_recycler, container, false);
        ButterKnife.bind(this, v);

        NotesDbHelper helper = new NotesDbHelper(getActivity());
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.query("Notes", null, null, null, null, null, null);
        ArrayList<Note> notes = new ArrayList<>();

        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            notes.add(new Note(id, title, content));
        }
        cursor.close();
        rvNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
        NotesRecyclerAdapter adapter = new NotesRecyclerAdapter(getActivity(), notes);
        rvNotes.setAdapter(adapter);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
