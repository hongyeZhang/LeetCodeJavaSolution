package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author : ZHQ
 * @date : 2020/4/26
 */
public class Test767_2 {


    static class Element {
        Character character;

        int count;

        public Element(Character character, int count) {
            this.character = character;
            this.count = count;
        }
    }


    /**
     * 记录每个字母在字符串中的数量（哈希表） 根据字母数量降序排序（插入优先队列，以字母数量较大优先级较高，类似于大顶堆） 若队列顶部字母的数量大于一半则无法构造，直接返回空字符串（奇偶有别）
     * 按照字母数量降序顺序，当队列不空时，依次按照对顶元素，隔着往原字符串插入当前字符，下标从 0 开始，每次插入下标 +2，当超过数组大小时，变为 1。
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (null == S || S.length() == 0) {
            return "";
        } else if (S.length() == 1) {
            return S;
        }

        char[] chars = S.toCharArray();
        int len = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.count - o1.count;
            }
        };

        PriorityQueue<Element> maxHeap = new PriorityQueue<>(comparator);
        map.forEach((key,value)->{
            maxHeap.offer(new Element(key, value));
        });

        // 如果最大值大于字符串长度的一般，直接返回
        int threshold = (int) Math.ceil(len / 2.0);
        Element maxElement = maxHeap.peek();
        if (maxElement.count > threshold) {
            return "";
        }

        char[] result = new char[len];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Element poll = maxHeap.poll();
            while (poll.count > 0) {
                if (index >= len) {
                    index = 1;
                }
                result[index] = poll.character;
                poll.count -= 1;
                index += 2;
            }
        }

        return new String(result);
    }

    @Test
    public void test() {
//        String input = "aab";
        String input = "aaab";
        System.out.println(reorganizeString(input));

    }

}
