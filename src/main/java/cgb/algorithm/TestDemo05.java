package cgb.algorithm;

import java.util.Arrays;

public class TestDemo05 {
    public static void main(String[] args) {
        // 选择排序调用
        int[] selectNums = {18, 1, 6, 27, 15};
        System.out.println("排序前：" + Arrays.toString(selectNums));
        selectSort(selectNums);
        System.out.println("排序后：" + Arrays.toString(selectNums));
    }
    /**
     * 选择排序
     */
    private static void selectSort(int[] nums) {
        int index;
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            System.out.print("第" + i + "次排序：");
            System.out.println(Arrays.toString(nums));
        }
    }
}
