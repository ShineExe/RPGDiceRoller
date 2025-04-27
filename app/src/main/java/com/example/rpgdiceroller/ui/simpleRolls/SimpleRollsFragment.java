package com.example.rpgdiceroller.ui.simpleRolls;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.rpgdiceroller.R;
import com.example.rpgdiceroller.databinding.FragmentSimpleRollsBinding;

public class SimpleRollsFragment extends Fragment {

    private FragmentSimpleRollsBinding binding;
    private SimpleRollsViewModel srViewModel;
    private Button rollButton;
    private EditText editSidesNumber;
    private TextView resultText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        srViewModel = new ViewModelProvider(this).get(SimpleRollsViewModel.class);

        binding = FragmentSimpleRollsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        resultText = root.findViewById(R.id.result_text);
        rollButton = root.findViewById(R.id.roll_button);
        editSidesNumber = root.findViewById(R.id.edit_sides_number);

        //srViewModel.getText().observe(getViewLifecycleOwner(), resultText::setText);
        resultText.setText(R.string.title_simple_rolls);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sidesNumber = 0;
                sidesNumber = Integer.parseInt(editSidesNumber.getText().toString());
                int result = srViewModel.rollDice(sidesNumber);
                resultText.setText(String.valueOf(result));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}