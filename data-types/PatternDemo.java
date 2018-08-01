import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {
        String url = "demo.com/users.php?name=zhangsan";
        Pattern pattern = Pattern.compile("(\\.(\\w+?))\\?");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            // group() 即 group(0)，总是返回整个正则表达式命中的结果，这里返回 .php?
            System.out.println(matcher.group());
            // () 中的即为分组，这里返回 .php
            System.out.println(matcher.group(1));
        }
    }
}
