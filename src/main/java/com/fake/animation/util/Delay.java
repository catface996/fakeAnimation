package com.fake.animation.util;

import java.util.concurrent.TimeUnit;

/**
 * @author by catface
 * @date 2021/7/6 3:36 下午
 */
public class Delay {

    public static void delaySeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delayMilliseconds(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
