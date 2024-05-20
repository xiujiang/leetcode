package com.sf.jianzhiOffer;

/**
 * 将数组中的奇数放在偶数前
 */
public class Fourteen {
    public static void main(String[] args) {
        int[] x = new int[]{3,2,1,3,5,7,34,6,13,63};
        revertArray(x);
    }
    private static void revertArray(int[] arr){
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            while(left < right && arr[left] %2 == 1){
                left++;
            }

            while(left < right && arr[right] %2 == 0){
                right--;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
