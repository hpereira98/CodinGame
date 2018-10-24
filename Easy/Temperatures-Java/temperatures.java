import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Guardar sempre a temperatura mais próxima de 0 e ir comparando com as novas
 * temperaturas: se for mais próxima substitui; se for igual prevalece a positiva.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int closer=0; // temperatura mais proxima de 0
        
        int n = in.nextInt(); // the number of temperatures to analyse
        if (n == 0) {
            System.out.println(closer);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (i == 0) closer = t; 
            else if (Math.abs(t)<Math.abs(closer) || (Math.abs(t)==Math.abs(closer) && t>0) )
                closer = t;   
        }

        System.out.println(closer);
    }
}