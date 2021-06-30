package com.example.appmudanza.ui.home;

import android.widget.Button;
import android.widget.ImageButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;



    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue( "This is home fragment" );

    }

    public LiveData<String> getText() {
        return mText;
    }
}