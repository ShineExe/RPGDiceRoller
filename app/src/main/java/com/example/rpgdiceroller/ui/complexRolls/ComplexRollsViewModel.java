package com.example.rpgdiceroller.ui.complexRolls;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComplexRollsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ComplexRollsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Complex rolls with multiple dice\nTo be implemented");
    }

    public LiveData<String> getText() {
        return mText;
    }
}