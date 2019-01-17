/*
 * Stefan Andersson
 * 01/16/2019
 * Fibonacci Linear Feedback Shift Register
 * 16 bit binary representation
 */
package fibonacci_lfsr;


public class LFSR 
{
    private int[] seed;
    private int[] result;
    private char[] hexResult;
    
    public LFSR(int[] input, int num)
    {
        seed = input;
        result = input;
        hexResult = new char[4];
        toHex();
        System.out.println("Seed:");
        printResult();
        int i;
        for(i = 0; i < num; i++)
        {
            shiftSequence();
            toHex();
            printResult();
        }
    }
    
    public void shiftSequence()
    {
        int[] temp = new int[16];
        System.arraycopy(result, 0, temp, 0, 16);
        int xor_out = temp[10] ^ (temp[12] ^ (temp[13] ^ temp[15]));
        System.arraycopy(temp, 0, result, 1, 15);
        result[0] = xor_out;
    }
    
    public void printResult()
    {
        int i;
        for(i = 0; i < 16; i++)
        {
            System.out.print(result[i]);
        }
        System.out.println();
        
        for(i = 0; i < 4; i++)
        {
            System.out.print(hexResult[i]);
        }
        System.out.println();
        System.out.println();
    }
    
    public void toHex()
    {          
        int i;
        for(i = 0; i < 4; i++)
        {
            int binary = concatInt(i);
            switch(binary)
            {
                case 0: hexResult[i] = '0';
                    break;
                case 1: hexResult[i] = '1';
                    break;
                case 10: hexResult[i] = '2';
                    break;
                case 11: hexResult[i] = '3';
                    break;
                case 100: hexResult[i] = '4';
                    break;
                case 101: hexResult[i] = '5';
                    break;
                case 110: hexResult[i] = '6';
                    break;
                case 111: hexResult[i] = '7';
                    break;
                case 1000: hexResult[i] = '8';
                    break;
                case 1001: hexResult[i] = '9';
                    break;
                case 1010: hexResult[i] = 'A';
                    break;
                case 1011: hexResult[i] = 'B';
                    break;
                case 1100: hexResult[i] = 'C';
                    break;
                case 1101: hexResult[i] = 'D';
                    break;
                case 1110: hexResult[i] = 'E';
                    break;
                case 1111: hexResult[i] = 'F';
                    break;
            }
        }
    }
    
    public int concatInt(int i)
    {
        int[] temp = new int[4];
        
        switch(i)
        {
            case 0:
                System.arraycopy(result, 0, temp, 0, 4);
                break;
            case 1:
                System.arraycopy(result, 4, temp, 0, 4);
                break;
            case 2:
                System.arraycopy(result, 8, temp, 0, 4);
                break;
            case 3:
                System.arraycopy(result, 12, temp, 0, 4);
                break;
        }
        
        String bin = Integer.toString(temp[0]) + Integer.toString(temp[1]) + Integer.toString(temp[2]) + Integer.toString(temp[3]);
        
        int binary = Integer.parseInt(bin);
        
        return binary;
    }
}
