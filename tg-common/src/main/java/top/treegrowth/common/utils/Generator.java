package top.treegrowth.common.utils;

import java.util.Random;
import java.util.UUID;

public class Generator {

    private static final Random random = new Random();

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getCode(int length) {
        return String.valueOf(random.nextInt(length));
    }
}
