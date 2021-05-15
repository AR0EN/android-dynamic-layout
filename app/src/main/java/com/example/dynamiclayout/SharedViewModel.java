package com.example.dynamiclayout;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private static String TAG;

    private final MutableLiveData<Integer> sharedObject = new MutableLiveData<Integer>();

    public SharedViewModel() {
        TAG = getClass().getName();
    }

    public void setSharedObjectValue(Integer value) {
        Log.d(TAG, "setValue()");
        sharedObject.setValue(value);
    }

    public LiveData<Integer> getSharedObject() {
        Log.d(TAG, "getSelectedItem()");
        return sharedObject;
    }
}
