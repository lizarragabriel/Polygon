package com.lizarragabriel.poligonos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.lizarragabriel.poligonos.ViewModel.HomeViewModel;
import com.lizarragabriel.poligonos.databinding.FragmentHomeBinding;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    private HomeViewModel mViewModel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Figura. Se guardará el poligono seleccionado en grado caso de un cambio de configuración
        mViewModel.mGetFigure().observe(getViewLifecycleOwner(), mFigure -> {
            mFigureSelected(mFigure);
        });

        // TextView Area
        mViewModel.getArea().observe(getViewLifecycleOwner(), mArea -> {
            mShowResult();
            binding.setArea("Área " + mArea);
        });

        // TextView Perimetro
        mViewModel.getPerimetro().observe(getViewLifecycleOwner(), mPerimetro -> {
            binding.setPerimeter("Perimetro " + mPerimetro);
        });

        // Adaptador Poligonos
        String[] mFiguras = getResources().getStringArray(R.array.figuras);
        ArrayAdapter mAdapter = new ArrayAdapter(getContext(), R.layout.list_item, mFiguras);
        binding.mDropDown.setAdapter(mAdapter);
        binding.mDropDown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mViewModel.mSetFigure(i);
            }
        });
    }

    // Regresa la figura que se seleccionó
    private void mFigureSelected(Integer mFigure) {
        switch(mFigure) {
            case 0:
                mCalcularCirculo();
                break;
            case 1:
                mCalcularTriangulo();
                break;
            case 2:
                mCalcularCuadrado();
                break;
            case 3:
                mCalcularRectangulo();
                break;
            case 4:
                mCalcularPentagono();
                break;
            case 5:
                mCalcularHexagono();
                break;
        }
    }

    private void mCalcularCirculo() {
        mHideAll();
        binding.mFirstValueInput.setHint("Radio");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularCirculo(binding.mFirstValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mCalcularTriangulo() {
        mHideAll();
        binding.mFirstValueInput.setHint("Base");
        binding.mSecondValueInput.setHint("Altura");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mSecondValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mSecondValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularTriangulo(binding.mFirstValue.getText().toString(), binding.mSecondValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mCalcularCuadrado() {
        mHideAll();
        binding.mFirstValueInput.setHint("Lado");
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularCuadrado(binding.mFirstValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mCalcularRectangulo() {
        mHideAll();
        binding.mFirstValueInput.setHint("Largo");
        binding.mSecondValueInput.setHint("Ancho");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mSecondValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mSecondValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularRectangulo(binding.mFirstValue.getText().toString(), binding.mSecondValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mCalcularPentagono() {
        mHideAll();
        binding.mFirstValueInput.setHint("Base");
        binding.mSecondValueInput.setHint("Apotema");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mSecondValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mSecondValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularPentagono(binding.mFirstValue.getText().toString(), binding.mSecondValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mCalcularHexagono() {
        mHideAll();
        binding.mFirstValueInput.setHint("Base");
        binding.mSecondValueInput.setHint("Apotema");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mSecondValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mSecondValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            mViewModel.mCalcularHexagono(binding.mFirstValue.getText().toString(), binding.mSecondValue.getText().toString());
            mClear();
            mFinish();
        });
    }

    private void mHideAll() {
        binding.mFirstValue.setVisibility(View.GONE);
        binding.mSecondValue.setVisibility(View.GONE);
        binding.mFirstValueInput.setVisibility(View.GONE);
        binding.mSecondValueInput.setVisibility(View.GONE);
        binding.mShowArea.setVisibility(View.GONE);
        binding.mShowPerimeter.setVisibility(View.GONE);
    }

    private void mClear() {
        /*binding.mFirstValue.getText().clear();
        binding.mSecondValue.getText().clear();*/
        /*binding.mFirstValue.clearFocus();
        binding.mSecondValue.clearFocus();*/

    }

    private void mFinish() {

        binding.mFirstValue.onEditorAction(EditorInfo.IME_ACTION_DONE);
        binding.mSecondValue.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    private void mShowResult() {
        binding.mShowArea.setVisibility(View.VISIBLE);
        binding.mShowPerimeter.setVisibility(View.VISIBLE);
        binding.mShowFormula.setVisibility(View.VISIBLE);
    }
}