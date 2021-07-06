package com.fake.animation.algorithm.sort;

import java.awt.*;

import javax.swing.*;

import com.fake.animation.util.ArrayContainer;
import com.fake.animation.util.Delay;

/**
 * @author by catface
 * @date 2021/7/6 1:50 下午
 */
public class BubbleSort {

    public static void main(String[] args) {
        int delay = 500;
        JFrame jf = new JFrame("冒泡排序");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 创建内容面板，使用边界布局
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        ArrayContainer arrayContainer = new ArrayContainer();
        Container panel = arrayContainer.build(arr);
        new Thread(() -> {
            for (int i = arr.length; i >= 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    Delay.delayMilliseconds(delay);
                    arrayContainer.choose(j,j+1,Color.BLUE);
                    Delay.delayMilliseconds(delay);
                    if (arr[j] > arr[j + 1]) {
                        arrayContainer.choose(j,j+1,Color.GREEN);
                        Delay.delayMilliseconds(delay);
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        arrayContainer.swapContext(j,j+1);
                        arrayContainer.choose(j,j+1,Color.YELLOW);
                    }else{
                        arrayContainer.choose(j,j+1,Color.RED);
                    }
                    Delay.delayMilliseconds(delay);
                    arrayContainer.setDefaultColor(j);
                    arrayContainer.setDefaultColor(j+1);
                }
                if (i>0){
                    arrayContainer.choose(i-1,Color.YELLOW);
                }
            }
            System.out.println("sort finish.");
        }).start();
        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
