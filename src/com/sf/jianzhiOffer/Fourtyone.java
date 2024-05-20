package com.sf.jianzhiOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 整数序列的查找
 */
public class Fourtyone {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,6,7,8,9,10,12,13,16,24,25,33,42};
        ArrayList number = findNumber(x, 25);
        System.out.println(number);
    }


    public static ArrayList<ArrayList<Integer>> findSum(int[] x,int s){
        if(x == null || x.length == 0){
            return list;
        }
        findS(x,s,new ArrayList(),0,0);
        return list;
    }

    public static void findS(int[] x,int s,ArrayList a,int count,int k){
        if(count == s){
            list.add(a);
            return;
        }
        if(count > s){
            return;
        }
        for(int i = k; i < x.length; i++){
            a.add(x[i]);
            count+=x[i];
            findS(x,s,a,count,i);
            a.remove(a.size()-1);
            count-=x[i];
        }
    }

    static int min = Integer.MAX_VALUE;
    static ArrayList t = new ArrayList();
    public static ArrayList findNumber(int[] x,int s){
        int min = -1;
        if(x==null){
            return null;
        }
        findNum(x,s,0,new ArrayList<>(),0);
        return t;
    }

    public static void findNum(int[] x,int s,int k,ArrayList<Integer> list,int count){
        if(count == s && list.size() == 2) {
            System.out.println("s:"+list.get(0)+"  "+list.get(1));
             if(t.isEmpty()){
                 t.add(list.get(0));
                 t.add(list.get(1));
                 min = list.get(0)*list.get(1);
             }else{
                 Integer num = list.get(0) * list.get(1);
                 if(num < min){
                     t.set(0,list.get(0));
                     t.set(1,list.get(1));
                 }
             }
             return;
        }else if(count > s){
            return;
        }else if(list.size() >= 2){
            return;
        }
        for(int i = k; i < x.length; i++){
            list.add(x[i]);
            count+=x[i];
            findNum(x,s,i+1,list,count);
            Iterator<Integer> iterator = list.iterator();
            System.out.print("[");
            while(iterator.hasNext()){
                System.out.print(iterator.next()+"  ");
            }
            System.out.println("]");
            list.remove(list.size()-1);
            count-=x[i];
        }

    }

}
