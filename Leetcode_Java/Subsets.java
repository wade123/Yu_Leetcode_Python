import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        subsetsHelper(nums, 0, list);
        return result;
    }

    private void subsetsHelper(int[] nums, int index, List<Integer> list) {
        result.add(new ArrayList<Integer>(list));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(test.subsets(nums));
    }
}