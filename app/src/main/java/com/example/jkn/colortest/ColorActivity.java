package com.example.jkn.colortest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class ColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    public final static String TAG = ColorActivity.class.getSimpleName();

    SeekBar barHue;
    SeekBar barSaturation;
    SeekBar barBrightness;
    View colorField;
    TextView colorName;

    int currentColor;
    List<ColorName> colorNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        ColorParser colorParser = new ColorParser(this);
        colorNameList = colorParser.getColorsAsList();

        ColorName testColor = ColorName.findClostestColorName(colorNameList, Color.BLUE);
        Log.d("Test", testColor.getName());

        ColorName testColor2 = ColorName.findClostestColorName(colorNameList, Color.CYAN);
        Log.d("Test", testColor2.getName());

        setViewReferences();

        initListeners();
    }

    private void setViewReferences() {
        barHue = (SeekBar) findViewById(R.id.bar_hue);
        barSaturation = (SeekBar) findViewById(R.id.bar_saturation);
        barBrightness = (SeekBar) findViewById(R.id.bar_brightness);
        colorField = findViewById(R.id.color_field);
        colorName = (TextView) findViewById(R.id.color_name);
    }

    private void initListeners() {
        barHue.setOnSeekBarChangeListener(this);
        barSaturation.setOnSeekBarChangeListener(this);
        barBrightness.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        calculateCurrentColor();
        updateColorField();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        hideColorName();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        updateColorName();
        showColorName();
    }

    private void updateColorField() {

        colorField.setBackgroundColor(currentColor);
    }

    private void calculateCurrentColor() {
        float hueValue = (float) barHue.getProgress() * 3.6f;
        float saturationValue = (float) barSaturation.getProgress() / 100;
        float brightnessValue = (float) barBrightness.getProgress() / 100;

        currentColor = Color.HSVToColor(new float[] {hueValue, saturationValue, brightnessValue});
    }

    private void hideColorName(){
        colorName.setVisibility(View.GONE);
    };

    private void showColorName(){
        colorName.setVisibility(View.VISIBLE);
    };

    private void updateColorName() {
        colorName.setText(ColorName.findClostestColorName(colorNameList, currentColor).getName());
    }
}
