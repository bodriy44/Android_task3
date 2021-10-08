package com.example.myapplication.view;

import com.example.myapplication.model.Note;

import java.util.List;

public interface IRecyclerViewFragment {
    void createNote();
    List<Note> getNotes();
}
