import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Para isto, vamos utilizar um método de procura binária: deslocar sempre a medida
 * média entre o minimo e o maximo de cada eixo consoante o movimento a realizar
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int x=X0;
        int y=Y0;
        int ymin = -1; // valor minimo de y (na primeira iteracao é -1)
        int xmin = -1; // valor minimo de x (na primeira iteracao é -1)
        int ymax = H;  // valor maximo de y (altura do edificio)
        int xmax = W;  // valor maximo de X (largura do edificio)

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            switch(bombDir){ 
            case "U":
                ymax = y; // como o comando é UP, o y tem q diminuir, nao ultrapassando o valor atual de y
                System.out.println(x+" "+(y-(ymax-ymin)/2)); // deslocar y para o ponto medio entre o min e o max
                y -= (ymax-ymin)/2; // atualizar para valor médio
                break; // proceder do mm modo para os restantes comandos
            
            case "D":
                ymin = y;
                System.out.println(x+" "+(y+(ymax-ymin)/2));
                y += (ymax-ymin)/2;
                break;
                
            case "L":
                xmax = x;
                System.out.println((x-(xmax-xmin)/2)+" "+y);
                x -= (xmax-xmin)/2;
                break;
                
            case "R":
                xmin = x;
                System.out.println((x+(xmax-xmin)/2)+" "+y);
                x += (xmax-xmin)/2;
                break;
                
            case "UL":
                ymax = y;
                xmax = x;
                System.out.println((x-(xmax-xmin)/2)+" "+(y-(ymax-ymin)/2));
                x -= (xmax-xmin)/2;
                y -= (ymax-ymin)/2;
                break;
                
            case "UR":
                ymax = y;
                xmin = x;
                
                System.out.println((x+(xmax-xmin)/2)+" "+(y-(ymax-ymin)/2));
                x += (xmax-xmin)/2;
                y -= (ymax-ymin)/2;
                break;
                
            case "DL":
                ymin = y;
                xmax = x;
                
                System.out.println((x-(xmax-xmin)/2)+" "+(y+(ymax-ymin)/2));
                x -= (xmax-xmin)/2;
                y += (ymax-ymin)/2;
                break;
                
            case "DR":
                ymin = y;
                xmin = x;
                System.out.println((x+(xmax-xmin)/2)+" "+(y+(ymax-ymin)/2));
                x += (xmax-xmin)/2;
                y += (ymax-ymin)/2;
                break;
            
            }
        }
    }
}