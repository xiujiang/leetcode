package com.sf.jingdian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro452 {
    public static void main(String[] args) {
        int[][] arr = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(arr));
    }
    public static int findMinArrowShots(int[][] points) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(points,(int[] a,int [] b)->{
            return a[0] - b[0];
        });
        for (int[] ints : points) {
            System.out.print(ints[0]+" "+ints[1]+"   ");
        }
        i:for(int i = 0; i < points.length; i++){
            for (int[] ints : list) {
                if((points[i][0] >= ints[0] && points[i][0] <= ints[1]) || (points[i][1] >= ints[0] && points[i][1] <= ints[1])
                    || (ints[0] >= points[i][0] && ints[0] <= points[i][1]) || (ints[1] >= points[i][0] && ints[1] <= points[i][1])
                ){
                    ints[0] = Math.max(points[i][0],ints[0]);
                    ints[1] = Math.min(points[i][1],ints[1]);
                    continue i;
                }
            }
            list.add(points[i]);
        }
        for (int[] ints : list) {
            System.out.println(ints[0]+" "+ints[1]);
        }
        return list.size();
    }
}
