import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        
        int size = MESSAGE.length();
        
        StringBuilder binary = new StringBuilder(); // String with the MESSAGE translated to binary
        StringBuilder res = new StringBuilder(); // Result string
        
        for (int i=0;i<size;i++){ // transform the message in binary
            binary.append(Integer.toBinaryString(MESSAGE.charAt(i)));
            while(binary.length() % 7 != 0){ // if toBinaryString returns a binary code with less than 7 bits, insert '0' in the begining of the char codification
                binary.insert(7*i,'0');
            }
        }
        
        int cont=0; // counter of equal bits
        for (int i=0;i<binary.length();i++){
            int j=i; 
            while(j<binary.length() && binary.charAt(i)==binary.charAt(j)){ // if binary[i] equals binary[i+1] increment cont
                cont++;
                j++;
            }
            
            if(binary.charAt(i)=='0') res.append("00 "); // if the first bit of the sequence being analyzed is 0, add 00 to the result string
            else res.append("0 "); // if the first bit is 1, add 0 to the result string

            for (int k=0;k<cont;k++) // add to the result string 'cont' times 0
                res.append("0");
            
            if (j!=binary.length()) res.append(" "); // separate the codes with a space
            i+=cont-1; // update i to the next code sequence
            cont=0; // restart the counter
        }
        
        System.out.println(res);
    }       
    
}