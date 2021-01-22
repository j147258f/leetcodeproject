package com.zh.leetcode.foroffer;

public class o67 {
    public static void main(String[] args) {
        new o67().strToInt("2147483648");
    }

    //使用了状态模式 代码多少有点臃肿了 但是可读性强了一点
    public int strToInt(String str) {
        int result = 0;
        char[] chars = str.toCharArray();
        Context context = new Context();
        context.chars = chars;
        for (int i = 0; i < chars.length; i++) {
            context.setResult(i);
            if (context.isFinish()) break;
        }
        return context.result;
    }

    private static class Context {
        public State state = new StrState(this);
        public int result;
        public char[] chars;
        public State numberState = new NumberState(this);
        private boolean isFinish = false;
        public boolean positive = true;

        boolean isFinish() {
            return state.isFinish();
        }

        void setResult(int offset) {
            state.setResult(offset);
        }
    }

    private interface State {
        boolean check(int offset);

        void setResult(int offset);

        boolean isFinish();
    }

    private static class StrState implements State {
        public Context c;

        public StrState(Context c) {
            this.c = c;
        }

        @Override
        public boolean check(int offset) {
            if (' ' == c.chars[offset]) return true;
            if ('-' == c.chars[offset]) {
                c.positive = false;
                c.state = c.numberState;
                return true;
            }
            if ('+' == c.chars[offset]) {
                c.state = c.numberState;
                return true;
            }
            switch (c.chars[offset]) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    c.state = c.numberState;
                    c.setResult(offset);
                    return true;
            }
            c.isFinish = true;
            return false;
        }

        @Override
        public void setResult(int offset) {
            check(offset);
        }

        @Override
        public boolean isFinish() {
            return c.isFinish;
        }
    }

    //进入数字判断模式
    private static class NumberState implements State {
        public Context c;


        public NumberState(Context c) {
            this.c = c;
        }

        @Override
        public boolean check(int offset) {
            switch (c.chars[offset]) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return true;
            }
            return false;
        }

        @Override
        public void setResult(int offset) {
            if (!check(offset)) {
                c.isFinish = true;
                return;
            }
            if (c.positive) {
                int temp = c.result * 10 + (c.chars[offset] - 48);
                if ((temp - (c.chars[offset] - 48)) / 10 != c.result || temp<c.result) {
                    c.isFinish = true;
                    c.result = Integer.MAX_VALUE;
                    return;
                }
                c.result = temp;
            } else {
                int temp = c.result * 10 - (c.chars[offset] - 48);
                if ((temp+(c.chars[offset] - 48))/10 != c.result || temp>c.result) {
                    c.isFinish = true;
                    c.result = Integer.MIN_VALUE;
                    return;
                }
                c.result = temp;
            }
        }

        @Override
        public boolean isFinish() {
            return c.isFinish;
        }
    }
}
