package Chapter4;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/31.
 */
public class Num2Rmb {
    //用数组存数字0~9的汉字
    private static String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    //存储单位
    private static String[] unitArr = {"十", "百", "千",""};


    private String[] divide(double num){
        //String numStr = (long) num + "";
        long zheng = (long)num;
        long twoDecim = (long)((num - zheng)*100);
        return new String[]{zheng + "", String.valueOf(twoDecim)};
    }

    private static String toHanstr(double num){
        String zhengStr = (long)num + "";
        String outStr = "";
        for (int i = 0; i < zhengStr.length(); i++) {
            for (int j = 0 ; j < unitArr.length; j++) {
                if((zhengStr.length()-1-i)% unitArr.length == j+1){
                    outStr += hanArr[Integer.valueOf(zhengStr.toCharArray()[i])] + unitArr[j];
                }
            }
        }
        return outStr;
    }


    public static void main(String[] args) {
        Num2Rmb nr = new Num2Rmb();
        //测试吧一个浮点数分解成整数部分和小数部分
        //System.out.println(toHanstr(151212.1));
        System.out.println(Arrays.toString("123432".toCharArray()));
    }
}
