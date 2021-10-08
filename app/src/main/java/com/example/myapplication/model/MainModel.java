package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private List<Note> notes;

    public MainModel() {
        notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public boolean writeToDB(String note) {

        return true;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void deleteNote(Note note) {
        this.notes.remove(notes.indexOf(note));
    }

    public Note getNote(int index){
        return notes.get(index);
    }
}
