package com.example.dynamiclayout;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InputFragment extends Fragment {
    private static String TAG;

    private View mView;
    private SharedViewModel mSharedViewModel;
    private Button mButton;
    private ClickListener mClickListener;
    private int mClickCount;

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    public InputFragment() {
        super();
        TAG = getClass().getName();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_input, container, false);
        initComponents();
        return mView;
    }

    private void initComponents() {
        mSharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        mSharedViewModel.setSharedObjectValue(mClickCount);
        mButton = (Button) mView.findViewById(R.id.button);
        mClickListener = new ClickListener();
        mButton.setOnClickListener(mClickListener);
    }

    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "Click event!");
            mSharedViewModel.setSharedObjectValue(mClickCount++);
        }
    }
}
