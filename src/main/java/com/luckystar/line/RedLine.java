package com.luckystar.line;

import com.luckystar.GoldMiner;
import com.luckystar.common.BaseBlock;

import java.awt.*;

public class RedLine {

    //起点坐标
    private int x = 380;
    private int y = 180;

    //终点坐标
    private int endX = 500;
    private int endY = 500;

    //线长
    private double lenght = 100;
    //角度
    private double angle = 0;

    //方向
    private int dir = 1;

    //红线状态 0摇摆 1抓取 2收回 3抓取返回
    private int status;

    private GoldMiner frame;

    public RedLine(GoldMiner frame) {
        setFrame(frame);
    }

    public GoldMiner getFrame() {
        return frame;
    }

    public void setFrame(GoldMiner frame) {
        this.frame = frame;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //绘制红线
    public void paintSelfRedLine(Graphics graphics) {
        logic();
        switch (this.getStatus()) {
            case 0:
                swayLine(graphics);
                break;
            case 1:
                extendLine(graphics);
                break;
            case 2:
                regainLine(graphics);
                break;
            case 3:
                grad(graphics);
                break;
        }
    }

    //抓取时 红线处理
    private void grad(Graphics graphics) {
        if (lenght > 100) {
            lenght = lenght - 10;
            drawLine(graphics);

            for (BaseBlock smallGold : getFrame().blocksList) {

                if (smallGold.isFlag()) {
                    smallGold.setX(endX - smallGold.getWidth() / 2);
                    smallGold.setY(endY);

                    if (lenght <= 100) {
                        smallGold.setX(-150);
                        smallGold.setY(-150);
                        smallGold.setFlag(false);
                        setStatus(0);
                    }
                }


            }
        }
    }

    //收回红线
    private void regainLine(Graphics graphics) {
        if (lenght > 100) {
            lenght = lenght - 10;
            drawLine(graphics);
        } else {
            setStatus(0);
        }
    }

    //延长红线
    private void extendLine(Graphics graphics) {
        if (lenght < 600) {
            lenght = lenght + 10;
            drawLine(graphics);
        } else {
            setStatus(2);
        }
    }

    //左右 摇摆
    private void swayLine(Graphics graphics) {
        if (angle < 0) {
            dir = 1;
        } else if (angle > 1) {
            dir = -1;
        }
        angle = angle + 0.005 * dir;

        this.drawLine(graphics);
    }

    //绘制
    private void drawLine(Graphics graphics) {
        endX = (int) (x + lenght * Math.cos(angle * Math.PI));
        endY = (int) (y + lenght * Math.sin(angle * Math.PI));

        graphics.setFont(new Font("宋体", Font.PLAIN, 29));
        graphics.setColor(Color.red);
        graphics.drawLine(x, y, endX, endY);
    }

    //抓取动作
    public void logic() {
        for (BaseBlock smallGold : getFrame().blocksList) {
            if (endX > smallGold.getX() && endX < smallGold.getX() + smallGold.getWidth()
                    && endY < smallGold.getY() + smallGold.getHeight() && endY > smallGold.getY()) {
                setStatus(3);
                smallGold.setFlag(true);
            }
        }

    }
}
