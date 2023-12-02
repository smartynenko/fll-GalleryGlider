package org.fll38273.galleryglider.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Briniging the World's Masterpeices to Your Fingertips");
    }

    public LiveData<String> getText() {
        return mText;
    }
}