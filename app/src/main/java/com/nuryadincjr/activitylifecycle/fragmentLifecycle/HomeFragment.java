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

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TesLifecycleFragment1", "onAttach Runn");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TesLifecycleFragment1", "onCreate Runn");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TesLifecycleFragment1", "onCreateView Runn");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TesLifecycleFragment1", "onViewCreated Runn");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("TesLifecycleFragment1", "onViewStateRestored Runn");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TesLifecycleFragment1", "onStart Runn");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TesLifecycleFragment1", "onResume Runn");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TesLifecycleFragment1", "onPause Runn");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TesLifecycleFragment1", "onStop Runn");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TesLifecycleFragment1", "onSaveInstanceState Runn");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TesLifecycleFragment1", "onDestroyView Runn");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleFragment1", "onDistroy Runn");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TesLifecycleFragment1", "onDetach Runn");
    }
}