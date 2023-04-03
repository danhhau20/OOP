public class Result {
    private String[][] Map;
    private int user;
    private int computer;
    public Result(String [][] Map, int user, int computer){
        this.Map = Map;
        this. user = user;
        this.computer= computer;
    }
    public String[][] getMap() {
        return Map;
    }

    public int getUser() {
        return user;
    }
    public int getComputer() {
        return computer;
    }
}