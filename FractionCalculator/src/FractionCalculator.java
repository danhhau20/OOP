import java.util.*;
public class FractionCalculator {
    public static void main(String[] args){
        System.out.println("This program is fraction calculator\nIt will add, subtract, mutiply, and divide fraction until you type Q to quit.");
        System.out.println("Please enter your fractions int the form a/b, where a and b are interger.");
        getOperation();
    } 
    public static String  getOperation(){
        Scanner input = new Scanner(System.in);
        String[] operater = {"+","-","*","/","=","q","Q"}; 
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        while(true){
            String user = input.nextLine();
            for (int i =0; i< operater.length; i++){
                if(user.equals(operater[i])){
                    return operater[i];
                }
            }
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
        }
    }
    public static boolean validFraction(String fraction){
        Scanner input = new Scanner(System.in);
        fraction = input.nextLine();
        String[] splits = new String[2];
        if(fraction.isEmpty()){
            return false;
        }
        if(fraction.contains("/") ){
            splits = fraction.split("/",2); // split string to {"numorator","denominator"}
            if(splits[1].length() ==1){
                if (Integer.valueOf(splits[1])== 0){
                    return false;
                }
            }
            for(int i=0; i< 2; i++){
                if(isNumber(splits[i])){
                    return true;
                }
            }
        }
        else{
            if(fraction.charAt(0) == '-') {
                String sub = fraction.substring(1, fraction.length());
                if(isNumber(sub)){
                    return true;
                }
            }
            else{
                if(isNumber(fraction)){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean isNumber(String s){
        for( int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static Fraction getFraction(){
        int num;
        int de =1;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a fraction (a/b) or (a)");
        String fraction = input.nextLine();
        while(validFraction(fraction) != true){
            System.out.println("Invalid fraction, please enter (a/b) or (a), where a and b are integer and b is not zero");
            fraction = input.nextLine();
        }
        String[] num_de = fraction.split("/", 2);
        if(num_de.length == 2){
            num = Integer.valueOf(num_de[0]);
            de = Integer.valueOf(num_de[1]);
        }
        else {
            num = Integer.valueOf(num_de[0]);
        }
        Fraction a = new Fraction(num, de);
        a.toLowestTerms();
        return a;
    }
}