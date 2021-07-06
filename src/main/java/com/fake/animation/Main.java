package com.fake.animation;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author by catface
 * @date 2021/7/6 1:50 下午
 */
public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试数组");
        jf.setSize(1000, 1000);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 创建内容面板，使用边界布局
        JPanel panel = new JPanel(new BorderLayout());

        // 表头（列名）

        Object[] columnNames = new Integer[10];
        for (int i = 0; i < 10; i++) {
            columnNames[i] = i;
        }

        // 表格所有行数据
        Object[][] rowData = new Integer[1][10];
        for (int i = 0; i < 10; i++) {
            rowData[0][i] = (int)(Math.random() * 100);
        }

        // 创建一个表格，指定 所有行数据 和 表头
        JTable table = new JTable(rowData, columnNames);
        table.setBorder(BorderFactory.createBevelBorder(0));

        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        // 把 表格内容 添加到容器中心
        panel.add(table, BorderLayout.CENTER);

        jf.setContentPane(panel);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
