package com.wangzhu.springboot.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by wangz on 2024/9/5 14:44.
 **/
public class SortTest {

    @Test
    public void quickSort() {
        QuickSort quickSort = new QuickSort();
        sort(quickSort);
    }

    @Test
    public void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        sort(mergeSort);
    }

    void sort(Sortable sortable) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(sortable, nums);

        nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(sortable, nums);

        nums = new int[]{4, 3, 8, 7, 1, 9, 5, 6, 2};
        sort(sortable, nums);

        nums = new int[]{5, 3, 2, 1, 4, 3, 3, 7, 1, 9, 5, 8, 5, 6, 2};
        sort(sortable, nums);

    }

    void sort(Sortable sortable, int[] nums) {
        int[] res = sortable.sort(nums);
        System.out.println(Arrays.toString(res));
    }
}
