package com.example.myapplication.view;


import com.example.myapplication.model.Note;

public interface IMainView {
    void showCreateFragment();
    void showRecycler();
    void showNote(Note note);
}
