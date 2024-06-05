package W1.D3;

/**
 *
 * @author clydebalaman
 */

public class Scoreboard {
    private int numEntries = 0; // number of actual entries
    private GameEntry[ ] board; // array of game entries (names & scores)
    
    /** Constructs an empty scoreboard with the given capacity for storing entries. */
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e) {
        int newScore = e.getScore( );
        // is the new entry e really a high score?
        
        if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if (numEntries < board.length) // no score drops from the board
                numEntries++; // so overall number increases
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1;
            while (j > 0 && board[j-1].getScore( ) < newScore) {
                board[j] = board[j-1]; // shift entry from j-1 to j
                j--; // and decrement j
            }
            board[j] = e; // when done, add new entry
        }
    }
    
    /** Remove and return the high score at index i. */ 
    public GameEntry remove(int i) throws IndexOutOfBoundsException { 
        if (i < 0 || i >= numEntries) 
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        GameEntry temp = board[i]; // save the object to be removed 
        
        for(int j = i; j < numEntries - 1; j++) // count up from i (not down)
            board[j] = board[j+1]; // move one cell to the left 
        
        board[numEntries - 1 ] = null; // null out the old last score 
        numEntries--; 
        return temp; // return the removed object 
    }

    public void displayBoard(){
        for(int i=0;i<this.numEntries;i++){
            System.out.println("board["+i+"]: " + board[i].toString());
        }
    }
    
}

class ScoreboardDemo{
    public static void main(String[] args) {
        Scoreboard sb1 = new Scoreboard(10);
        
        GameEntry e1 = new GameEntry("Mike",1105);
        GameEntry e2 = new GameEntry("Rob",750);
        GameEntry e3 = new GameEntry("Paul",720);
        GameEntry e4 = new GameEntry("Anna",660);
        GameEntry e5 = new GameEntry("Rose",590);
        GameEntry e6 = new GameEntry("Jack",510);
        sb1.add(e2);
        sb1.add(e6);
        sb1.add(e3);
        sb1.add(e4);
        sb1.add(e1);
        sb1.add(e5);
        
        GameEntry e7 = new GameEntry("Jill",740);
        sb1.add(e7);
        
        sb1.remove(3);
        
        sb1.displayBoard();
    }
}

/*
Extra Challenge:

1 .Perform these Test Cases:
Add your_name,2000
Add king,650
Add ysa,550
Add joey,540
Add eric,509
Display board
Add eric,1106
Display board
Remove top
Remove middle
Remove bottom
*/

/*
2. Create  Menu-based Scoreboard
Scoreboard Menu
[1] Add Entry
[2] Remove Entry
[3] Display Board
[4] Exit
*/
