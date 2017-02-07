package top.treegrowth.common.utils;

import java.util.UUID;

public class Generator {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getCode(int length){
        //(int)3542188.140884921 只会截取小数点前面的数
        return String.valueOf((int)((Math.random()*9+1)*Math.pow(10,length-1)));
    }
}
