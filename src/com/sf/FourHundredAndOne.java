package com.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *                x x x 1           时
 *              x 1 1 x x 1         分
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourHundredAndOne {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch1(1));
        System.out.println(readBinaryWatch(1));
    }
    public static List<String> readBinaryWatch1(int num) {
        List<String> str = new ArrayList<>();
        int[] nums = new int[]{8,4,2,1,32,16,8,4,2,1};

        flashBlack(num,nums,0,0,0,str);
        return str;
    }

    public static void flashBlack(int num,int[]nums,int index,int hour,int minute,List<String> str){
        if(num == 0){
            if(hour > 11 || minute > 59){
                return;
            }
            str.add(hour+":"+(minute<10?"0"+minute:minute));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i < 4){
                hour+=nums[i];
            }else{
                minute+=nums[i];
            }
            flashBlack(num-1,nums,i+1,hour,minute,str);
            if(i < 4){
                hour-=nums[i];
            }else{
                minute-=nums[i];
            }
        }
    }



    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        //判断输入
        if (num < 0){
            return result;
        }
        //LED灯，前四个为小时，后六个为分钟
        int[] nums = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        backTrack(num, nums, 0, 0, 0,result);
        return result;
    }

    public static void backTrack(int num, int[] nums, int start, int hour, int minute,List<String> result) {
        if (num == 0) {
            //判断时间是否正确
            if (hour > 11 || minute > 59) {
                return;
            }
            StringBuilder tmp = new StringBuilder();
            //小时
            tmp.append(hour);
            tmp.append(":");
            //分钟
            if (minute < 10) {
                tmp.append(0);
            }
            tmp.append(minute);
            result.add(new String(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            /*回溯做选择*/
            //判断是小时还是分钟
            if (i < 4)//小时
            {
                hour += nums[i];
            } else {
                minute += nums[i];
            }
            //递归
            backTrack(num - 1, nums, i + 1, hour, minute,result);
            /*回溯取消选择*/
            if (i < 4)//小时
                hour -= nums[i];
            else
                minute -= nums[i];
        }
    }
}
