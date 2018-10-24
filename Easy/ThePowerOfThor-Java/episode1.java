import java.util.*;
import java.io.*;
import java.math.*;

/**
 * É necessário guardar a cada iteração a posição do thor
 * 
**/

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        
        int actualTX=initialTX; // coord x a cada iteracao do Thor
        int actualTY=initialTY; // coord y a cada iteracao do Thor

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            int difX=actualTX-lightX;
            int difY=actualTY-lightY;
            
            if (difY<0 && difX<0){
                // A single line providing the move to be made: N NE E SE S SW W or NW
                System.out.println("SE");
                actualTX++;
                actualTY++;
            }
                
            if (difY<0 && difX>0){
                System.out.println("SW");
                actualTX--;
                actualTY++;
            }
            
            if (difY<0 && difX==0){
                System.out.println("S");
                actualTY++;
            }
                
            if (difY>0 && difX==0){
                System.out.println("N");
                actualTY--;
            }
            
            if (difY>0 && difX<0){
                System.out.println("NE");
                actualTX++;
                actualTY--;
            }
            
            if (difY>0 && difX>0){
                System.out.println("NW");
                actualTX--;
                actualTY--;
            }
                
            if (difY==0 && difX>0) {
                System.out.println("W");
                actualTX--;
            }
            
            if (difY==0 && difX<0){
                System.out.println("E");
                actualTX++;
            }
            
        }
    }
}