public class Analysis_01 {
    public static void main(String[] args) {
        // Record the start time:
        long startTime = System.currentTimeMillis();
        
        // Run the algorithm:
        repeat1('*', 40);
        
        // Record the end time:
        long endTime = System.currentTimeMillis();
        
        // Calculate the elapsed time:
        long elapsed = endTime - startTime;
        
        System.out.println("Time elapsed in (ms): " + elapsed);
        
    }
    
    /** Uses repeated concatenation to compose a String with n copies of character c. */
    public static String repeat1(char c, int n) {
       String answer = "";
       for (int j=0; j < n; j++)
       answer += c;
       return answer;
    }

    /** Uses StringBuilder to compose a String with n copies of character c. */
    public static String repeat2(char c, int n) {
       StringBuilder sb = new StringBuilder( );
       for (int j=0; j < n; j++)
       sb.append(c);
       return sb.toString();
    }
}
