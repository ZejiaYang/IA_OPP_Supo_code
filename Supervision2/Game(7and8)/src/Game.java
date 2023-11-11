import java.util.Random;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
/*
Design (using a UML class diagram) a HiLo guessing game. This game should select a random integer
and the objective is for the user to guess the number that the computer has chosen. Each guess
should result either in a response saying to “go higher”, “go lower” or “correct”. There should be a
maximum number of guesses before the computer responds with a “Game over” message and
prompts the user to have a rematch. There should be a score board recording player information and
game statistics. The game difficulty should also be configurable
*/
public class Game{
    private int guessNumber = 12 ;
    private int gameDifficulty; //gameDifficulty should be from 0 - 10
    private int minNumber = 0;
    private int maxNumber = 100;
    private Map<String, Integer> playerBestRecord = new HashMap<String, Integer>();
    private Vector<PlayerInformation> playerInfo = new Vector<PlayerInformation>();
    private Random randomNumber = new Random();

    public Game(int _guessNumber, int _gameDifficulty, int _max, int _min){
        this.guessNumber = _guessNumber;
        this.gameDifficulty = _gameDifficulty;
        this.maxNumber = _max;
        this.minNumber = _min;
    }

    public Game(int _guessNumber, int _gameDifficulty){
        this.guessNumber = _guessNumber;
        this.gameDifficulty = _gameDifficulty;
    }

    public Game(int _gameDifficulty){
        this.gameDifficulty = _gameDifficulty;
    }

    public void startGame(){
        System.out.println("Welcome to the HiLo guessing game!");
        boolean gameContinue = true;
        while(gameContinue){
            int target = randomGenerator();
            Gameround round = new Gameround(target, this.guessNumber - this.gameDifficulty, this.maxNumber, this.minNumber);
            gameContinue = round.oneGameRound();
            PlayerInformation currentPlayerInfo = round.getGameRecord();
            
            if(currentPlayerInfo.getPlayerResult()){
                if(this.playerBestRecord.containsKey(currentPlayerInfo.getPlayerName())){
                    int steps = playerBestRecord.get(currentPlayerInfo.getPlayerName());
                    if(steps > currentPlayerInfo.getPlayerSteps()){
                    playerBestRecord.remove(currentPlayerInfo.getPlayerName());
                    playerBestRecord.put(currentPlayerInfo.getPlayerName(), currentPlayerInfo.getPlayerSteps());
                    }
                }else{
                    playerBestRecord.put(currentPlayerInfo.getPlayerName(), currentPlayerInfo.getPlayerSteps());
                }
            }
           this.playerInfo.add(currentPlayerInfo);
        }
        
        this.displayScoreBoard();
        System.out.println("Thanks for playing!");
    }

    public void displayScoreBoard(){
        String divider = "**************************";
        System.out.println(divider);
        System.out.printf("| %-10s | %-13s |\n", "Player", "Minimum Steps");
        System.out.println("**************************");
        Iterator<String> keyIterator = this.playerBestRecord.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.printf("| %-10s | %-13d |\n", key , this.playerBestRecord.get(key));
        }
        System.out.println("**************************");
    }

    private int randomGenerator(){
        return randomNumber.nextInt((this.maxNumber - this.minNumber) + 1) + this.minNumber;
    }

    public static void main(String[] args) {
        Game newgame = new Game(0);
        newgame.startGame();
        return;
    }
}
