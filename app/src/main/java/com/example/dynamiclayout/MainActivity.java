package com.example.dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.lang.invoke.MethodHandles;

public class MainActivity extends AppCompatActivity {
    private static String TAG;

    int mCachedOrientation;
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = findViewById(R.id.mLinearLayout);
        adjustScreenLayout();
        TAG = this.getClass().getName();
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation != mCachedOrientation) {
            adjustScreenLayout();
        }
    }

    private void adjustScreenLayout() {
        mCachedOrientation = getResources().getConfiguration().orientation;
        if (mCachedOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        }
    }
}