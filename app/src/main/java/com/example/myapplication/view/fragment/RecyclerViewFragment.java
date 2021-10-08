package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.NoteAdapter;
import com.example.myapplication.model.Note;
import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.OnNoteClickListener;
import com.example.myapplication.view.RecyclerViewFragmentInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecyclerViewFragment extends Fragment implements RecyclerViewFragmentInterface, OnNoteClickListener {

    private NoteAdapter adapter;

    public RecyclerViewFragment() {
        super(R.layout.fragment_recycler);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_recycler, container, false);
        adapter = new NoteAdapter(this);
        ((RecyclerView) inflate.findViewById(R.id.recyclerView)).setAdapter(adapter);
        ((FloatingActionButton) inflate.findViewById(R.id.floatingActionButtonAddNote)).setOnClickListener((v) -> this.createNote());

        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.setNotes(this.getNotes());
    }

    @Override
    public List<Note> getNotes() {
        return ((MainActivity) getActivity()).presenter.getNotes();
    }

    @Override
    public void createNote() {
        ((MainActivity) getActivity()).presenter.createNote();
    }

    @Override
    public void onNoteClick(int position) {
        ((MainActivity) getActivity()).presenter.showNote(position);
    }

    public void setNotes(List<Note> notes) {
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();
    }
}