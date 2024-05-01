package _2_Implementation.StringBuffer;

import java.util.Random;

public class RandomString {

    Random rd;

    RandomString() {
        rd = new Random();
    }

    String getRandomString() {
        return getRandomString(rd.nextInt(101));
    }

    String getRandomString(int size) {
        return getRandomString(size, 500, false);
    }

    String getRandomAlphaString() {
        return getRandomAlphaString(rd.nextInt(101));
    }

    String getRandomAlphaString(int size) {
        return getRandomString(size, 26, true);
    }

    String getRandomString(int size, int range, boolean alpha) {
        StringBuffer sb = new StringBuffer();
        int rStart = 0;
        for (int i = 0; i < size; i++) {
            if(alpha) rStart = (rd.nextInt(2) == 1)? 'a': 'A';
            sb.append((char) (rStart + rd.nextInt(range)));
        }
        return sb.toString();
    }
}