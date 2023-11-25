package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Brute force solution
    public int[] twoSumBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]) return new int[]{i, j};

            }
        }
        return new int[]{};
    }

    //Hashmap solution
    public int[] twoSumMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey((target - nums[i])) && map.get(target - nums[i]) != i){
                return new int[]{map.get(target - nums[i]), i};
            }
        }

        return new int[]{};
    }




}


