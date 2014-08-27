
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
    static final Scanner ler = new Scanner(System.in);

        public static void main (String args[]) throws IOException {
            char opcao;
            
            while(true){
                System.out.print("Imagem: simples <s> | espaçada <c> | sair <s> ");
                opcao = ler.next().charAt(0);
                if(Character.toLowerCase(opcao) == 's')
                    matrizRegular();
                if(Character.toLowerCase(opcao) == 'c')
                    matrizIrregular();
                if(Character.toLowerCase(opcao) == 'e')
                    break;
            }
        }
    
        public static void matrizRegular () throws IOException {
        String caminho;
        int rgb, r, g, b;
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        
        System.out.print("Caminho da Imagem: ");
        caminho = ler.next();
        
        BufferedImage imagem = ImageIO.read(new File(caminho));
        
        for(int i = 0; i < imagem.getWidth(); i++){
            for(int j = 0; j < imagem.getHeight(); j++){
                rgb = imagem.getRGB(i, j);
                r = (new Color(rgb)).getRed();
                g = (new Color(rgb)).getGreen();
                b = (new Color(rgb)).getBlue();
                rgb = (r+g+b)/3;
               
                if(rgb < 85){
                    bw.write(":"+i+":"+j);
                }
            }
        }
        ler.close();        
        bw.close();
    }

    public static void matrizIrregular () throws IOException {
        String caminho;
        int rgb, r, g, b;
        long col, lin;
        int deltaCol, deltaLin;
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));

        System.out.print("Caminho da Imagem: ");
        caminho = ler.next();
        
        System.out.print("Colunas: ");
        while(true){
            if(ler.hasNextInt()){
                col = ler.nextInt();
                break;
            }else{
                ler.next();
            }
        }
        
        System.out.print("Linhas: ");
        while(true){
            if(ler.hasNextInt()){
                lin = ler.nextInt();
                break;
            }else{
                ler.next();
            }
        }
                
        BufferedImage imagem = ImageIO.read(new File(caminho));
        
        deltaCol = (int)(imagem.getWidth()/col);
        deltaLin = (int)(imagem.getHeight()/lin);
        
        for(int i = deltaCol/2; i < imagem.getWidth(); i+=deltaCol){
            for(int j = deltaLin/2; j < imagem.getHeight(); j+=deltaLin){
                rgb = imagem.getRGB(i, j);
                r = (new Color(rgb)).getRed();
                g = (new Color(rgb)).getGreen();
                b = (new Color(rgb)).getBlue();
                rgb = (r+g+b)/3;
               
                if(rgb < 84){
                    bw.write(":"+i+":"+j);
                }
            }
        }
        ler.close();        
        bw.close();
    }
    
}
