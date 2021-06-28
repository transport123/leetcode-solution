package leetcode;

import Execute.MyRunnable;

import java.util.HashMap;
import java.util.Map;

public class TowSum01 implements MyRunnable {
    @Override
    public void run() {
        int[] result = twoSumV3(new int[]{2, 3, 4, 5, 5}, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{0, 1};
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> searchMap = new HashMap<>();
        int gap = 0;
        for (int i = 0; i < nums.length; i++) {
            searchMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            gap = target - nums[i];
            if (searchMap.containsKey(gap)) {
                int key2 = searchMap.get(gap);
                if (key2 == i)
                    continue;
                return new int[]{i, key2};
            }
        }

        return new int[]{0, 1};
    }


    public int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> searchMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (searchMap.containsKey(target - nums[i]))
                return new int[]{i, searchMap.get(target - nums[i])};
            searchMap.put(nums[i], i);
        }
        return new int[]{0, 1};
    }
}
