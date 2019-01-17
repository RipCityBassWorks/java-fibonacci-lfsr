/*
 * Stefan Andersson
 * 01/16/2019
 * Fibonacci Linear Feedback Shift Register
 * 16 bit binary representation
 */
package fibonacci_lfsr;


/**
 *
 * @author Stefan
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        int[] input = {1,0,1,0,1,1,0,0,1,1,1,0,0,0,0,1};//{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        LFSR test = new LFSR(input, 4);
    }  
}
