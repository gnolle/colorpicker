package com.example.jkn.colortest;

import android.graphics.Color;

import java.util.List;

/**
 * Created by Jan Klostermann on 01.07.2016.
 */
public class ColorName {

    private String name;
    private String hexColor;
    private int color;

    public ColorName() {

    }

    public ColorName(String name, String hexColor, int color) {
        this.name = name;
        this.hexColor = hexColor;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static ColorName findClostestColorName(List<ColorName> colorNameList, int colorToName) {

        double nearestColorDistance = Double.MAX_VALUE;
        ColorName nearestColorName = null;

        for (ColorName colorName : colorNameList) {
            int color = colorName.getColor();
            int r = Color.red(color);
            int g = Color.green(color);
            int b = Color.blue(color);

            int r1 = Color.red(colorToName);
            int g1 = Color.green(colorToName);
            int b1 = Color.blue(colorToName);

            double difference = Math.sqrt(Math.pow(r - r1, 2) + Math.pow(g - g1, 2) + Math.pow(b - b1, 2));

            if (difference == 0) {
                nearestColorName = colorName;
                break;
            }

            if (difference < nearestColorDistance) {
                nearestColorDistance = difference;
                nearestColorName = colorName;
            }
        }

        return nearestColorName;
    }
}
