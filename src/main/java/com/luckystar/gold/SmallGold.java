package com.luckystar.gold;

import com.luckystar.common.BaseBlock;
import com.luckystar.config.ImageConfig;
import com.luckystar.utils.ImageUtil;

public class SmallGold extends BaseBlock {

    public SmallGold() {
        this.setX((int) (Math.random() * 700));
        this.setY((int) (Math.random() * 550 + 200));
        this.setWidth(52);
        this.setHeight(52);
        this.setFlag(false);
        this.setImage(ImageUtil.getTankImageIsFriendly(ImageConfig.SMALL_GOLD));
    }

}
