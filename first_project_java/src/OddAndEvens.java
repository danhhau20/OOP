import java.util.*;
public class OddAndEvens 
{
    static int flag; 
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called 'Odds and Evens'");
        System.out.println ("What is your name?");
        String  name = input.nextLine();
        System.out.printf("Hi %s, which do you choose? (O)dds or (E)vens?\n",name);
        while (true)
        {
            String choose = input.next();
            if (choose.equals("O") ){
                System.out.println("name has picked Odds, The computer will be Evens!");
                flag =1 ;
                break;
            }
            else if (choose.equals("E")){
                System.out.println("name has picked Evens, the computer will be Odds!");
                flag = 0;
                break;
            }
            else {
                System.out.println("Please enter again!");
            }
        }
        PlayGame(name);
    }
    static void PlayGame(String name)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many fingers do you put out?");
        int userNumber;
        int computerNumber;
        while(true)
        {
            userNumber =  input.nextInt();
            computerNumber = rand.nextInt(6);
            if(((computerNumber % 2) == 0 && (userNumber %2) ==1) || ((computerNumber % 2) == 1 && (userNumber % 2) == 0)) {
                break;
            }
        }
        int sum = userNumber + computerNumber; 
        if ((sum %2) == 0 && flag == 0) 
        {
            System.out.println(name +" "+ "wins");
        }
        else if ((sum %2) == 1 && flag == 1)
        {
            System.out.println(name +" "+ "wins");
            System.out.println(sum);
        }
        else 
        {
            System.out.println("Computer wins");
            System.out.println(sum);
        }
    }
}
