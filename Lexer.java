import java.util.Scanner;
import java.util.regex.*;
public class Lexer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String output = "ERR";
        Pattern p = Pattern.compile("^0"); //0
        Pattern p2 = Pattern.compile("^[1-9][0-9]*"); //10進数整数
        Pattern p3 = Pattern.compile("^0[xX][0-9a-fA-F]+"); //16進数
        Pattern p4 = Pattern.compile("^[0-9]*[a-fA-F][0-9a-fA-F]*"); //0xなし16進数
        Pattern p5 = Pattern.compile("^[1-9][0-9]*\\.[0-9]*"); //小数(任意)
        Pattern p6 = Pattern.compile("^0\\.[0-9]*"); //小数(0.任意)
        Pattern p7 = Pattern.compile("^\\.[0-9]+"); //小数(.任意)
        Matcher match = p.matcher(input);
        if(match.find()) {
            output = "INT" + match.group();
        }

        match = p2.matcher(input);
        if(match.find()) {
            output = "INT" + match.group();
        }

        match = p3.matcher(input);
        if(match.find()) {
            output = "INT" + match.group();
        }

        match = p4.matcher(input);
        if(match.find()) {
            output = "INT" + match.group();
        }

        match = p5.matcher(input);
        if(match.find()) {
            output = "DEC" + match.group();
        }

        match = p6.matcher(input);
        if(match.find()) {
            output = "DEC" + match.group();
        }

        match = p7.matcher(input);
        if(match.find()) {
            output = "DEC" + match.group();
        }

        System.out.println(output);
    }
}
