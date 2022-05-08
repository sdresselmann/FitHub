package com.example.fithub.main;

import android.graphics.Color;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fithub.R;
import com.example.fithub.databinding.FragmentPiechartBinding;
import com.example.fithub.main.prototypes.MuscleGroupChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PieChartFragment extends Fragment {

  private FragmentPiechartBinding binding;
  private PieChart chart;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_piechart, container, false);

    return view;
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    chart = (PieChart) view.findViewById(R.id.chart1);

    MuscleGroupChart chartData = new MuscleGroupChart();

    // raw test data for testing purposes only
    ArrayMap<String, String> MuscleData = new ArrayMap<>();
    MuscleData.put("Schultern", "18.5f");
    MuscleData.put("Brust", "26.7f");
    MuscleData.put("Rücken", "10.1f");
    MuscleData.put("Arme", "24.0f");
    MuscleData.put("Beine", "30.8f");
    MuscleData.put("Bauch", "11.4f");

    MuscleGroupChart muscleGroupChartData = new MuscleGroupChart();
    muscleGroupChartData.addDataAll(MuscleData);

    List<PieEntry> pieEntries = new ArrayList<>();

    for (Map.Entry<String, String> entry : muscleGroupChartData.getAllData().entrySet()) {
      pieEntries.add(new PieEntry(Float.parseFloat(entry.getValue()), entry.getKey()));
    }

    Collections.sort(
        pieEntries,
        new Comparator<Object>() {
          @Override
          public int compare(Object a1, Object a2) {
            PieEntry pe1 = (PieEntry) a1;
            PieEntry pe2 = (PieEntry) a2;
            // sorting descending so biggest value starts on right side of the donut chart
            return Float.compare(pe2.getValue(), pe1.getValue());
          }
        });

    PieDataSet set = new PieDataSet(pieEntries, "Muskelgruppen trainiert");
    chart.setEntryLabelColor(Color.BLACK);

    int[] Colors = {
      Color.rgb(79, 118, 247),
      Color.rgb(146, 79, 247),
      Color.rgb(124, 247, 79),
      Color.rgb(247, 244, 79),
      Color.rgb(247, 127, 79),
      Color.rgb(247, 79, 79)
    };

    set.setColors(Colors);
    final PieData data = new PieData(set);
    chart.setData(data);
    chart.invalidate(); // refresh
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
