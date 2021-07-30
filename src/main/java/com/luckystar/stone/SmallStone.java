package com.luckystar.stone;

import com.luckystar.common.BaseBlock;
import com.luckystar.config.ImageConfig;
import com.luckystar.utils.ImageUtil;

public class SmallStone extends BaseBlock {

    public SmallStone() {
        this.setX((int) (Math.random() * 700));
        this.setY((int) (Math.random() * 550 + 300));
        this.setWidth(70);
        this.setHeight(70);
        this.setFlag(false);
        this.setImage(ImageUtil.getTankImageIsFriendly(ImageConfig.SMALL_STONE));
    }
}
