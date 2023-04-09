import java.util.List;
import java.util.Scanner;
//take all the input from this class
public class InputValidator {
//get an int input without boundary
    public int getInt() {
        while(true) {
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
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
            try{
                int num=Integer.parseInt(s);
                if(num > range || num == 0){
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

    public char getChar() {
        Scanner sc=new Scanner(System.in);
        while(true) {
            String s = sc.next();
            try {
                if (s.length() != 1) {
                    System.out.println("invalid input");
                    continue;
                }
                char c = s.charAt(0);
                c = Character.toUpperCase(c);
                return c;
            }catch (NumberFormatException e){
                System.out.println("Invalid Input!");
            }
        }
    }
}
