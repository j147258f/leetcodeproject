package com.zh.leetcode.foroffer;

import java.util.HashMap;
import java.util.Map;

public class o20 {
    public static void main(String[] args) {
        new o20().isNumber_ugly(" +51.93483302981e917");
    }

    //状态机答案  虽然复杂 但是责任清晰 有点类似状态模式
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END,
    }

    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL,
    }

    //虽然写出来了 但是真丑陋  明天用状态机重新
    public boolean isNumber_ugly(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        //跳过空格
        while (start != end) {
            if (chars[start] == ' ') start++;
            else if (chars[end] == ' ') end--;
            else break;
        }
        if (start == chars.length) return false;

        //+-
        if (chars[start] != '+' && chars[start] != '-' && !isNumber_ugly(chars[start]) && chars[start] != '.') return false;
        //小数点个数
        int littleIndex = -1;
        int littleE = -1;
        int i = start + 1;
        if (chars[start] == '.') littleIndex = start;
        while (i <= end) {
            if (chars[i] == '.') {
                if (littleIndex != -1) return false;
                littleIndex = i;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if(i-1<start || (!isNumber_ugly(chars[i-1])&&chars[i-1]!='.'))return false;
                littleE = i;
                i++;
                break;
            } else if (!isNumber_ugly(chars[i])) {
                return false;
            }
            i++;
        }
        if (littleIndex != -1 && (littleIndex - 1 < start || !isNumber_ugly(chars[littleIndex - 1]))
                && (littleIndex + 1 > end || !isNumber_ugly(chars[littleIndex + 1]))) return false;


        if (littleE != -1) {
            //e的表示
            if (littleE == end) return false;
            if (i <= end && (chars[i] == '-' || chars[i] == '+')) i++;
            if (i > end || !isNumber_ugly(chars[i])) return false;
            while (i <= end) {
                if (chars[i] == '.') {
                    return false;
                } else if (chars[i] == 'e' || chars[i] == 'E') {
                    return false;
                } else if (!isNumber_ugly(chars[i])) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public boolean isNumber_ugly(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}
