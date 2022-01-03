package com.lizarragabriel.poligonos.ViewModel;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lizarragabriel.poligonos.Circle;
import com.lizarragabriel.poligonos.Cuadrado;
import com.lizarragabriel.poligonos.Figura;
import com.lizarragabriel.poligonos.Hexagon;
import com.lizarragabriel.poligonos.Pentagon;
import com.lizarragabriel.poligonos.Rectangle;
import com.lizarragabriel.poligonos.Triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeViewModel extends ViewModel {
    MutableLiveData<Double> area;
    MutableLiveData<Double> perimetro;
    MutableLiveData<String> mFormula;
    MutableLiveData<Integer> mFigure;


    public HomeViewModel() {
        area = new MutableLiveData<>();
        perimetro = new MutableLiveData<>();
        mFigure = new MutableLiveData<>();
        mFormula = new MutableLiveData<>();
    }

    public LiveData<Double> getArea() {
        return area;
    }

    public LiveData<Double> getPerimetro() {
        return perimetro;
    }

    public LiveData<String> mGetFormula() {
        return mFormula;
    }

    public LiveData<Integer> mGetFigure() {
        return mFigure;
    }

    public void mSetFigure(int mFigura) {
        mFigure.setValue(mFigura);
        /*switch(mFigura) {
            case 0:
                mFormula.setValue("Fórmula\nÁrea: PI * radio2\nPerimetro: PI * radio");
                break;
            case 1:
                mFormula.setValue("Fórmula\nÁrea: base * altura\nPerimetro: base * 3");
                break;
            case 2:
                mFormula.setValue("Fórmula\nÁrea: lado2\nPerimetro: lado * 4");
                break;

        }*/
    }

    public void mCalcularCirculo(String mNewRadio) {
        try {
            double mRadio = Double.parseDouble(mNewRadio);
            Figura mFigure = new Circle(mRadio);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            mFormula.setValue("Área: PI * radio2\nPerimetro: PI * radio");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mCalcularTriangulo(String mNewBase, String mNewAltura) {
        try {
            double mBase = Double.parseDouble(mNewBase);
            double mAltura = Double.parseDouble(mNewAltura);
            Figura mFigure = new Triangle(mBase, mAltura);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            mFormula.setValue("Área: base * altura\nPerimetro: base * 3");
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
            mFormula.setValue("Área: lado2\nPerimetro: lado * 4");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mCalcularRectangulo(String mNewLargo, String mNewAncho) {
        try {
            double mLargo = Double.parseDouble(mNewLargo);
            double mAncho = Double.parseDouble(mNewAncho);
            Figura mFigure = new Rectangle(mLargo, mAncho);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            mFormula.setValue("Área: base * altura\nPerimetro: base(2) + altura(2)");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mCalcularPentagono(String mNewBase, String mNewApotema) {
        try {
            double mBase = Double.parseDouble(mNewBase);
            double mApotema = Double.parseDouble(mNewApotema);
            Figura mFigure = new Pentagon(mBase, mApotema);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mCalcularHexagono(String mNewBase, String mNewApotema) {
        try {
            double mBase = Double.parseDouble(mNewBase);
            double mApotema = Double.parseDouble(mNewApotema);
            Figura mFigure = new Hexagon(mBase, mApotema);
            area.setValue(new BigDecimal(mFigure.mCalculateArea()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            perimetro.setValue(new BigDecimal(mFigure.mCalculatePerimeter()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


}
