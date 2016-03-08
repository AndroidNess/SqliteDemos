package tomerbu.itworks.edu.sqlitedemos.controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tomerbu.itworks.edu.sqlitedemos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesRecyclerFragment extends Fragment {


    public NotesRecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_recycler, container, false);
    }


}
