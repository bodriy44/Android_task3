package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


import com.example.myapplication.R;
import com.example.myapplication.model.Note;
import com.example.myapplication.view.NoteCreateFragmentInterface;
import com.example.myapplication.view.MainActivity;

import java.util.Date;

public class NoteCreateFragment extends Fragment implements NoteCreateFragmentInterface {

    public NoteCreateFragment() {
        super(R.layout.fragment_note_create);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Создаем view который будет содержимым фрагмента и отдаем его системе
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_create, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        getActivity().findViewById(R.id.button).setOnClickListener((v) -> this.addNote());

        // Очищаем поля ввода
        ((EditText) getActivity().findViewById(R.id.editTextTitle)).setText("");
        ((EditText) getActivity().findViewById(R.id.editTextText)).setText("");
    }

    // Сохраняем записку в список
    @Override
    public void addNote() {
        ((MainActivity) getActivity()).presenter.saveNote(this.getNote());
    }


    // Получаем заголовок, текст, и дату сообщения
    public Note getNote() {
        return new Note(((EditText) getActivity().findViewById(R.id.editTextTitle)).getText().toString(),
                ((EditText) getActivity().findViewById(R.id.editTextText)).getText().toString(),
                new Date().toString());
    }


}
