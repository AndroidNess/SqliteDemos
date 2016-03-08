package tomerbu.itworks.edu.sqlitedemos.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tomerbu.itworks.edu.sqlitedemos.R;
import tomerbu.itworks.edu.sqlitedemos.models.Note;



public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.NotesViewHolder> {

    public NotesRecyclerAdapter(Context context, List<Note> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private LayoutInflater inflater;
    private Context context;
    private List<Note> data;

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.notes_item, parent, false);
        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        Note note = data.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //View Holder - Find Views by id.
    class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView content;

        public NotesViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tvTitle);
            content = (TextView)itemView.findViewById(R.id.tvContent);
        }
    }
}
