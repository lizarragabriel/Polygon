package com.lizarragabriel.poligonos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] mFiguras = getResources().getStringArray(R.array.figuras);
        ArrayAdapter mAdapter = new ArrayAdapter(getContext(), R.layout.list_item, mFiguras);
        binding.mDropDown.setAdapter(mAdapter);
        binding.mDropDown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i) {
                    case 0:
                        Toast.makeText(getContext(), "Circulo", Toast.LENGTH_SHORT).show();
                        mCalcularCirculo();
                        break;

                    case 1:
                        Toast.makeText(getContext(), "Triangulo", Toast.LENGTH_SHORT).show();
                        mCalcularTriangulo();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Cuadrado", Toast.LENGTH_SHORT).show();
                        mCalcularCuadrado();
                        break;

                    case 3:
                        Toast.makeText(getContext(), "Rectaungulo", Toast.LENGTH_SHORT).show();
                        mCalcularRectangulo();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "Pentagono", Toast.LENGTH_SHORT).show();
                        mCalcularPentagono();
                        break;
                    case 5:
                        Toast.makeText(getContext(), "Hexagono", Toast.LENGTH_SHORT).show();
                        mCalcularHexagono();
                        break;
                }
            }
        });


    }

    private void mCalcularCirculo() {
        mHideAll();
        binding.mFirstValueInput.setHint("Radio");
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            try {
                double mRadio = Double.parseDouble(binding.mFirstValue.getText().toString());
                Figura mFigure = new Circle(mRadio);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
            try {
                double mWidth = Double.parseDouble(binding.mFirstValue.getText().toString());
                double mHeight = Double.parseDouble(binding.mSecondValue.getText().toString());
                Figura mFigure = new Triangle(mWidth, mHeight);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mCalcularCuadrado() {
        mHideAll();
        binding.mFirstValueInput.setHint("Lado");
        binding.mFirstValueInput.setVisibility(View.VISIBLE);
        binding.mFirstValue.setVisibility(View.VISIBLE);
        binding.mCalculate.setVisibility(View.VISIBLE);
        binding.mCalculate.setOnClickListener(v -> {
            try {
                double mBase = Double.parseDouble(binding.mFirstValue.getText().toString());
                Figura mFigure = new Cuadrado(mBase);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
            try {
                double mHeight = Double.parseDouble(binding.mFirstValue.getText().toString());
                double mWidth = Double.parseDouble(binding.mSecondValue.getText().toString());
                Figura mFigure = new Rectangle(mHeight, mWidth);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
            try {
                double mWidth = Double.parseDouble(binding.mFirstValue.getText().toString());
                double mApothem = Double.parseDouble(binding.mSecondValue.getText().toString());
                Figura mFigure = new Pentagon(mWidth, mApothem);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
            try {
                double mWidth = Double.parseDouble(binding.mFirstValue.getText().toString());
                double mApothem = Double.parseDouble(binding.mSecondValue.getText().toString());
                Figura mFigure = new Hexagon(mWidth, mApothem);
                double mArea = new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                double mPerimeter = new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                binding.setArea("El área es: " + mArea);
                binding.setPerimeter("El perimetro es: " + mPerimeter);

                binding.mShowArea.setVisibility(View.VISIBLE);
                binding.mShowPerimeter.setVisibility(View.VISIBLE);
                mClear();
                mFinish();
            } catch (RuntimeException e) {
                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
        binding.mFirstValue.getText().clear();
        binding.mSecondValue.getText().clear();

    }

    private void mFinish() {
        binding.mFirstValue.setCursorVisible(false);
        binding.mFirstValue.onEditorAction(EditorInfo.IME_ACTION_DONE);
        binding.mSecondValue.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }
}