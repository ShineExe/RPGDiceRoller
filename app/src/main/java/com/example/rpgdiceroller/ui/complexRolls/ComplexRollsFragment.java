package com.example.rpgdiceroller.ui.complexRolls;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rpgdiceroller.databinding.FragmentComplexRollsBinding;

public class ComplexRollsFragment extends Fragment {

    private FragmentComplexRollsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ComplexRollsViewModel complexRollsViewModel =
                new ViewModelProvider(this).get(ComplexRollsViewModel.class);

        binding = FragmentComplexRollsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        complexRollsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}