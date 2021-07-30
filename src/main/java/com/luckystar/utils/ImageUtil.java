package com.luckystar.utils;

import com.luckystar.GoldMiner;
import java.awt.*;

public class ImageUtil {
    private static final Toolkit tk = Toolkit.getDefaultToolkit();

    public static Image getTankImageIsFriendly(String path) {
        return tk.getImage(GoldMiner.class.getClassLoader().getResource(path));
    }
}
