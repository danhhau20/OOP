public class SoftwareEngineer extends TechnicalEmployee {
    // Should start without access to code and with 0 code check ins
    private boolean codeAccess;
    public SoftwareEngineer(String name){
        super(name);
    }
    // Should return whether or not this SoftwareEngineer has access to make changes to the code base
    public boolean getCodeAccess() {
        return codeAccess;
    }
    // Should allow an external piece of code to update the SoftwareEngieer's code privileges to either true or false
    public void setCodeAccess(boolean access){
        codeAccess = access;
    }
    // Should return the current count of how many times this SoftwareEngineer has successfully checked in code
    public int getSuccessfulCheckIns(){
        return checkIns;
    }
    public boolean checkInCode(){
        //Should check if this SoftwareEngineer's manager approves of their check in.
        // If the check in is approved their successful checkin count should be increased and the method should return "true".
        // If the manager does not approve the check in the SoftwareEngineer's code access should be changed to false and
        // the method should return "false"
        TechnicalLead manager= (TechnicalLead) this.getManager();
        if (manager.approveCheckIn(this)){
            this.checkIns++;
            return true;
        } else {
            codeAccess=false;
            return false;
        }
    }
}