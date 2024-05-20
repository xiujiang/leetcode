package com.sf.jingdian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro56 {
    public static void main(String[] args) {
        int[][] a = {{1,3},{12,16},{2,6},{8,10},{15,18}};

        Arrays.sort(a,(int[] x,int[] y)->{
            return x[0] - y[0];
        });
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        int start = -1;
        int end = -1;
        int k = 0;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(int[] x,int[] y)->{
            return x[0] - y[0];
        });

        for(int i = 0; i < intervals.length; i++){
            start = intervals[i][0];
            end = intervals[i][1];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < start){
                list.add(new int[]{start,end});
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],end);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
