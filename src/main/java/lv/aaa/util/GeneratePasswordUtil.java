package lv.aaa.util;

import java.util.HashMap;
import java.util.Random;

public class GeneratePasswordUtil {
    private static Random rand = new Random();

    public GeneratePasswordUtil() {
    }

    public static String getPasswords(Integer wordNum) {
        int total = wordNum;
        StringBuffer password = new StringBuffer();
        int upperNum = getRadomInt(1, total - 2);
        int lowerNum = getRadomInt(1, total - upperNum - 1);
        int nnum = total - upperNum - lowerNum;
        HashMap indexMap = new HashMap();

        int i;
        while(indexMap.size() < upperNum) {
            i = getRadomInt(0, total - 1);
            if (indexMap.get(i) == null) {
                indexMap.put(i, "upper");
            }
        }

        while(indexMap.size() < upperNum + lowerNum) {
            i = getRadomInt(0, total - 1);
            if (indexMap.get(i) == null) {
                indexMap.put(i, "lower");
            }
        }

        while(indexMap.size() < total) {
            i = getRadomInt(0, total - 1);
            if (indexMap.get(i) == null) {
                indexMap.put(i, "nnum");
            }
        }

        for(i = 0; i < total; ++i) {
            if ("upper".equals(indexMap.get(i))) {
                password.append(getUpper());
            } else if ("lower".equals(indexMap.get(i))) {
                password.append(getLetter());
            } else {
                password.append(getNum());
            }
        }

        return password.toString();
    }

    public static char getLetter() {
        char c = (char)getRadomInt(97, 122);
        return c;
    }

    public static char getUpper() {
        char c = (char)getRadomInt(65, 90);
        return c;
    }

    public static int getNum() {
        return getRadomInt(0, 9);
    }

    public static int getRadomInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
}
