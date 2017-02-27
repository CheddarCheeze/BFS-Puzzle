
import java.util.Comparator;

class StateComparator implements Comparator<GameState>
{
    public int compare(GameState a, GameState b)
    {
//        System.out.println("Comparing ");
//        a.printState();
//        System.out.println(" to " );
//        b.printState();
        for(int i = 21; i >= 0; i--)
        {
            if(a.state[i] < b.state[i])
                return -1;
            else if(a.state[i] > b.state[i])
                return 1;
        }
        return 0;
    }
}