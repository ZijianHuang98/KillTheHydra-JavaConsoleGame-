public class Game {
      int heads;
      int tails;
    boolean lastMove;
    boolean ifQuit= false;

    public Game(int h, int t) {
        heads= h;
        tails= t;
        lastMove= false;
    }
//The process of the game
    public void process(int m)
    {
        switch(m) {
            case -1:
                System.out.println("Hahaha,you lose");
                ifQuit=true;
                break;

            case 1:
                if (heads < 1) {
                    System.out.println("There is not enough heads to cut, so cannot use this move");
                    return;
                }
                heads--;
                heads++;
                break;
            case 2:
                if (tails < 1)
                {
                    System.out.println("There is not enough tails to cut, so cannot use this move");
                    return;
                }
                tails--;
                tails+=2;
                break;
            case 3:
                if(heads<2)
                {
                    System.out.println("There is not enough heads to cut, so cannot use this move");
                    return;
                }
                heads-=2;
                lastMove=true;
                break;
            case 4:
                if(tails<2)
                {
                    System.out.println("There is not enough heads to cut, so cannot use this move");
                    return;
                }
                tails-=2;
                heads++;
                break;

            case 5:
                System.out.println("The S is "+ findS() );
                break;
        }

    }
    //to check if the hydra is dead
    public boolean ifdead()
    {
if(lastMove && heads == 0 && tails == 0)
{
  return true;
}
lastMove= false;
return false;
    }
    //to check if the player want to quit
    public boolean Quit()
    {
        if(ifQuit)
            return true;
        return false;
    }
    public String toString() {
        if(!ifdead()) {
            return "Hydra has " + heads + " heads and " + tails + " tails.";
        }
        if(ifdead())
        {
            return " You win, and now the Hydra has 0 head and 0 tail.";
        }
        return "";
    }

    public  int findS()
    {
        int count = 0;
        int h= heads;
        int t= tails;
        // my way is first let the heads be even
        //then make the tail be multiple of 4 so if I cut all tails, the head still can be even
        //then I only need to cut head.
        if (h != 0 || t != 0)
        {
            if(t <= 0 && h%2 != 0)
            {
                return -1;
            }
            if(h %2 != 0 && t == 2)
            {
                t-=2;
                h++;
                count++;
                count = count + h/2;
                return count;
            }
            if(h %2 != 0)
            {
                t-=2;
                h++;
                count++;
            }

            while(t %4 != 0)
            {
                t++;
                count++;
            }

            count = count + t/2;
            h = h + t/2;
            count = count + h/2;

        }
        return count;
    }

}
