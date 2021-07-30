package com.luckystar;

import com.luckystar.common.BaseBlock;
import com.luckystar.gold.SmallGold;
import com.luckystar.image.BackgroundImage;
import com.luckystar.line.RedLine;
import com.luckystar.stone.SmallStone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GoldMiner extends JFrame {

    //需要重复绘制,单独提取出来处理
    RedLine redLine = new RedLine(this);

    //存储金块
    public List<BaseBlock> blocksList = new ArrayList<>();

    {
        for (int i = 0; i < 3; i++) {
            blocksList.add(new SmallGold());
        }

        for (int s = 0; s < 10; s++) {
            blocksList.add(new SmallStone());
        }
    }

    void launch() {
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(768, 824);
        //设置窗口位置(居中)
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("幸运矿工");

        //点击窗口右上角关闭
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //鼠标左键点击 1   3=右键,2=滚动
                if (e.getButton() == 1) {
                    redLine.setStatus(1);
                }
            }
        });

        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //使用双缓存技术,把元素绘制到一个画布上,等所有的东西都绘制到画布之后,再把画布绘制到主窗体,以此来解决元素抖动问题
        // (因为所有的元素在画布上都已经绘制成功,自然也就不会抖动了)
        Image offScreenImage = this.createImage(768, 824);
        Graphics gImage = offScreenImage.getGraphics();

        BackgroundImage backgroundImageDown = new BackgroundImage();
        backgroundImageDown.painSelfBackgroundImage(gImage);


        for (BaseBlock baseGold : blocksList) {
            baseGold.paintSelf(gImage);
        }

        redLine.paintSelfRedLine(gImage);

        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        GoldMiner gameWin = new GoldMiner();
        gameWin.launch();
    }
}

