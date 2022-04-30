package com.example.fithub.main.trainingplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fithub.R;
import com.example.fithub.databinding.FragmentFirstBinding;
import com.example.fithub.databinding.FragmentTrainingPlanBinding;
import com.example.fithub.main.calendar.CalendarActivity;


public class TrainingPlanFragment extends Fragment {

    private FragmentTrainingPlanBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTrainingPlanBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 NavHostFragment.findNavController(TrainingPlanFragment.this)
                 .navigate(R.id.action_training_plan_to_exercise);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}