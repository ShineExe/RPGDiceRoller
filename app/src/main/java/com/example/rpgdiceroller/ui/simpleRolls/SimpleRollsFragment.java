package com.example.rpgdiceroller.ui.simpleRolls;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.rpgdiceroller.R;
import com.example.rpgdiceroller.databinding.FragmentSimpleRollsBinding;
import com.google.android.material.snackbar.Snackbar;

public class SimpleRollsFragment extends Fragment implements View.OnClickListener{

    private FragmentSimpleRollsBinding binding;
    private SimpleRollsViewModel srViewModel;
    private Button rollButton;
    private Button[] diceButtons;
    private EditText editSidesNumber;
    private TextView resultText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        srViewModel = new ViewModelProvider(this).get(SimpleRollsViewModel.class);

        binding = FragmentSimpleRollsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupButtons(root);

        editSidesNumber = root.findViewById(R.id.edit_sides_number);
        resultText = root.findViewById(R.id.result_text);
        //srViewModel.getText().observe(getViewLifecycleOwner(), resultText::setText);
        //resultText.setText("0");
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        int sidesNumber = 0;
        resultText.setText("");
        if (view.getId() == R.id.roll_button) {
            String input = editSidesNumber.getText().toString();
            if (input.isEmpty())
                showAlertEmpty(view);
            else
                sidesNumber = Integer.parseInt(editSidesNumber.getText().toString());
        }
        // handling dice buttons
        else if (view.getId() == R.id.d2_btn) {
            sidesNumber = 2;
        }
        else if (view.getId() == R.id.d4_btn) {
            sidesNumber = 4;
        }
        else if (view.getId() == R.id.d6_btn) {
            sidesNumber = 6;
        }
        else if (view.getId() == R.id.d8_btn) {
            sidesNumber = 8;
        }
        else if (view.getId() == R.id.d10_btn) {
            sidesNumber = 10;
        }
        else if (view.getId() == R.id.d12_btn) {
            sidesNumber = 12;
        }
        else if (view.getId() == R.id.d20_btn) {
            sidesNumber = 20;
        }
        else if (view.getId() == R.id.d100_btn) {
            sidesNumber = 100;
        }

        int result = srViewModel.rollDice(sidesNumber);
        YoYo.with(Techniques.RotateInDownLeft)
                .duration(500)
                .playOn(resultText);

        resultText.setText(String.valueOf(result));
    }

    private void setupButtons(View v) {
        rollButton = v.findViewById(R.id.roll_button);
        rollButton.setOnClickListener(this);
        diceButtons = new Button[8];
        diceButtons[0] = v.findViewById(R.id.d2_btn);
        diceButtons[1] = v.findViewById(R.id.d4_btn);
        diceButtons[2] = v.findViewById(R.id.d6_btn);
        diceButtons[3] = v.findViewById(R.id.d8_btn);
        diceButtons[4] = v.findViewById(R.id.d10_btn);
        diceButtons[5] = v.findViewById(R.id.d12_btn);
        diceButtons[6] = v.findViewById(R.id.d20_btn);
        diceButtons[7] = v.findViewById(R.id.d100_btn);

        for (Button diceButton : diceButtons) {
            diceButton.setOnClickListener(this);
        }
    }

    private void showAlertEmpty(View v) {
        Snackbar snack = Snackbar.make(v, "Enter a valid number first!", Snackbar.LENGTH_SHORT);
        View snackView = snack.getView();
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackView.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        snackView.setLayoutParams(params);
        snack.show();
    }
}