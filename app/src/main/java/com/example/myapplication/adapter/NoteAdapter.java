package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Note;
import com.example.myapplication.view.OnNoteClickListener;


import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private final OnNoteClickListener onNoteClickListener;
    private List<Note> notes = new ArrayList<>();

    public NoteAdapter(OnNoteClickListener onClickListener) {
        onNoteClickListener = onClickListener;
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.headerView.setText(note.getHeader());
        holder.dateView.setText(note.getDate());

        holder.itemView.setOnClickListener(v -> onNoteClickListener.onNoteClick(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView dateView, headerView;

        ViewHolder(View itemView) {
            super(itemView);
            dateView = (TextView) itemView.findViewById(R.id.date);
            headerView = (TextView) itemView.findViewById(R.id.title);
        }
    }


}