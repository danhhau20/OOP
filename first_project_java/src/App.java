import java.util.Scanner;
class Planner {
    public static void main (String[] args) {
        Greeting();
    }
    static void Greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.println("Nice to meet you "+name +", where are you travlling to?");
        String city = input.nextLine();
        System.out.println("Great !"+ city +" sounds like a great trip");
    } 
}
