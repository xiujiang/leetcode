package com.sf.jingdian;

import java.util.ArrayList;
import java.util.List;

public class pro57 {
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] b = {-1,1};
        int[][] c = insert(a,b);
        for (int[] ints : c) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        for(;i < intervals.length; i++){
            list.add(intervals[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
