import java.util.Scanner;
class Crypto 
{
    public static void main (String[] args) 
    {
        System.out.println("Please enter sentence to encrypt:");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String new_text= encryptString(text,2,3);
        System.out.println(new_text);
    }
    public static String encryptString(String text, int ShiftValue, int nl){
        text= NomalizeText(text);
        text= caesarify(text,ShiftValue);
        text= groupify(text, nl);
        return text;
    }
    static String NomalizeText(String text)
    {
        text=text.replaceAll(" ","");
        text = text.replaceAll("\\p{IsPunctuation}", "");
        return  text.toUpperCase();
    } 
    public static String caesarify(String text, int ShiftValue){
        String newtext = "";
        for (int i =0; i< text.length(); i++){
            int curNumber =(int) text.charAt(i)+ ShiftValue;
            if(curNumber <65){
                curNumber = 90-(64-curNumber);
                newtext = newtext + (char)curNumber;
            } 
            else if (curNumber > 90){
                curNumber = 65+(-91+curNumber);
                newtext = newtext + (char)curNumber;
            }
            else{
                newtext = newtext + (char)curNumber;
            }
        }
        return newtext;
    }
    public static  String groupify(String text, int nl){
        String newtext = "";
        for (int i=0; i< text.length(); i++){
            if(((i+1) % nl) == 0){
                newtext = newtext + text.charAt(i) + " ";
            }
            else{
                newtext = newtext + text.charAt(i);
            }
        }
        int pad = (text.length()+1) % nl;
        if (pad >0){
            for (int i = 0; i<pad; i++){
                newtext = newtext + "x";
            } 
        }
        return newtext;
    }
}
