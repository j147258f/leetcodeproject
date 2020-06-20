package com.zh.leetcode;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。.
 */
//复杂度 O(2n平方)  可以简化成n平方  代码稍微复杂  先不优化
public class LongestPalindromicSubstring {

    public static void main(String[] args){

        System.out.println(longestPalindrome("ccc"));
    }

    public static String longestPalindrome(String s) {
        if(s.isEmpty())return s;
        char[] chars = s.toCharArray();
        int longestStep=0;
        int longestStepIndex = 0;

        //对称轴在中箭 baab
        for (int i = 0; i < chars.length; i++) {
            int step = 1;
            while (i-step+1 >= 0 && i + step  < chars.length) {
                if (chars[i-step+1] == chars[i + step]) {
                    if(step>longestStep){
                        longestStep = step;
                        longestStepIndex = i;
                    }
                } else {
                    break;
                }
                step++;
            }
        }

        int longestStep2=0;
        int longestStepIndex2 = 0;
        //处理对称轴在字母上  aba
        for (int i = 0; i < chars.length; i++) {
            int step = 1;
            while (i-step >= 0 && i + step  < chars.length) {
                if (chars[i-step] == chars[i + step]) {
                    if(step>longestStep2){
                        longestStep2 = step;
                        longestStepIndex2 = i;
                    }
                } else {
                    break;
                }
                step++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(longestStep > longestStep2){
            for(int i =longestStepIndex-longestStep+1;i<=longestStepIndex + longestStep;i++){
                sb.append(chars[i]);
            }
        }else{
            for(int i =longestStepIndex2-longestStep2;i<=longestStepIndex2 + longestStep2;i++){
                sb.append(chars[i]);
            }
        }


        return sb.toString();
    }

}
