
class GameState
{
    GameState prev;
    byte[] state;
    
    boolean validState;

    GameState(GameState _prev)
    {
        prev = _prev;
        state = new byte[22];
        validState = true;
    }
    
    GameState(GameState _prev, GameState copy) {
        prev = _prev;
        state = copy.state.clone();
        validState = copy.validState;
    }
    
    public void printState() {
        for(int i = 0; i < 11; i++)
            System.out.print("(" + state[2 * i] + "," +
                        state[2 * i + 1] + ") ");
        System.out.println();
    }

}