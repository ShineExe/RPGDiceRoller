package com.example.rpgdiceroller.ui.simpleRolls;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rpgdiceroller.R;

import java.util.Random;

public class SimpleRollsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SimpleRollsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(String.valueOf(R.string.title_simple_rolls));
    }

    public int rollDice(int sidesNumber) {
        int randResult = 0;
        if (sidesNumber > 0) {
            randResult = new Random().nextInt(sidesNumber) + 1;
        }
        return randResult;
    }

    public LiveData<String> getText() {
        return mText;
    }
}