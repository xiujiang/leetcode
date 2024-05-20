package com.sf.jingdian;

public class pro45 {

    public static void main(String[] args) {
        int[] nums = {4,1,1,3,1,1,1};
        // 1, 2 ,1 ,1 ,3
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int jumpCount = 0;
        int jumpStep = nums[0];
        if(nums.length == 1){
            return 0;
        }
        boolean canFinish = jumpStep >= nums.length - 1;
        for(int i = 0; i < nums.length;){
            jumpStep = nums[i];
            jumpCount++;
            canFinish = jumpStep >= nums.length -i - 1;
            if (canFinish) {
                return jumpCount;
            }
            int tmpIndex = 0;
            int maxStep = 0;
            for(int j = i+1; j <= i + jumpStep; j++){
                int tmp = (j - (i+1));
                if(maxStep < (nums[j] + tmp)){
                    tmpIndex = j;
                    maxStep = nums[j] + tmp;
                }
            }
            i = tmpIndex;
            System.out.println("aa"+i);
        }
        return jumpCount;
    }
}
