package com.sf.jianzhiOffer;

/**
 * 找出最小的 K 个数
 */
public class Thirty {
    public static void main(String[] args) {
        int[] x = new int[]{3,5,1,2,11,44,23,21};
        findK(x,3);
//        for(int i = x.length-1; i >0; i--){
//            int temp = x[0];
//            x[0] = x[i];
//            x[i] = temp;
//            adjustHeap(x,0,i);
//        }
        for (int i : x) {
            System.out.print(i+"  ");
        }
    }

    public static int[] findK(int[] nums,int k){
        int[] x = new int[k];
        for(int i = 0; i < k; i++){
            x[i] = nums[i];
        }
        adjustHeap(x);
        for(int i = k; i < nums.length; i++){
            if(x[0] > nums[i]){
                x[0] = nums[i];
                adjustHeap(x);
            }
            System.out.println("zz"+i);
        }
        return x;
    }

    public static void adjustHeap(int[] nums){
        for(int i = nums.length/2-1; i >=0; i--){
            int temp = nums[i];
            int j = i*2+1;
            int k = i*2+2;

            if(j < nums.length && k < nums.length) {
                if (nums[j] < nums[k]) {
                    j = k;
                }
            }
            if(nums[j] > temp){
                nums[i] = nums[j];
                nums[j] = temp;
            }
            System.out.print("第"+i);
            for (int n : nums) {
                System.out.print(n+"  ");
            }
            System.out.println();
        }
    }
    static void adjustHeap(int[] arr,int i,int len){
        int temp = arr[i];
        for(int k = i*2+1; k < len; k = k*2+1){
            if(k+1 < len && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }

    static void heapSort(int[] arr){
        for(int i = arr.length/2-1; i >=0; i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int i = arr.length-1; i >0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr,0,i);
        }
    }




}
