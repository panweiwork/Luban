package top.zibin.luban;

import java.util.List;

/**
 * Created by panwei on 2017/11/14.
 */

public class FormatInterface {

    public static final String JPG = "jpg";
    public static final String JPEG = "jpeg";
    public static final String PNG = "png";
    public static final String WEBP = "webp";
    public static final String GIF = "gif";

    public static List<String> getSupportFormat() {
        return Checker.getSupportFormat();
    }
}
