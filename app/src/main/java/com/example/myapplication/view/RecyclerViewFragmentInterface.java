package com.example.myapplication.view;

import com.example.myapplication.model.Note;

import java.util.List;

public interface RecyclerViewFragmentInterface {
    void createNote();
    List<Note> getNotes();
}
