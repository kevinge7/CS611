import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//take all the input from this class
public class InputValidator {
    ArrayList<String> inputScope = new ArrayList<String>();
//get an int input without boundary
    public int getInt() {
        while(true) {
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
            Toolkit.getDefaultToolkit().beep();

            try{
                int num=Integer.parseInt(s);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
            }
        }
    }
// get a int input with a boundary
    public int getInt(int range) {
        Scanner sc=new Scanner(System.in);
        while(true) {

            String s=sc.next();
            Toolkit.getDefaultToolkit().beep();

            try{
                int num=Integer.parseInt(s);
                if(num > range || num <= 0){
                    System.out.println("Input out of range! Please re-enter");
                    continue;
                }
                else{
                    return num;
                }

            } catch (NumberFormatException e) {
                System.out.println("invalid input");
            }
        }
    }

    public String getChar() {
        List<String> moreElements = Arrays.asList("W", "A", "S", "D","T","R","Q","I");
        inputScope.addAll(moreElements);
        Scanner sc=new Scanner(System.in);
        while(true) {
            String s = sc.next().toUpperCase();
            Toolkit.getDefaultToolkit().beep();
            try {
                if (s.length() != 1) {
                    System.out.println("invalid input");
                    continue;
                }
                if(moreElements.contains(s)){
                    return s;
                }
                else {
                    System.out.println("Invalid input please enter again!");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid Input!");
            }
        }
    }
}
