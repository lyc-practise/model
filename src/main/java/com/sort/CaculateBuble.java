package com.sort;

/**
 * 冒泡排序
 */
public class CaculateBuble  implements  CaculatePolicy{


    @Override
    public int[] sort(int[] input) {

        for (int i=0;i<input.length;i++){
            for(int j=i+1; j<input.length ;j++){
                if(input[j] < input[i]){
                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        return input;

    }

}
