public class TechnicalEmployee extends Employee{
    public int checkIns = 0;
    public  TechnicalEmployee(String name){
        super(name, 75000);
    }
    public String employeeStatus(){
        return (super.toString() +" " + " has " + String.valueOf(checkIns) + " successful checks in.");
    }
    public void setCheckIns(){
        checkIns++;
    }

}