abstract class BusinessEmployee extends Employee{
    public double bonusBudget;
    // Has a default salary of 50000
    public  BusinessEmployee(String name){
        super(name, 50000);
    }
    public String employeeStatus(){
        return (super.toString() + " with a budget of " + String.valueOf(bonusBudget) );
    }
    //Should establish a running tally of the remaining bonusBudget for the team this employee supports. 
    //How that budget is determined will depend on which type of Business Employee it is
    public double getBonusBudget(){
        return bonusBudget;
    }
}