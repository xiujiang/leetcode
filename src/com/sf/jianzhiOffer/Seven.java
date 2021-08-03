package com.sf.jianzhiOffer;

import java.util.Stack;

public class Seven {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public static void main(String[] args) {

    }

    public void push(Integer a){
        s1.push(a);
    }

    public Integer pop(){
        if(s1.isEmpty() && s2.isEmpty()){
            return null;
        }
        if(s1.isEmpty()){
            return s2.pop();
        }
        if(s2.isEmpty()){
            while(s1.size()>1){
                s2.push(s1.pop());
            }
            return s1.pop();
        }
        return null;
    }

}
