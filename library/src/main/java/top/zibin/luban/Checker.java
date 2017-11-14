package top.zibin.luban;

import android.text.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Checker {
    private static List<String> format = new ArrayList<>();
    private static final String JPG = FormatInterface.JPG;
    private static final String JPEG = FormatInterface.JPEG;
    private static final String PNG = FormatInterface.PNG;
    private static final String WEBP = FormatInterface.WEBP;
    private static final String GIF = FormatInterface.GIF;

    static {
        format.add(JPG);
        format.add(JPEG);
        format.add(PNG);
        format.add(WEBP);
        format.add(GIF);
    }

    static boolean isImage(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }

        String suffix = path.substring(path.lastIndexOf(".") + 1, path.length());
        return format.contains(suffix.toLowerCase());
    }

    static boolean isJPG(String path, String srcFormat) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }

        String suffix = path.substring(path.lastIndexOf("."), path.length()).toLowerCase();
        return suffix.contains(JPG) || suffix.contains(JPEG) || srcFormat.contains(JPG) || srcFormat.contains(JPEG);
    }

    static List<String> getSupportFormat() {
        return format;
    }

    static String checkSuffix(String path) {
        if (TextUtils.isEmpty(path)) {
            return ".jpg";
        }

        return path.substring(path.lastIndexOf("."), path.length());
    }

    static boolean isNeedCompress(int leastCompressSize, String path) {
        if (leastCompressSize > 0) {
            File source = new File(path);
            if (!source.exists()) {
                return false;
            }

            if (source.length() <= (leastCompressSize << 10)) {
                return false;
            }
        }
        return true;
    }
}
