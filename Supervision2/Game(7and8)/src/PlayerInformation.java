import java.util.Vector;

public class PlayerInformation {
    private String name = "";
    private int steps = 0;

    private boolean result = false;
    Vector<Integer> playerguess;

    public PlayerInformation(String _name){
        this.name = _name;
        this.playerguess = new Vector<Integer>();
    }

    public PlayerInformation(String _name, int _steps, Vector<Integer> _playerguess){
        this.name = _name;
        this.steps = _steps;
        this.playerguess = _playerguess;
    }

    public void recordPlayerGuess(int guess){
        playerguess.add(guess);
    }

    public void recordPlayerResult(boolean result) {this.result = result;}
    
    public void addPlayerSteps(){
        this.steps += 1;
    }

    public int getPlayerSteps(){
        return this.steps;
    }

    public String getPlayerName() {return this.name;}

    public Boolean getPlayerResult() {return this.result;}

    public void displayPlayerInformation(){
        System.out.println("name: " + this.name + "Steps: " + this.steps);
    }

}
