package com.lizarragabriel.polygon.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lizarragabriel.polygon.utils.Circle;
import com.lizarragabriel.polygon.utils.Cuadrado;
import com.lizarragabriel.polygon.utils.Figura;
import com.lizarragabriel.polygon.utils.Hexagon;
import com.lizarragabriel.polygon.utils.Pentagon;
import com.lizarragabriel.polygon.utils.Rectangle;
import com.lizarragabriel.polygon.utils.Triangle;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<Figura> _figure;
    private final MutableLiveData<Boolean> _isVisible;
    private final MutableLiveData<String> _firstValueText;
    private final MutableLiveData<String> _secondValueText;
    private final MutableLiveData<Boolean> _firstValueVisible;
    private final MutableLiveData<Boolean> _secondValueVisible;
    private final MutableLiveData<String> _emptyValue;
    private int selectedFigure;
    private String firstValue;
    private String secondValue;

    public HomeViewModel() {
        _isVisible = new MutableLiveData<>();
        _firstValueText = new MutableLiveData<>();
        _secondValueText = new MutableLiveData<>();
        _firstValueVisible = new MutableLiveData<>();
        _secondValueVisible = new MutableLiveData<>();
        _emptyValue = new MutableLiveData<>();
        _figure = new MutableLiveData<>();
    }

    public LiveData<Figura> getFigurax() {
        return _figure;
    }

    public LiveData<String> getFirstValueText() {
        return _firstValueText;
    }

    public LiveData<String> getSecondValueText() {
        return _secondValueText;
    }

    public LiveData<Boolean> getFirstValueVisible() {
        return _firstValueVisible;
    }

    public LiveData<Boolean> getSecondValueVisible() {
        return _secondValueVisible;
    }

    public LiveData<Boolean> getVisible() {
        return _isVisible;
    }

    public LiveData<String> getEmptyValue() {
        return _emptyValue;
    }

    // DropDown Figure Selected
    public void selectFigureFromDropDown(int figura) {
        selectedFigure = figura;
        showResults(false);
        switch (figura) {
            case 0: showOneTextLayout("Radius");
                hideTextLayaout();
                break;
            case 1:
            case 3:
                showTwoTextLayouts("Base", "Height");
                break;
            case 2: showOneTextLayout("Side");
                hideTextLayaout();
                break;
            case 4:
            case 5:
                showTwoTextLayouts("Side", "Apothem");
                break;
        }
    }

    // Calculate Button
    public void calculateButton(String firstValue, String secondValue) {
        try {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
            Figura figure;
            switch(selectedFigure) {
                case 0: figure = calculateCircle(); break;
                case 1: figure = calculateTriangle(); break;
                case 2: figure = calculateSquare(); break;
                case 3: figure = calculateRectangle(); break;
                case 4: figure = calculatePentagon(); break;
                case 5: figure = calculateHexagon(); break;
                default: throw new IllegalStateException("Unexpected value: " + selectedFigure);
            }
            updateData(figure);
            showResults(true);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // All polygon operations
    private Figura calculateCircle() {
        double radio = Double.parseDouble(firstValue);
        return new Circle(radio);
    }

    private Figura calculateTriangle() {
        double base = Double.parseDouble(firstValue);
        double altura = Double.parseDouble(secondValue);
        return new Triangle(base, altura);
    }

    private Figura calculateSquare() {
        double lado = Double.parseDouble(firstValue);
        return new Cuadrado(lado);
    }

    private Figura calculateRectangle() {
        double base = Double.parseDouble(firstValue);
        double altura = Double.parseDouble(secondValue);
        return new Rectangle(base, altura);
    }

    private Figura calculatePentagon() {
        double base = Double.parseDouble(firstValue);
        double apotema = Double.parseDouble(secondValue);
        return new Pentagon(base, apotema);
    }

    private Figura calculateHexagon() {
        double base = Double.parseDouble(firstValue);
        double apotema = Double.parseDouble(secondValue);
        return new Hexagon(base, apotema);
    }

    // UI
    // Show only one EditText and change Hint
    private void showOneTextLayout(String firstHint) {
        _emptyValue.postValue("");
        _firstValueText.postValue(firstHint);
        _firstValueVisible.postValue(true);
    }

    // Show all EditText and change Hint
    private void showTwoTextLayouts(String firstHint, String secondHint) {
        _emptyValue.postValue("");
        _firstValueText.postValue(firstHint);
        _firstValueVisible.postValue(true);
        _secondValueText.postValue(secondHint);
        _secondValueVisible.postValue(true);
    }

    // Hide second EditText if user only need one input
    private void hideTextLayaout() {
        _secondValueVisible.postValue(false);
    }

    // Update LiveData
    private void updateData(Figura figurita) {
        _figure.postValue(figurita);
    }

    // True make XML results Layout visible to user. False hide layout
    private void showResults(Boolean isShow) {
        _isVisible.postValue(isShow);
    }
}
