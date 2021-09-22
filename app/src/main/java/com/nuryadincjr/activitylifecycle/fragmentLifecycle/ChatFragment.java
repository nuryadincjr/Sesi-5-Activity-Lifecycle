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

public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TesLifecycleFragment3", "onAttach Runn");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TesLifecycleFragment3", "onCreate Runn");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TesLifecycleFragment3", "onCreateView Runn");
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TesLifecycleFragment3", "onViewCreated Runn");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("TesLifecycleFragment3", "onViewStateRestored Runn");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TesLifecycleFragment3", "onStart Runn");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TesLifecycleFragment3", "onResume Runn");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TesLifecycleFragment3", "onPause Runn");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TesLifecycleFragment3", "onStop Runn");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TesLifecycleFragment3", "onSaveInstanceState Runn");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TesLifecycleFragment3", "onDestroyView Runn");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleFragment3", "onDistroy Runn");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TesLifecycleFragment3", "onDetach Runn");
    }
}