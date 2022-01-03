package com.lizarragabriel.poligonos.ViewModel;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lizarragabriel.poligonos.Circle;
import com.lizarragabriel.poligonos.Cuadrado;
import com.lizarragabriel.poligonos.Figura;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeViewModel extends ViewModel {
    MutableLiveData<Double> area;
    MutableLiveData<Double> perimetro;

    public HomeViewModel() {
        area = new MutableLiveData<>();
        perimetro = new MutableLiveData<>();
    }

    public MutableLiveData<Double> getArea() {
        return area;
    }

    public MutableLiveData<Double> getPerimetro() {
        return perimetro;
    }

    public void mCalcularCirculo(String mNewRadio) {
        try {
            double mRadio = Double.parseDouble(mNewRadio);
            Figura mFigure = new Circle(mRadio);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mCalcularCuadrado(String mNewBase) {
        try {
            double mBase = Double.parseDouble(mNewBase);
            Figura mFigure = new Cuadrado(mBase);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


}
