package com.nuryadincjr.activitylifecycle.fragmentLifecycle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuryadincjr.activitylifecycle.R;

public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TesLifecycleFragment2", "onAttach Runn");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TesLifecycleFragment2", "onCreate Runn");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TesLifecycleFragment2", "onCreateView Runn");
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TesLifecycleFragment2", "onViewCreated Runn");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("TesLifecycleFragment2", "onViewStateRestored Runn");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TesLifecycleFragment2", "onStart Runn");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TesLifecycleFragment2", "onResume Runn");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TesLifecycleFragment2", "onPause Runn");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TesLifecycleFragment2", "onStop Runn");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TesLifecycleFragment2", "onSaveInstanceState Runn");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TesLifecycleFragment2", "onDestroyView Runn");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleFragment2", "onDistroy Runn");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TesLifecycleFragment2", "onDetach Runn");
    }
}