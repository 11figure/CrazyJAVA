package Chapter5;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/8/27.
 */
public class RegexTest2 {
    public static void main(String[] args) {
        String regex = "<td (?:class=\\w*)>.*</td>";
        String ss = "<tr> <td class=red>sss</td> <td></td> </tr>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ss);
        System.out.println("捕获组数量：" + matcher.groupCount());
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}
