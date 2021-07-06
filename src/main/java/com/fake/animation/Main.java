package com.fake.animation;

import javax.swing.*;

import com.fake.animation.algorithm.sort.ChooseSort;
import com.fake.animation.demo.Demo;

/**
 * @author by catface
 * @date 2021/7/6 4:49 下午
 */
public class Main {

    public static void main(String[] args) {
        Demo demo = new ChooseSort();
        JFrame buildDemoFrame = demo.buildDemoFrame();
        buildDemoFrame.setVisible(true);
    }
}
