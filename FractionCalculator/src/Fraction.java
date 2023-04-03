/**
 * Fraction
 */
public class Fraction {

    private int numerator;
    private int denominator;
    public Fraction(int numerator, int denominator){
        if(denominator ==0){
            System.out.println("Please enter again denominator, denominator is not be zero");
        }
        else if (numerator * denominator>0){
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } 
        else {
            numerator = -Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }
    public Fraction(){
        this.numerator =0;
        this.denominator =1 ;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        String stringFraction = String.valueOf(numerator)+"/"+String.valueOf(denominator);
        return stringFraction; 
    }
    public double toDouble(){
        return numerator/ denominator;
    }
    public Fraction add(Fraction other){
        int newNumerator = numerator*other.getDenominator() + denominator * other.getNumerator();
        int newDenominator = denominator * other.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }
    public Fraction subtract(Fraction other){
        int newNumerator = numerator*other.getDenominator() - denominator * other.getNumerator();
        int newDenominator = denominator * other.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }
    public Fraction multiply(Fraction other){
        int newNumerator = numerator*other.getNumerator();
        int newDenominator = denominator * other.getDenominator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }
    public Fraction divide(Fraction other){
        int newNumerator = numerator*other.getDenominator();
        int newDenominator = denominator * other.getNumerator();
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }
    public boolean equals(Fraction other){
        if (other instanceof Fraction){
            other.toLowestTerms();;
            if(other.getNumerator() == this.getNumerator() && other.getDenominator()== this.getDenominator()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public void toLowestTerms(){
        int a = this.numerator;
        int b = this.denominator;
        while(a != 0 && b != 0){
            int temp = a;
            a= b;
            b = temp%a;
        }
        if(a != 0){
            this.numerator =this.numerator/a;
            this.denominator = this.denominator/a;
        }
    }
    public static int gcd(int number1, int number2){
        while(number1 != 0 && number2 != 0){
            int temp = number1;
            number1= number2;
            number2 = number1%temp;
        }
        return number1;
    }
}