package com.example.jkn.colortest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ColorActivity extends Activity {

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
    }
}
