package com.shang;

/**
 * Created by shang on 2018/4/9.
 */
public class BigNumAdd {

    public static void main(String[] args) {
        String sum = add("99", "2");
        System.out.println(sum);
    }

    /**
     * 字符串模拟两个大数相加
     * @param n1
     * @param n2
     * @return
     */
    public static String add(String n1,String n2){

        StringBuffer result = new StringBuffer();

        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int length1 = n1.length();
        int length2 = n2.length();
        //最大长度
        int maxLength = length1 >= length2 ? length1:length2;

        //是否越界
        boolean nOverFlow = false;
        //溢出数量
        int nTakeOver = 0;

        if(length1<length2){

            for (int i = length1; i < length2; i++) {
                n1 += "0";
            }
            
        }else if(length1 > length2){
            for (int i = length2; i < length1; i++) {

                n2 += "0";
            }
        }

        for (int i = 0; i <maxLength ; i++) {
            int nSum  = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + nTakeOver;

            if(nSum >=10){

                if(i == maxLength - 1){

                    nOverFlow = true;
                }
                nTakeOver = 1;

                result.append(nSum-10);

            }else{

                nTakeOver =0;
                result.append(nSum);
            }

        }

        if(nOverFlow){
            result.append(nTakeOver);
        }

        return result.reverse().toString();

    }

}
