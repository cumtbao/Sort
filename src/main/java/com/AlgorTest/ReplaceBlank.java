package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 * 实现一个函数，把字符串中的每个空格替换成%20
 *
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String s = "I am very happy";

        System.out.println(replaceBlank(s));
    }


    public static String replaceBlank(String input){

        if(input==null){
            return null;
        }

        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)== ' '){
                sb.append("%20");
            }else{
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

}
