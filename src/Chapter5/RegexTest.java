package Chapter5;

import java.io.BufferedReader;
import java.util.regex.Matcher; //模式类：用来表示一个编译过的正则表达式
import java.util.regex.Pattern; //匹配类：用模式匹配一个字符串所有表达的抽象结果

/**
 * 正则表达式
 * 正则的主要用法，4种方面的使用
 * 匹配，分割，替换，获取
 */
public class RegexTest {

    public static void main(String[] args) {
        String a = "\"a\":b';";
        boolean aa = a.matches("aa");
        BufferedReader in;
        Pattern pattern = Pattern.compile("\\w");
        String s = "ldjdkl";
        Matcher mt = pattern.matcher(s);
        while(mt.find()){
            String s0=mt.group();
            String s1 = mt.group(1);
            System.out.println(s0 + "||" +s1);
        }
        mt.reset("fucking");
        while (mt.find()) {
            System.out.println(mt.group());
        }

        Pattern p1 = Pattern.compile("f(.+?)i(.+?)h");
        //
    }

    /**/
    public void getMatch(String str, String regx) {
        System.out.println("正则表达式匹配"+str.matches(regx));
    }

    /*字符串的分割*/
    void getDivision(String str, String regx) {
        String [] dataString = str.split(regx);
        for (String s : dataString) {
            System.out.println("正则表达式风格++"+s);
        }
    }

    /**/
    public void getReplace(String str,String regx,String replaceStr) {
        String stri = str.replaceAll(regx,replaceStr);
        System.out.println("正则表达式替换"+stri);
    }
}