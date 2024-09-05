package com.wangzhu.springboot.sort;

import java.util.Arrays;

/**
 * Created by wangz on 2024/9/5 14:29.
 **/
public class MergeSort implements Sortable{

    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        final int len = nums.length;
        final int mid = len >> 1;

        final int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        final int[] leftArr = sort(leftNums);
        final int[] rightNums = Arrays.copyOfRange(nums, mid, len);
        final int[] rightArr = sort(rightNums);
        return merge(leftArr, rightArr);
    }

    int[] merge(int[] leftArr, int[] rightArr) {
        final int leftLen = leftArr.length;
        final int rightLen = rightArr.length;
        final int len = leftLen + rightLen;
        final int[] nums = new int[len];

        int left = 0, right = 0, index = 0;
        while (left < leftLen && right < rightLen) {
            if (leftArr[left] < rightArr[right]) {
                nums[index] = leftArr[left];
                left++;
                index++;
            } else {
                nums[index] = rightArr[right];
                right++;
                index++;
            }
        }
        while (left < leftLen) {
            nums[index] = leftArr[left];
            left++;
            index++;
        }
        while (right < rightLen) {
            nums[index] = rightArr[right];
            right++;
            index++;
        }
        return nums;
    }
}
