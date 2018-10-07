package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dsf {
		public static void main(String[] args) {
		int[] arr =	{2,3,6,7};
		List<List<List<Integer>>> combinationSum = combinationSum(arr, 7);
		List<List<Integer>> list = combinationSum.get(0);
		System.out.println(combinationSum);
		}
		//[[], [[2]], [[3]], [[2, 2]], [[2, 3], [3, 2]], [[2, 2, 2], [3, 3], [6]], [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]]
		//[[], [[2]], [[3]], [[2, 2]], [[2, 3]], [[2, 2, 2], [3, 3], [6]], [[2, 2, 3], [7]]]

	    public static List<List<List<Integer>>> combinationSum(int[] cands, int t) {
	        Arrays.sort(cands); // sort candidates to try them in asc order
	        List<List<List<Integer>>> dp = new ArrayList<>();
	        
	        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
	            List<List<Integer>> newList = new ArrayList(); // combs for curr i
	            // run through all candidates <= i
	            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
	                // special case when curr target is equal to curr candidate
	                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
	                // if current candidate is less than the target use prev results
	                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
	                    if (cands[j] <= l.get(0)) {
	                        List cl = new ArrayList<>();
	                        cl.add(cands[j]); cl.addAll(l);
	                        newList.add(cl);
	                    }
	                }
	            }
	            dp.add(newList);
	        }
	        return dp;
	    }
	

}
