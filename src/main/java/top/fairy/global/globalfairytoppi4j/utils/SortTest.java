package top.fairy.global.globalfairytoppi4j.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2021/5/20 19:55
 */
public class SortTest {

    public static void main(String[] args) {
        SortTest sortTest = new SortTest();
        String[] words = {"aa","bb","ac","bb","bc","ac","aa","aa","aa","aa","ad","ae","ae","af","af","af","at","at","at","at","at","at","at","at"};
        System.out.println(sortTest.topKFrequent(words,5));

    }


    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.keySet();
        hashMap.containsKey("a");
        for (int i = 0; i < words.length; i++) {
            if (hashMap.get(words[i]) != null) {
                hashMap.put(words[i], hashMap.get(words[i]) + 1);
            } else {
                hashMap.put(words[i], 1);
            }

        }

//


        // 2.用 list 存储字符 key 然后自定义 Comparator 比较器对 value 进行排序。
        List<String> candidates = new ArrayList<>(hashMap.keySet());


        // 此处为使用 lambda 写法
        candidates.sort((a, b) -> {
            // 字符串频率相等按照字典序比较使得大的在堆顶,Java 可以直接使用 compareTo 方法即可。
            if (hashMap.get(a).equals(hashMap.get(b))) {
                return a.compareTo(b);
            } else {
                // 字符串频率不等则按照频率排列。
                return hashMap.get(b) - hashMap.get(a);
            }
        });

        return candidates.subList(0, k);
    }

}