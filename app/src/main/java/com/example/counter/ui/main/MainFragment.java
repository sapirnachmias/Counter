package com.example.counter.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.counter.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        TextView txtCounter = view.findViewById(R.id.txtCounter);
        Button btnIncrease = view.findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(v -> {
            counter++;
            txtCounter.setText(String.format("%d", counter));
        });

        Button btnDecrease = view.findViewById(R.id.btnDecrease);
        btnDecrease.setOnClickListener(v -> {
            counter--;
            txtCounter.setText(String.format("%d", counter));
        });

        Button btnReset = view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> {
            counter = 0;
            txtCounter.setText(String.format("%d", counter));
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}