import java.util.TreeSet;  
import java.util.ArrayDeque;

class main
{
    public static void resultPrint(GameState gs) {
        if(gs.prev != null) {
            resultPrint(gs.prev);
        }
        gs.printState();
    }
    
    public static void main(String args[])
    {
        // Create empty set S
        // Create empty queue Q
        StateComparator comp = new StateComparator();
        TreeSet<GameState> set = new TreeSet<GameState>(comp);
        ArrayDeque<GameState> queue = new ArrayDeque<GameState>();
        
        // root.parent = NIL
        GameState a = new GameState(null);
        GameState b;
        Block board = new Block(a);
        
        // Q.enqueue(root)
        queue.add(a);
        set.add(a);
        
        // While Q is not empty:
        while(!queue.isEmpty()) {
            
            // current = Q.dequeue()
            a = new GameState(queue.peek(), queue.pop());
            
            // if current is the goal
            if(a.state[0] == 4 && a.state[1] == -2) {
                // return current (print out path)
                resultPrint(a.prev);
                break;
            }
            
            //a.printState();

            // For each node n that is adjacent to current:
            for(int i = 0; i < a.state.length; i++) {
                a.state[i] += 1;
                board.isValid(a);
                // if n is not in S
                if(a.validState && !set.contains(a)) {
                    // Add n to S
                    b = new GameState(a.prev, a);
                    set.add(b);
                    queue.add(b);
                    //System.out.println("ADDED");
                }
                a.state[i] -= 2;
                board.isValid(a);
                if(a.validState && !set.contains(a)) {
                    b = new GameState(a.prev, a);
                    set.add(b);
                    queue.add(b);
                    //System.out.println("ADDED");
                }
                a.state[i] += 1;
            }
        }
//        Viz maze;
//        try {
//        maze = new Viz();
//        }
//        catch(Exception e) {
//            System.out.println("Line 35 of Main. New Viz could not be created.");
//        }
    }
}