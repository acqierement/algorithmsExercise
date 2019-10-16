package src.main.java.exercise.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion03 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, temp, res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                backtrack(nums, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

