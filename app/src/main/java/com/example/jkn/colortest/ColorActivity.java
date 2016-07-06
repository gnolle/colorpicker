package com.example.jkn.colortest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
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
    SeekBar barValue;
    View colorField;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        ColorParser colorParser = new ColorParser(this);
        List<ColorName> colorNameList = colorParser.getColorsAsList();

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
        barValue = (SeekBar) findViewById(R.id.bar_value);
        colorField = findViewById(R.id.color_field);
        colorName = (TextView) findViewById(R.id.color_name);
    }

    private void initListeners() {
        barHue.setOnSeekBarChangeListener(this);
        barSaturation.setOnSeekBarChangeListener(this);
        barValue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d(TAG, String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
