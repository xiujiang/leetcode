package com.sf.code.producerAndConsumer;

import java.util.UUID;

public class test1 {
    public static void main(String[] args) {
        String s = "INSERT INTO `game_sdk`.`game_user_info` (`user_name`, `display_name`, `user_pwd`,`user_regdate`, `user_mstatus`,`user_mobilenum`,`user_type`,`user_enable`) VALUES ('%s', '%s', '%s','2023-11-23 19:00:00', 0,'', 3, 1); ";


        for(int i = 0; i < 100; i++){
            String s1 = UUID.randomUUID().toString();
            String[] split = s1.split("-");
            String format = String.format(s, split[4], split[4], "123456");
            System.out.println(format);
        }

    }

}
