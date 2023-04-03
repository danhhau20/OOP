import java.util.*;
import java.util.Arrays;
class battleship {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String Map [][] = OceanMap(10,10);
        int[][] usership = new int[5][2];
        int[][] computership = new int[5][2];
        int user =5;
        int computer =5; 
        usership= EnterUsership();
        computership = ComputerShip(5, usership);
        Map= PlaceUserShip(usership, Map);
        Map = PlaceComputerShip(computership, Map);
        PrintMap(Map);
        while(user > 0 && computer >0){
            Result result = PlayerTurn(usership, computership, Map);
            String [][] newMap = result.getMap();
            user = user + result.getUser();
            computer = computer +result.getComputer();
            PrintMap(newMap);
            String C = input.nextLine();
            result = ComputerTurn(usership, computership, Map);
            user = user + result.getUser();
            computer = computer +result.getComputer();
            PrintMap(newMap);
            if (user == 0){
                System.out.println("You loose, Computer wins");
                break;
            }
            if(computer ==0){
                System.out.println("You win, Computer looses");
                break;
            }
        }
        //String[][] newMap = PlayerTurn(usership, computership, Map);

    }
    static String[][] OceanMap(int x, int y){
        String [][] bound = new String [x+2][y+2];
        for(int i =0; i< 12; i++){
            for (int j= 0; j<12; j++ ){
                if((j == 0) || (j == 11)){
                    if((i>0)&&(i<11)){
                        bound[i][0] = String.valueOf(i-1) + " |";
                        bound[i][11] = "| " + String.valueOf(i-1);
                    }
                    else{
                        bound[i][j] ="   ";
                    }
                }
                else{
                    if((i>0)&&(i<11)){
                        bound[i][j] = " ";
                    }
                    else{
                        bound[i][j] = String.valueOf(j-1);
                    }
                }
            }
        }
        return bound;
    }
    static void PrintMap(String[][] bound){
        for(int i =0; i< bound.length; i++ ){
            for(int j= 0; j< bound[i].length ; j++){
                if(j == 11){
                    System.out.print(bound[i][j]);
                    System.out.println("");
                }
                else{
                    System.out.print(bound[i][j]);
                }
            }
        }
    }
    static int[][] EnterUsership(){
        Scanner input = new Scanner(System.in);
        int[][] usership = new int [5][2];
        int i = 0;
        while (i<5){
            int flag =0;
            System.out.print("Enter X coordinate for your ship " + (i+1) + " X = "   );
            usership[i][0] = input.nextInt();
            System.out.println("");
            System.out.print("Enter Y coordinate for your ship " + (i+1) + " Y = "   );
            usership[i][1] = input.nextInt();
            System.out.println("");
            for(int j =0; j< i; j++){
                if ((usership[i][0] == usership[j][0]) && (usership[i][1] == usership[j][1])){
                    System.out.println("Same place ship, Please enter again");
                    flag =1; 
                    break;
                }
            }
            if((usership[i][0]>9)|| (usership[i][0]<0) || (usership[i][1]>9)|| (usership[i][1]<0)){
                System.out.println("Out of the map, Enter again");
                flag =1; 
            }
            if(flag == 0){
                i++;
            }
        }
        return usership;
    }
    static String [][] PlaceUserShip(int[][] usership, String[][] bound){
        for (int i=0; i< 5; i++){
            bound[usership[i][0]+1][usership[i][1]+1] = "@"; 
        }
        return bound;
    }
    static String [][] PlaceComputerShip(int[][] computership, String[][] bound){
        for (int i=0; i< 5; i++){
            bound[computership[i][0]+1][computership[i][1]+1] = "*"; 
        }
        return bound;
    }
    static int[][] ComputerShip(int numbership, int[][] usership){
        Random rand = new Random();
        int[][] computership = new int [numbership][2];
        int i = 0;
        while (i< numbership){
            int flag =0;
            computership[i][0] = rand.nextInt(10);
            computership[i][1] = rand.nextInt(10);
            for(int j =0; j< i; j++){
                if ((computership[i][0] == computership[j][0]) && (computership[i][1] == computership[j][1])){
                    flag =1; 
                    break;
                }
            }
            for(int k=0; k< numbership; k++){
                if ((computership[i][0] == usership[k][0]) && (computership[i][1] == usership[k][1])){
                    flag =1; 
                    break;
                }
            }
            if((computership[i][0]>9)|| (computership[i][0]<0) || (computership[i][1]>9)|| (computership[i][1]<0)){
                flag =1; 
            }
            if(flag == 0){
                System.out.println((i+1)+". Ship DEPLOYED");
                i++;
            }
        }
        return computership;
    }
    public static Result  PlayerTurn(int[][] usership, int[][] computership, String[][] Map){
        int flag=0;
        Scanner input = new Scanner(System.in);
        int X;
        int Y;
        int user = 0;
        int computer = 0;
        do {
            System.out.println("Your turn!");
            System.out.print("Enter X coordinate: ");
            X = input.nextInt();
            System.out.println("");
            System.out.print("Enter Y coordinate: ");
            Y = input.nextInt();
            System.out.println("");
            if((X>9)|| (X<0) || (Y>9)|| (Y<0)){
                flag =1; 
                System.out.println("Out side Map");
            }
        } while(flag == 1);
        int flag2 =0;
        for(int i=0; i< 5; i++){
            flag2=0;
            if((usership[i][0] == X) && (usership[i][1] == Y) && (Map[X+1][Y+1].equals("@"))){
                System.out.println("Oh no, you sunk your own ship :(");
                Map[X+1][Y+1] ="X";
                flag2=1;
                user =-1;
                break;
            }
            else if((computership[i][0] == X) && (computership[i][1] == Y) &&(Map[X+1][Y+1].equals("*"))){
                System.out.println("Boom! You sunk the ship!");
                Map[X+1][Y+1] ="!";
                flag2 =1;
                computer = -1;
                break;
            }
        }
        if(flag2 == 0 ){
            System.out.println("You missed");
            Map[X+1][Y+1] ="-";
        }
        return new Result(Map, user, computer);
    }
    public static Result ComputerTurn(int[][] usership, int[][] computership, String[][] Map){
        Random rand = new Random();
        int flag=0;
        Scanner input = new Scanner(System.in);
        int X;
        int Y;
        int user = 0;
        int computer = 0;
        do {
            X = rand.nextInt(10);
            System.out.println("");
            Y= rand.nextInt(10);
            System.out.println("");
            if((X>9)|| (X<0) || (Y>9)|| (Y<0)){
                flag =1; 
            }
        } while(flag == 1);
        int flag2 =0;
        for(int i=0; i< 5; i++){
            flag2=0;
            if((computership[i][0] == X) && (computership[i][1] == Y) && (Map[X+1][Y+1].equals("*"))){
                System.out.println("Oh no, Computer sunk it's own ship :(");
                Map[X+1][Y+1] ="!";
                flag2=1;
                computer =-1;
                break;
            }
            else if((usership[i][0] == X) && (usership[i][1] == Y) && (Map[X+1][Y+1].equals("@"))){
                System.out.println("Boom! Computer sunk the ship!");
                Map[X+1][Y+1] ="X";
                flag2 =1;
                user =-1;
                break;
            }
        }
        if(flag2 == 0 ){
            System.out.println("Computer missed");
        }
        return new Result(Map, user, computer);
    }
}