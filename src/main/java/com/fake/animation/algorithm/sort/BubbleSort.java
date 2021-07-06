package com.fake.animation.algorithm.sort;

import java.awt.*;

import javax.swing.*;

import com.fake.animation.demo.Demo;
import com.fake.animation.util.ArrayJPanel;
import com.fake.animation.util.Delay;

/**
 * @author by catface
 * @date 2021/7/6 1:50 下午
 */
public class BubbleSort implements Demo {

    /**
     * 展示 demo
     */
    @Override
    public JFrame buildDemoFrame() {
        int delay = 500;
        JFrame jf = new JFrame("冒泡排序");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 创建内容面板，使用边界布局
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        ArrayJPanel arrayJPanel = new ArrayJPanel();
        JPanel parent = new JPanel(new GridLayout(2,1));

        // 子面板,原始数组
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        textPanel.add(new Label("原始数组"));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i].toString());
            if (i < arr.length - 1) {
                stringBuilder.append(",");
            }
        }
        textPanel.add(new Label(stringBuilder.toString()));
        parent.add(textPanel);

        JPanel sortPanel = arrayJPanel.build(arr);
        parent.add(sortPanel);

        new Thread(() -> {
            for (int i = arr.length; i >= 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    Delay.delayMilliseconds(delay);
                    arrayJPanel.choose(j,j+1,Color.BLUE);
                    Delay.delayMilliseconds(delay);
                    if (arr[j] > arr[j + 1]) {
                        arrayJPanel.choose(j,j+1,Color.GREEN);
                        Delay.delayMilliseconds(delay);
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        arrayJPanel.swapContext(j,j+1);
                        arrayJPanel.choose(j,j+1,Color.YELLOW);
                    }else{
                        arrayJPanel.choose(j,j+1,Color.RED);
                    }
                    Delay.delayMilliseconds(delay);
                    arrayJPanel.setDefaultColor(j);
                    arrayJPanel.setDefaultColor(j+1);
                }
                if (i>0){
                    arrayJPanel.choose(i-1,Color.YELLOW);
                }
            }
            System.out.println("sort finish.");
        }).start();
        jf.setContentPane(parent);
        jf.pack();
        jf.setLocationRelativeTo(null);
        return jf;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.buildDemoFrame();
    }

}
