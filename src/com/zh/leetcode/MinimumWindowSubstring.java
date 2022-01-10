package com.zh.leetcode;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        m.minWindow("cabwefgewcwaefgcf",
                "cae");
    }

    public String minWindow(String s, String t) {
        String result = s;
        char[] chars = s.toCharArray();
        boolean once = false;
        buildMap(t);
        int left = 0;
        int right = left;
        while (right < s.length() && left < s.length()) {
            if (left == right) {
                if (findAndRemove(chars[left])) {
                    if(t.length()==1)return t;
                    right++;
                } else {
                    left++;
                }
            } else {
                findAndRemove(chars[right]);
                right++;
            }
            if (mapLength == 0) {
                right--;
                if (right - left + 1 <= result.length()) {
                    once = true;
                    result = s.substring(left, right + 1);
                }
                //在该范围内收缩，收缩完后直接从i=index
                for (int h = left + 1; h <= right; h++) {
                    if (inStringT(chars[h - 1])) {
                        //左指针移动时失去的数是t中的数
                        if (isMatchAfterLostChar(chars[h - 1])) {
                            if (right - h + 1 <= result.length())result = s.substring(h, right + 1);
                        } else {
                            if (right - (h-1) + 1 <= result.length())result = s.substring(h-1, right + 1);
                            //h-1标记为缺失
                            revertMap(chars[h - 1]);
                            //找到第一个在t中的字符
                            while (!inStringT(chars[h])) {
                                h++;
                            }
                            left = h;
                            right++;
                            break;
                        }
                    }
                }
            }
        }

        return once ? result : "";
    }

    private int[] map_o;
    private int[] map;
    private int[] temp;
    private int mapLength;
    int offset = 65;

    private void buildMap(String t) {

        map_o = new int['z' - offset + 1];

        for (char c : t.toCharArray()) {
            map_o[c - offset]++;
        }
        map = new int[map_o.length];
        temp = new int[map_o.length];
        mapLength = t.length();
        System.arraycopy(map_o, 0, map, 0, map.length);
    }

    private boolean findAndRemove(char c) {
        if (map_o[c - offset] != 0) {
            temp[c - offset]++;
        }
        if (map[c - offset] != 0) {
            map[c - offset]--;
            temp[c - offset]--;
            mapLength--;
            return true;
        }
        return false;
    }

    private boolean inStringT(char c) {
        if (map_o[c - offset] != 0) {
            return true;
        }
        return false;
    }

    private boolean isMatchAfterLostChar(char c) {
        if (temp[c - offset] > 0) {
            temp[c - offset]--;
            return true;
        }
        return false;
    }

    private boolean revertMap(char c) {
        if (map_o[c - offset] != 0) {
            map[c - offset]++;
            mapLength++;
            return true;
        }
        return false;
    }
}
