import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
int head;
int tail;
boolean inputV=false;
int move;

Scanner input = new Scanner ( System.in );
System.out.println("Tell me the heads of the hydra");
head = input.nextInt();
System.out.println("Tell me the tails of the hydra");
tail = input.nextInt();
Game game=new Game(head,tail);
while(true)
{
    //to print rules
    rules();
//to do some validation
do    {
        try
        {
            System.out.println("Enter the move you want the knight use, or type -1 to give up");
            move=input.nextInt();
            game.process(move);
            if(move < -1 || move > 5){
                throw new NumberFormatException();
            }
        }
        catch (InputMismatchException e)
        {
            inputV=true;
            System.out.println("Invalid input!");
        }
        catch (NumberFormatException e)
        {
            inputV=true;
            System.out.println("Must be between 1-5.");
        }
    }while(inputV);
    //to print toString func
    System.out.println(game);
//several conditions that end the while loop
    //if the hydra dead
    if(game.ifdead())
    {
        break;
    }
    //if the player give up
    if(game.Quit())
    {
        break;
    }

}
    }
    public static void rules()
    {
        System.out.println("1. Cut off one head\n"+
                "2. Cut off one tail.\n"+
                "3. Cut off two heads.\n" +
                "4. Cut off two tails\n"+
                "5. Display s.\n");
    }
}
