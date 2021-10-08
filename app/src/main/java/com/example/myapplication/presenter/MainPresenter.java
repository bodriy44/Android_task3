package com.example.myapplication.presenter;

import com.example.myapplication.model.MainModel;
import com.example.myapplication.model.Note;
import com.example.myapplication.view.IMainView;

import java.util.List;

public class MainPresenter {
    private IMainView view;
    private final MainModel model;

    public MainPresenter(IMainView view) {
        this.view = view;
        this.model = new MainModel();
    }

    public List<Note> getNotes() {
        return model.getNotes();
    }

    public void saveNote(Note note) {
        model.addNote(note);
        view.showRecycler();
    }

    public void createNote() {
        view.showCreateFragment();
    }

    public void deleteNote(Note note) {
        model.deleteNote(note);
    }

    public void showNote(int index) {
        view.showNote(model.getNote(index));
    }
}
