package com.fake.animation.algorithm.sort;

import java.awt.*;

import javax.swing.*;

import com.fake.animation.demo.Demo;
import com.fake.animation.util.ArrayJPanel;
import com.fake.animation.util.ArrayUtil;
import com.fake.animation.util.Delay;

/**
 * @author by catface
 * @date 2021/7/6 4:45 下午
 */
public class ChooseSort implements Demo {

    /**
     * 展示 demo
     *
     * @return jFrame
     */
    @Override
    public JFrame buildDemoFrame() {

        int delay = 500;
        JFrame jFrame = new JFrame("选择排序");
        JPanel parent = new JPanel(new GridLayout(3, 1));
        // 原始数组面板
        Integer[] arr = ArrayUtil.randomIntegerArray(10, 1, 100);
        String arrText = "原始数组:" + ArrayUtil.arrToString(arr);
        JPanel originPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        originPanel.add(new Label(arrText));

        // 排序数组面板
        ArrayJPanel arrayJPanel = new ArrayJPanel();
        JPanel sortPanel = arrayJPanel.build(arr);

        // 当前max面板
        JPanel maxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        maxPanel.add(new Label("最小值的下标->最小值:"));
        Button minBtn = new Button("");
        maxPanel.add(minBtn);

        // 组合面板
        parent.add(originPanel);
        parent.add(sortPanel);
        parent.add(maxPanel);

        jFrame.setContentPane(parent);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);

        // 异步执行排序方法
        new Thread(() -> {
            int min;

            for (int i = 0; i < arr.length; i++) {
                min = i;
                minBtn.setLabel(min + "->" + arr[min]);
                Delay.delayMilliseconds(delay);
                for (int j = i; j < arr.length; j++) {
                    Delay.delayMilliseconds(delay);
                    arrayJPanel.choose(j, Color.BLUE);
                    Delay.delayMilliseconds(delay);
                    if (arr[j] < arr[min]) {
                        min = j;
                        arrayJPanel.choose(j, Color.GREEN);
                        minBtn.setBackground(Color.GREEN);
                        minBtn.setLabel(min + "->" + arr[min]);
                    } else {
                        arrayJPanel.choose(j, Color.RED);
                        minBtn.setBackground(Color.RED);
                    }
                    Delay.delayMilliseconds(delay);
                    arrayJPanel.setDefaultColor(j);
                    minBtn.setBackground(ArrayJPanel.getDefaultColor());
                }
                arrayJPanel.choose(i, Color.YELLOW);
                arrayJPanel.choose(min, Color.YELLOW);
                int minValue = arr[min];
                arr[min] = arr[i];
                arr[i] = minValue;
                arrayJPanel.swapContext(i, min);
                Delay.delayMilliseconds(delay);
                if (i != min) {
                    arrayJPanel.choose(min, ArrayJPanel.getDefaultColor());
                }
            }
        }).start();

        return jFrame;
    }
}
