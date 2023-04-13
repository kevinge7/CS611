
import java.util.ArrayList;
import java.util.Scanner;
public class PromptScan {

    /*
    This class is used for scanning and validating.
    * */

    public static String scan() {
        /*Scan function create a scanner and take a string as input*/
        Scanner scan = new Scanner(System.in);
        String output = scan.nextLine();
        return output;
    }

    public static int judgePosInt(String input){
        /*Judge Positive Integer: make a judgement to see if a string is a positive integer or 0. If not the return a -1.*/
        int value = 0;
        for (int i = 0; i<input.length();i++) {
            if (input.charAt(i) == ' ' || (input.charAt(i) == '0' && i < input.length() - 1)) continue;
            int number = input.charAt(i) - '0';
            if (number >= 0 && number <= 9) {
                value = 10 * value + number;
            } else {
                System.out.println("Not a positive integer!Try another");
                return -1;
            }
        }
        return value;
    }

    public static double JudgeProbability(String input) {
        /* Judge if a input string is a double between 0 and 1 like a probability.*/
        try {
            double value = Double.parseDouble(input);
            if (value >= 0 && value <= 1){
                return value;
            }else{
                return -1;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int scanPosInt(){
        /*combination of scan and judge positive integer.*/
        String input = scan();
        return judgePosInt(input);
    }

    public static double scanProb(){
        /*combination of scan and judge if the input is a double between 0 and 1 like a probability*/
        String input = scan();
        return JudgeProbability(input);
    }

    public static int scanPosIntUpperBound(int upperbound){
        /*scan a string as input and take a upperbound parameter and judge if the input integer is a non-negative
        integer and within the upperbound*/
        while (true){
            int output = scanPosInt();
            if (output > upperbound){
                System.out.println("Input out of range!Try another.");
            }else{
                return output;
            }
        }
    }

    public static int scanWithinArray(ArrayList<Integer> range){
        /* take an input string and judge if its within the string array given as a parameter */
        while (true){
            int output = scanPosInt();
            if (!range.contains(output)){
                System.out.println("Input out of range!Try another.");
            }else{
                return output;
            }
        }
    }



}
