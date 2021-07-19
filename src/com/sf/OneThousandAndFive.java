package com.sf;

import java.util.Arrays;
import java.util.Comparator;

public class OneThousandAndFive {
    public static void main(String[] args) {
        int[] s = new int[]{2,3,1,1,-4,3,1,1,5,2,1,3,6,7,1};
        Arrays.sort(s);
        for (int i : s) {
            System.out.println(i);
        }
        System.out.println(largestSumAfterKNegations(s,3));
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        int[] x = new int[A.length];
        Arrays.sort(new int[][]{A}, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1>(Integer)o2?1:-1;
            }
        });
        int count = 0;
        for(int i = 0; i < A.length; i++){
            int s = A[i];
            if(K>0 && A[i] < 0){
                K--;
                s = -s;
            }else if(K > 0 && A[i] > 0){
                s = -A[0];
                K--;
            }
            System.out.print(s);
            count+=s;
        }
        return count;
    }
}
