package com.sf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class OneHandredFiftyFive {
    public static void main(String[] args) {
        OneHandredFiftyFive minStack = new OneHandredFiftyFive();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
        System.out.println(minStack.getMin());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    List<Integer> list = null;
    Integer top;
    Integer min;
    /** initialize your data structure here. */
    public OneHandredFiftyFive() {
        list = new ArrayList();
        top = null;
        min = null;
    }

    public void push(int val) {
        list.add(val);
        if(top == null){
            top = val;
        }
        if(min == null){
            min = val;
        }
        top = val;
        if(min > val){
            min = val;
        }
    }

    public void pop() {
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        if(list.size()> 0){
            top = list.get(list.size()-1);
            if(min == val){
                min = null;
                for(int i = 0; i < list.size(); i++){
                    if(min == null){
                        min = list.get(i);
                    }
                    if(list.get(i) < min){
                        min = list.get(i);
                    }

                }
            }
        }else{
            min = null;
            top = null;
        }

    }
    public int top() {
        return top;
    }

    public int getMin() {
        return min;
    }
}
