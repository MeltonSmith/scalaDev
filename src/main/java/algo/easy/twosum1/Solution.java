package r.ian.algo.easy.twosum1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melton Smith
 * @since 06.06.2025
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};

            map.put(nums[i], i);
        }
        return new int[2];
    }
}
