package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.view.fragment.INoteCreateFragment;
import com.example.myapplication.view.fragment.INoteFragment;
import com.example.myapplication.view.fragment.IRecyclerViewFragment;
import com.example.myapplication.model.Note;
import com.example.myapplication.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements IMainView {

    public MainPresenter presenter;
    private INoteCreateFragment noteCreateFragment;
    public INoteFragment noteFragment;
    public IRecyclerViewFragment recyclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        noteCreateFragment = new INoteCreateFragment();
        noteFragment = new INoteFragment();
        recyclerViewFragment = new IRecyclerViewFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, recyclerViewFragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerViewFragment.setNotes(presenter.getNotes());
    }

    @Override
    public void showCreateFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, noteCreateFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showNote(Note note) {
        noteFragment.changeNote(note);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, noteFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showRecycler() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, recyclerViewFragment)
                .commit();
    }
}

