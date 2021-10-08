package com.example.myapplication.view.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Note;
import com.example.myapplication.view.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class INoteFragment extends Fragment implements com.example.myapplication.view.INoteFragment {

    private Note note;

    public INoteFragment() {
        super(R.layout.fragment_note);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStart() {
        super.onStart();
        ((FloatingActionButton) getActivity().findViewById(R.id.floatingActionButtonDelete)).setOnClickListener((v) -> this.deleteNote(this.note));

        ((FloatingActionButton) getActivity().findViewById(R.id.floatingActionButtonShare)).setOnClickListener((v) -> this.shareNote());
        ((TextView) getActivity().findViewById(R.id.NoteTitle)).setText(note.getHeader());
        ((TextView) getActivity().findViewById(R.id.NoteDate)).setText(note.getDate());
        ((TextView) getActivity().findViewById(R.id.NoteText)).setText(note.getBody());

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void shareNote() {
        Note note = this.getNote();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, String.join("\n", note.getDate(), note.getHeader(), note.getBody(), "Отправлено из приложения MyNote"));
        sendIntent.setType("text/plain");

        startActivity(Intent.createChooser(sendIntent, null));
    }

    public Note getNote() {
        return note;
    }

    public void changeNote(Note note) {
        this.note = note;
    }

    public void deleteNote(Note note) {
        ((MainActivity) getActivity()).presenter.deleteNote(note);
    }
}
