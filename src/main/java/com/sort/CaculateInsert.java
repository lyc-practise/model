package com.sort;

/**
 * 插入排序
 */

public class CaculateInsert implements CaculatePolicy{


    // 3 2 8 1 0
    @Override
    public int[] sort(int[] input) {

        for(int i = 1; i<input.length ;i++){
            int tmp = input[i];
            int j = i-1;
            while( j>=0 && input[j] > tmp ){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = tmp;
        }

        return input;
    }
}
