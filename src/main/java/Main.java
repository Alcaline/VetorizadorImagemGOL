
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a1094785
 */
public class Main{

    public static void main (String args[]) throws IOException {
        String caminho;
        int rgb, r, g, b;
        long col, lin;
        Scanner ler = new Scanner(System.in);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        
        caminho = ler.next();
        
        BufferedImage imagem = ImageIO.read(new File(caminho));
        
        for(int i = 0; i < imagem.getWidth(); i+=10){
            for(int j = 0; j < imagem.getHeight(); j+=10){
                rgb = imagem.getRGB(i, j);
                r = (new Color(rgb)).getRed();
                g = (new Color(rgb)).getGreen();
                b = (new Color(rgb)).getBlue();
                rgb = (r+g+b)/3;
               
                if(rgb < 84){
                    bw.write(i+":"+j+":");
                }
            }
        }
        ler.close();        
        bw.close();
    }
    
}
