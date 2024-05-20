package com.sf.paixu;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[]{1,3,61,2,4,6};
//        int[] ints = shellSort(x);
//        heapSort(x);
        for (int anInt : x) {
            System.out.println(anInt);
        }
    }

    static int[] bubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    static int[] selectionSort(int[] nums){
        int len = nums.length;
        int minIndex = 0;
        int temp = 0;
        for(int i = 0; i < len-1; i++){
            minIndex = i;
            for(int j = i+1; j < len; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    static int[] insertSort(int[] nums){
        int len = nums.length;
        int preIndex,current;
        for(int i = 1; i < len; i++){
            preIndex = i-1;
            current = nums[i];
            while(preIndex >= 0 && nums[preIndex] > current){
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
        return nums;
    }

    static int[] shellSort(int[] nums){
        int len = nums.length;
        for(int gap = len/2; gap > 0; gap = gap/2){
            for(int i = gap; i < len; i++){
                int j = i;
                int current = nums[i];
                while(j - gap >= 0 && current < nums[j - gap]){
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }
        return nums;
    }



    static void sort(int[] nums){
        int[] x = new int[nums.length];
        sort(nums,0,nums.length-1,x);
    }

    static void sort(int[] nums,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right) /2;
            sort(nums,left,mid,temp);
            sort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }
    static void merge(int[] nums,int left ,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[t++] = nums[i++];
        }
        while(j <= right){
            temp[t++] = nums[j++];
        }
        t = 0;
        while(left <= right){
            nums[left++] = temp[t++];
        }
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


    public static void quickSort(int[] num,int low,int high){
        if(low < high){
            int index = getIndex(num,low,high);
            quickSort(num, low, index - 1);
            quickSort(num, index + 1, high);
        }

    }

    public static int getIndex(int[] num,int low,int high){
        // 基准数据
        int tmp = num[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && num[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            num[low] = num[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && num[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            num[high] = num[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        num[low] = tmp;
        return low; // 返回tmp的正确位置
    }


}
