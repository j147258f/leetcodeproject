package com.zh.leetcode.competition;

import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {
    Map<String, String> cache = new HashMap<>();

    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        for (int i = words.length - 1; i > 0; i--) {
            String iReCode = getReCodeFromCache(words[i]);
            String iSub1ReCode = getReCodeFromCache(words[i - 1]);

            if(!iReCode.equals(iSub1ReCode)){

                list.add(words[i]);
            }
        }
        list.add(words[0]);
        List<String> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    private String getReCodeFromCache(String word) {
        String reCode = cache.get(word);
        if (reCode == null) {
            char[] cs = word.toCharArray();
            Arrays.sort(cs);
            reCode = new String(cs);
            cache.put(word, reCode);
        }

        return reCode;
    }
}
