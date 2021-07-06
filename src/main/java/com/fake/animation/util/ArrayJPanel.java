package com.fake.animation.util;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/**
 * @author by catface
 * @date 2021/7/6 2:27 下午
 */
public class ArrayJPanel {

    private static Color defaultColor;
    private Button[] bts;

    public static Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(int index) {
        bts[index].setBackground(defaultColor);
    }

    public JPanel build(Object[] arr) {
        this.bts = new Button[arr.length];
        // 排序展示面板
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int i = 0; i < arr.length; i++) {
            bts[i] = new Button(arr[i].toString());
            jPanel.add(bts[i]);
        }
        defaultColor = bts[0].getBackground();
        return jPanel;
    }

    public void flash(int index, int times) {
        Color originColor = bts[index].getBackground();
        for (int i = 0; i < times; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                if (i % 2 == 0) {
                    bts[index].setBackground(Color.RED);
                } else {
                    bts[index].setBackground(Color.BLUE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bts[index].setBackground(originColor);
    }

    public void flash(int index, int times, Color preColor, Color afterColor) {
        for (int i = 0; i < times; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                if (i % 2 == 0) {
                    bts[index].setBackground(preColor);
                } else {
                    bts[index].setBackground(afterColor);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bts[index].setBackground(defaultColor);
    }

    public void choose(int index) {
        bts[index].setBackground(Color.BLUE);
    }

    public void choose(int index, Color color) {
        bts[index].setBackground(color);
    }

    public void choose(int indexA, int indexB) {
        bts[indexA].setBackground(Color.BLUE);
        bts[indexB].setBackground(Color.BLUE);
    }

    public void choose(int indexA, int indexB, Color color) {
        bts[indexA].setBackground(color);
        bts[indexB].setBackground(color);
    }

    public void swapContext(int indexA, int indexB) {
        String label = bts[indexA].getLabel();
        bts[indexA].setLabel(bts[indexB].getLabel());
        bts[indexB].setLabel(label);
    }
}
