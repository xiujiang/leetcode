package com.sf.jianzhiOffer;

/**
 * 三、
 * 在一个二维有序数组中找到对应值
 */
public class Three {
    public static void main(String[] args) {
        int n = 5;
        int[][] num = new int[n][n];
        int count = 1;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = count++;
                System.out.print(num[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(find2(num,6));
    }

    private static boolean find(int[][] nums,int k){
        int i = 0;
        int j = 0;
        if(nums == null && nums.length <=0){
            return false;
        }
        if(nums[i][j] > k){
            return false;
        }
        while (i < nums.length-1){
            if(nums[i][0] < k){
                i++;
            }else if(nums[i][0] == k){
                return true;
            }
        }
        while(j < nums[0].length){
            if(nums[i][j] < k){
                j++;
            }else if(nums[i][j] == k){
                return true;
            }
        }
        return false;
    }

    private static boolean find2(int[][] nums,int k){
        if(nums == null && nums.length <=0){
            return false;
        }
        if(nums[0][0] > k){
            return false;
        }
        int left = 0;
        int right = nums.length * nums[0].length-1;
        int col = nums[0].length;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid/col][mid % col] == k){
                return true;
            }else if(nums[mid/col][mid % col] < k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
