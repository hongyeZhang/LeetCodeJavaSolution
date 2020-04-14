package com.zhq.MediumProblem;

import java.util.*;

/**
 * @program: LeetCodeTest
 * @description: 三数之和
 * @author: ZHQ
 * @create: 2019-05-25 19:30
 **/
public class Test15 {
    public static void main(String[] args) {

        int[] input = {-1, 0, 1, 2, -1, -4};
//        int[] input = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

        List<List<Integer>> ret = threeSum4(input);
        ret.forEach(item->{
            System.out.println(item);
        });


    }


    /**
     * @Description: 超出时间限制
     * @Param: [nums]
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int key = nums[i] + nums[j];
                if (map.containsKey(key)) {
                    map.get(key).add(Arrays.asList(i, j));
                } else {
                    List<List<Integer>> tempMatrix = new ArrayList<>();
                    tempMatrix.add(Arrays.asList(i, j));
                    map.put(key, tempMatrix);
                }
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            int target = 0 - nums[i];
            if (map.containsKey(target)) {
                List<List<Integer>> tempMatrix = map.get(target);
                for (List<Integer> list : tempMatrix) {
                    int first = list.get(0);
                    int second = list.get(1);
                    if (i != first && i != second) {
                        List<Integer> tempList = Arrays.asList(nums[first], nums[second], nums[i]);
                        Collections.sort(tempList);
                        if (!ret.contains(tempList)) {
                            ret.add(tempList);
                        }

                    }
                }
            }
        }

        return ret;
    }


    /**
     * @Description: 超出时间限制
     * @Param: [nums]
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                map.put(nums[i], tempList);
            }
        }

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int target = 0 - nums[i] - nums[j];
                if (map.containsKey(target)) {
                    List<Integer> indexList = map.get(target);
                    for (Integer index : indexList) {
                        if (index != i && index != j) {
                            List<Integer> tempList = new ArrayList<>();
                            tempList.addAll(Arrays.asList(nums[i], nums[j], nums[index]));
                            Collections.sort(tempList);
                            if (!ret.contains(tempList)) {
                                ret.add(tempList);
                            }
                        }
                    }
                }
            }
        }

        return ret;
    }

    /**
     * @Description: 超时
     * @Param: [nums]
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        int len = nums.length;
        if (len < 3) {
            return ret;
        }

        Arrays.sort(nums);
        if (nums[0] <= 0 && nums[len - 1] >= 0) {
            for (int i = 0; i < len - 2; ++i) {
                int second = i + 1;
                int third = len - 1;
                while (second < third) {
                    int sum = nums[i] + nums[second] + nums[third];
                    if (sum == 0) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[second], nums[third]);
                        if (!ret.contains(tempList)) {
                            ret.add(tempList);
                        }
                        ret.add(tempList);
                        --third;
                    } else if (sum > 0) {
                        --third;

                    } else {
                        ++second;
                    }
                }

            }
        }

        return ret;
    }

    /**
     * @Description: AC
     * @Param: [nums]
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @Author: ZHQ
     * @Date: 2019/5/25
     **/
    public static List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return res;
    }

}
