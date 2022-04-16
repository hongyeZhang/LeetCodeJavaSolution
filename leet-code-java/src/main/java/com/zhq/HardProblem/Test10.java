package com.zhq.HardProblem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCodeTest
 * @description: 正则表达式匹配
 * @author: ZHQ
 * @create: 2019-05-25 17:47
 **/
public class Test10 {

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    /**
     * dp(s,i,p,j) = true，代表 s[i...] 可以匹配 p[j...]。
     * dp(s,i,p,j) = false， 则代表不能匹配
     * @param sArr
     * @param i
     * @param pArr
     * @param j
     * @return
     */
    public boolean dp(char[] sArr, int i, char[] pArr, int j) {
        int m = sArr.length;
        int n = pArr.length;

        // base case
        if (j == n) {
            // j == p.size()时，按照dp函数的定义，这意味着模式串p已经被匹配完了，
            // 那么应该看看文本串s匹配到哪里了，如果s也恰好被匹配完，则说明匹配成功
            return i == m;
        }
        if (i == m) {
            // 此时并不能根据j是否等于p.size()来判断是否完成匹配，只要p[j..]能够匹配空串，
            // 就可以算完成匹配。比如说s = "a", p = "ab*c*"，当i走到s末尾的时候，j并没有走到p的末尾，但是p依然可以匹配s。
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j += 2) {
                if (pArr[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }

        // 备忘录，消除重叠子问题
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (sArr[i] == pArr[j] || pArr[j] == '.') {
            // 匹配
            if (j < n - 1 && pArr[j + 1] == '*') {
                // 1.1 通配符匹配 0 次或多次
                res = dp(sArr, i, pArr, j + 2)
                        || dp(sArr, i + 1, pArr, j);
            } else {
                // 1.2 常规匹配 1 次
                res = dp(sArr, i + 1, pArr, j + 1);
            }
        } else {
            // 不匹配
            if (j < n - 1 && pArr[j + 1] == '*') {
                // 2.1 通配符匹配 0 次
                res = dp(sArr, i, pArr, j + 2);
            } else {
                // 2.2 无法继续匹配
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo.put(key, res);
        return res;
    }

    @Test
    public void test() {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }


}
