package com.zh.leetcode;

//388. 文件的最长绝对路径
public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
        System.out.println(l.lengthLongestPath("skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj.sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf.sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj\n\t\t\tlskjdflk.sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf.sdlkfj\n\t\t\t\t\tlsdkjf\n\t\t\t\t\t\tsldkfjl.sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a"));
    }

    public int lengthLongestPath(String input) {
        int result = findMaxDeepIndex(input);
        if (result == -1) return 0;
        return result;
    }

    private int findMaxDeepIndex(String input) {
        int result = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                int fileBegin = i;
                while (fileBegin >= 0) {
                    if (input.charAt(fileBegin) != '\t' && input.charAt(fileBegin) != '\n')
                        fileBegin--;
                    else break;
                }
                fileBegin++;
                //找到文件  开始计算路径长度
                result = Math.max(result, getLength(fileBegin, input));
            }
        }
        return result;
    }

    private int getLength(int index, String input) {
        int length = 0;
        if (index == 0 || input.charAt(index - 1) != '\t') {
            for (int j = index; j < input.length(); j++) {
                if (input.charAt(j) != '\n') {
                    length++;
                } else break;
            }
            return length;
        }

        Integer deep = null;
        Integer maxDeep = null;

        int i = index;
        while (i >= 0) {
            if (deep != null && deep == 0) break;
            if (input.charAt(i) == '\t') {
                int j = i;
                int thisDeep = 0;
                while (j >= 0) {
                    if (input.charAt(j) == '\t') {
                        thisDeep++;
                        j--;
                    } else break;
                }
                if (maxDeep == null) {
                    maxDeep = thisDeep;
                    deep = thisDeep;
                }
                if (thisDeep == deep) {
                    j = i + 1;
                    while (j < input.length()) {
                        if (input.charAt(j) != '\t' && input.charAt(j) != '\n') {
                            length++;
                            j++;
                        } else break;
                    }
                    deep--;
                }
                i = i - thisDeep + 1;
            }
            i--;
        }
        while (i >= 1) {
            if (input.charAt(i) != '\t' && input.charAt(i - 1) == '\n') {
                for (int j = i; ; j++) {
                    if (input.charAt(j) == '\n') {
                        break;
                    }
                    length++;
                }
                return length + maxDeep;
            }
            i--;
        }
        for (int j = 0; j < input.length(); j++) {
            if (input.charAt(j) == '\n') {
                break;
            }
            length++;
        }
        return length + maxDeep;
    }
}