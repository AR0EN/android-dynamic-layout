package com.example.dynamiclayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OutputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutputFragment extends Fragment {
    private static String TAG;

    private View mView;
    private SharedViewModel mSharedViewModel;
    private SharedObjectObserver mSharedObjectObserver;
    private TextView mLabel;

    public OutputFragment() {
        super();
        TAG = getClass().getName();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OutputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OutputFragment newInstance() {
        return (new OutputFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_output, container, false);
        initComponents();

        return mView;
    }

    private void initComponents() {
        mSharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        mSharedObjectObserver = new SharedObjectObserver();
        mSharedViewModel.getSharedObject().observe(getViewLifecycleOwner(), mSharedObjectObserver);
        mLabel = (TextView) mView.findViewById(R.id.textViewOutput);
        updateLabel(mSharedViewModel.getSharedObject().getValue());
    }

    private void updateLabel(int value) {
        mLabel.setText("Click count: " + value);
    }

    private class SharedObjectObserver implements Observer<Integer> {
        @Override
        public void onChanged(Integer value) {
            Log.d(TAG, "onChanged(" + value + ")");
            updateLabel(value);
        }
    }
}
