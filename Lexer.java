import java.util.Scanner;
import java.util.regex.*;
public class Lexer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String output = "ERR";
        Pattern p = Pattern.compile("^[0-9a-f]+");
        Pattern p2 = Pattern.compile("^[0-9A-F]+");
        Pattern p3 = Pattern.compile("^0x[0-9a-f]+");
        Pattern p4 = Pattern.compile("0X[0-9A-F]+");
        Pattern p5 = Pattern.compile("(0|[1-9][0-9]*)(\\.[0-9]*)");
        Pattern p6 = Pattern.compile("^\\.[0-9]*");
        Matcher match = p.matcher(input);
        if(match.find()) {
            output = "INT" + match.group(); //10進数か16進数(小文字)の1文字以上
        }

        match = p2.matcher(input);
        if(match.find() && match.group().length() > output.length()) {
            output = "INT" + match.group(); //10進数か16進数(大文字)の1文字以上
        }

        match = p3.matcher(input);
        if(match.find()) {
            output = "INT" + match.group(); //16進数0x開始(小文字)
        }

        match = p4.matcher(input);
        if(match.find()) {
            output = "INT" + match.group(); //16進数0X開始(大文字)
        }

        match = p5.matcher(input);
        if(match.find()) {
            output = "DEC" + match.group(); //小数点を含む場合
        }

        match = p6.matcher(input);
        if(match.find()) {
            output = "DEC" + match.group(); //整数自由
        }

        System.out.println(output);
    }
}
