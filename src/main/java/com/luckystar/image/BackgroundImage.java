package com.luckystar.image;

import com.luckystar.config.ImageConfig;
import com.luckystar.utils.ImageUtil;

import java.awt.*;

/**
 * 绘制背景图片
 */
public class BackgroundImage {

    Image backgroundImage = ImageUtil.getTankImageIsFriendly(ImageConfig.BACKGROUND_DOWN);
    Image backgroundSkyImage = ImageUtil.getTankImageIsFriendly(ImageConfig.BACKGROUND_SKY);
    Image peopleMinerImage = ImageUtil.getTankImageIsFriendly(ImageConfig.PEOPLE_MINER);

    public void painSelfBackgroundImage(Graphics graphics) {
        //天空图片
        graphics.drawImage(backgroundSkyImage, 0, 0, 768, 200, null);
        //背景图片
        graphics.drawImage(backgroundImage, 0, 200, null);
        //矿工角色图片
        graphics.drawImage(peopleMinerImage, 310, 50, null);
    }
}
