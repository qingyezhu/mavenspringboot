package com.wangzhu.springboot.sort;

import java.util.Random;

/**
 * Created by wangz on 2024/9/5 14:29.
 **/
public class QuickSort implements Sortable {

    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = randomPartition(nums, left, right);
        int tmpRight = index - 1;
        while(left < tmpRight && nums[tmpRight] == nums[index]){
            tmpRight --;
        }
        sort(nums, left, tmpRight);

        int tmpLeft = index + 1;
        while(tmpLeft < right && nums[tmpLeft] == nums[index]){
            tmpLeft ++;
        }
        sort(nums, tmpLeft, right);
    }

    int randomPartition(int[] nums, int left, int right) {
        int index = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, index);
        return partition(nums, left, right);
    }

    int partition(int[] nums, int left, int right) {
        int index = left;
        while (left < right) {
            while (left < right && nums[right] >= nums[index]) {
                right--;
            }

            while (left < right && nums[left] <= nums[index]) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, index, left);
        return left;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
