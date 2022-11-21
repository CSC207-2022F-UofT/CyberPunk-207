import java.util.Scanner;

public class IO {
    private static final Scanner scan = new Scanner(System.in);

    public static int input(){
        String ans = "";
        ans = scan.next();
        return Integer.parseInt(ans);
    }

    public static void output(String output){
        System.out.println(output);
    }

}
