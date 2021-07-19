package com.sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 *  
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *  
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * [["JFK","ATL"],["ORD","PHL"],["JFK","ORD"],["PHX","LAX"],["LAX","JFK"],["PHL","ATL"],["ATL","PHX"]]
 *
 * 输出：
 * ["JFK","ORD","PHL","ATL","PHX","LAX","JFK","ATL"]
 * stdout
 * {PHXLAX=0, ORDPHL=0, LAXJFK=0, JFKORD=0, PHLATL=0, ATLPHX=0, JFKATL=0}
 *
 * 预期结果：
 * ["JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"]
 *
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]
 * stdout
 * {ATLJFK=0, JFKSFO=0, SFOATL=0, ATLSFO=0, JFKATL=0}
 * A  S
 * T  F
 * A  S
 * T  F
 * J  A
 * J  A
 * S  A
 * S  J
 *
 * 预期结果：
 * ["JFK","ATL","JFK","SFO","ATL","SFO"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeHandredThirtyTwo {
    static List<String> b = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> t = new ArrayList<>();
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = new ArrayList<>();
        List<String> s4 = new ArrayList<>();
        List<String> s5 = new ArrayList<>();
        List<String> s6 = new ArrayList<>();
        List<String> s7 = new ArrayList<>();
        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        s1.add("JFK");
        s1.add("SFO");
        s2.add("JFK");
        s2.add("ATL");
        s3.add("SFO");
        s3.add("ATL");
        s4.add("ATL");
        s4.add("JFK");
        s5.add("ATL");
        s5.add("SFO");
//        s6.add("PHL");
//        s6.add("ATL");
//        s7.add("ATL");
//        s7.add("PHX");
        t.add(s1);
        t.add(s2);
        t.add(s3);
        t.add(s4);
        t.add(s5);
//        t.add(s6);
//        t.add(s7);
        System.out.println(findItinerary(t));
    }

    public static List<String> findItinerary(List<List<String>> tickets){
        b.clear();
        b.add("JFK");
        Map<String,Integer> maps = new HashMap<>();
        for(List<String> ticket:tickets){
            Integer count = maps.get(ticket.get(0) + ticket.get(1));
            maps.put(ticket.get(0)+ticket.get(1),count == null?0:++count);
        }
        System.out.println(maps);
        //[[JFK, SFO], [SFO, ATL], [JFK, ATL], [ATL, SFO], [ATL, JFK]]
        //[[ATL, JFK], [ATL, SFO], [JFK, ATL], [SFO, ATL], [JFK, SFO]]
        tickets = tickets.stream().sorted((o1,o2)->check(o1.get(1),o2.get(1))
        ).collect(Collectors.toList());
        System.out.println(tickets);
        backTracking(tickets,maps);
        return b;
    }
    public static boolean backTracking(List<List<String>> tickets,Map<String,Integer> maps){
        if(b.size() == tickets.size()+1){
            return true;
        }
        for(int i = 0; i < tickets.size(); i++){
            List<String> list = tickets.get(i);
            if(!b.get(b.size()-1).equals(list.get(0))){
                continue;
            }
            if(maps.get(list.get(0)+list.get(1))>= 0){
                b.add(list.get(1));
                maps.put(list.get(0)+list.get(1),maps.get(list.get(0)+list.get(1))-1);
                if(backTracking(tickets,maps)) {
                    return true;
                }
                maps.put(list.get(0)+list.get(1),maps.get(list.get(0)+list.get(1))+1);
                b.remove(b.size()-1);
            }
        }
        return false;
    }
    public static int check(String a1,String a2){
        for(int i = 0; i < a1.length(); i++){
            if(a1.charAt(i) == a2.charAt(i)){
                continue;
            }
            System.out.println(a1.charAt(i)+"  "+a2.charAt(i));
            if(a1.charAt(i) > a2.charAt(i)){
                return 1;
            }else{
                return -1;
            }
        }
        return 0;
    }
}
