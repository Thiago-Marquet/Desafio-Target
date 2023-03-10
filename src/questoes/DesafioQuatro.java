package questoes;

import java.util.Scanner;

public class DesafioQuatro {
    
    // Escreva um programa que inverta os caracteres de um string.

    // IMPORTANTE:
    // a) Essa string pode ser informada através de qualquer entrada de sua preferência ou 
    // pode ser previamente definida no código;
    // b) Evite usar funções prontas, como, por exemplo, reverse;


    public String reverteString(String s){
        char[] sArrayChar = s.toCharArray();
        String sInversa = "";
        for (int i = sArrayChar.length - 1; i >= 0; i--) {
            sInversa += sArrayChar[i];
        }

        return sInversa;
    }

    public void promptDesafioQuatro(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite uma palavra para ter ela invertida.");
        String s = input.nextLine();
        
        input.close();
        String sReversa = reverteString(s);

        System.out.println(sReversa);
    }
}
