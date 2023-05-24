package com.lizarragabriel.polygon.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lizarragabriel.polygon.R;
import com.lizarragabriel.polygon.viewmodel.HomeViewModel;
import com.lizarragabriel.polygon.databinding.FragmentHomeBinding;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.JvmStatic;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    private FragmentHomeBinding binding;
    private HomeViewModel mViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.setLifecycleOwner(this.getViewLifecycleOwner());
        binding.setViewModel(mViewModel);
        // Polygon Adapter
        String[] mFiguras = getResources().getStringArray(R.array.figures);
        ArrayAdapter mAdapter = new ArrayAdapter(getContext(), R.layout.list_item, mFiguras);
        binding.polygonDropDown.setAdapter(mAdapter);
        // Autocomplete
        binding.polygonDropDown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mViewModel.selectFigureFromDropDown(i);
            }
        });
    }

    @BindingAdapter("loadImage")
    @JvmStatic
    public static void loadImage(ImageView imageView, int image) {
        System.out.println("binidng jji");
        imageView.setImageResource(image);
    }

    @BindingAdapter("roundArea")
    @JvmStatic
    public static void roundArea(TextView textView, double area) {
        Context context = textView.getContext();
        double roundNumber = new BigDecimal(area).setScale(2, RoundingMode.HALF_UP).doubleValue();
        textView.setText(context.getString(R.string.area_is) + " " + roundNumber);
    }

    @BindingAdapter("roundPerimeter")
    @JvmStatic
    public static void roundPerimeter(TextView textView, double perimeter) {
        Context context = textView.getContext();
        double roundNumber = new BigDecimal(perimeter).setScale(2, RoundingMode.HALF_UP).doubleValue();
        textView.setText(context.getString(R.string.perimeter_is) + " " + roundNumber);
    }
}