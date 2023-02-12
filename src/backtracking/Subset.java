import java.util.*;

public class Subset {

    // public static void solve(int index, int[] nums, List<Integer> subset, List<List<Integer>> powerSet) {

    //     if(index == nums.length) {
    //         powerSet.add(new ArrayList<>(subset));
    //         return;
    //     }

    //     // include
    //     subset.add(nums[index]);
    //     solve(index + 1, nums, subset, powerSet);   
    //     subset.remove(subset.size() - 1);  

    //     // exclude
    //     while(index < (nums.length - 1) && nums[index] == nums[index + 1]) {
    //         index += 1;
    //     }
    //     solve(index + 1, nums, subset, powerSet); 
    // }
    
    public static void solve(int index, int[] nums, List<Integer> subset, List<List<Integer>> powerSet) {
        powerSet.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            solve(i + 1, nums, subset, powerSet);
            subset.remove(subset.size() - 1);
        }
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, subset, powerSet);
        return powerSet;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> ans = Subset.subsets(nums);
        System.out.println(ans);
    }
    
}
