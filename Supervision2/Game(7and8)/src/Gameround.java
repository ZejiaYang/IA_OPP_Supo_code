import java.io.InputStream;
import java.util.Scanner;
import java.io.IOException;

public class Gameround {
    private int target;
    private int current;
    private int step = 0;
    private int max_step;
    private int max_number;
    private int min_number;
    private static Scanner scanner = new Scanner(System.in);
    private PlayerInformation gamerecord;
    
    public Gameround(int _target, int _max_step, int _max_number, int _min_number){
        this.target = _target;
        this.max_step = _max_step;
        this.step = 0;
        this.max_number = _max_number;
        this.min_number = _min_number;
    }
    
    public boolean oneGameRound(){
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Input player's name: ");
        // try {
        //     int availableBytes = System.in.available();
        //     System.out.println(availableBytes);
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }
        String name = scanner.nextLine();
        System.out.println("Player's name is " + name + ".");
        this.gamerecord = new PlayerInformation(name);

        System.out.println("Current game difficulty: " + (12 - this.max_step) + " .");
        System.out.println("Would you want to change? [yes/no]");

        String ans = scanner.nextLine();
        if(ans.equals("yes"))
        { //eliminate the \n
            System.out.println("Input game difficulty [0-9]: ");
            this.max_step = 12 - scanner.nextInt();
            System.out.println("Current game difficulty: " + (12 - this.max_step) + " .");
        }

        System.out.println("Game Begins!");

        boolean success = false;
        while(this.step <= this.max_step - 1)
        {
            System.out.println("Input player's guess: ");
            this.current = scanner.nextInt();
            if(this.current > this.max_number || this.current < this.min_number){
                System.out.println("The number is out of range, please try again");
                continue;
            }
            
            this.gamerecord.addPlayerSteps();
            this.gamerecord.recordPlayerGuess(this.current);

            if(this.current < this.target){
                System.out.println("Go higher");
            }else if(this.current > this.target){
                System.out.println("Go lower");
            }else{
                this.gamerecord.recordPlayerResult(true);
                success = true;
                break;
            }
            this.step += 1;
        }

        if(success){
            System.out.println("Congratulations! The Target is " + this.target + ". You are Correct!");
            System.out.println("Game Over ~ Your Steps: " + (++this.step));
        }else{
            System.out.println("There is no step left! The Target is " + this.target + ".");
        }

        scanner.nextLine();
        System.out.println("Would you like another round? [yes/no]");
        do{
            ans = scanner.nextLine();
            if(ans.equals("yes"))
            { //eliminate the \n
                return true;
            }
            else if(ans.equals("no"))
            {
                return false;
            }
            else 
                System.out.println("It's not a valid answer, please give another");
        }while(true);
    }

    public PlayerInformation getGameRecord(){
        if(this.gamerecord == null)
            return new PlayerInformation("");
        return this.gamerecord;
    }
}
