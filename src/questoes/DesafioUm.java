package questoes;

import java.util.Scanner;

public class DesafioUm {

    // Dado a sequência de Fibonacci, 
    // onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores 
    // (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), 
    // escreva um programa na linguagem que desejar onde, informado um número, 
    // calcule a sequência de Fibonacci e retorne uma mensagem 
    // avisando se o número informado pertence ou não a sequência.


    public void desafioUmPrompt(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe um número inteiro e positivo " +  
        "para saber se ele pertence ou não à sequência de Fibonacci.");
        
        int n = input.nextInt();
        input.close();

        if(pertenceAFibonacci(n)){
            System.out.println("O número " + n + ", pertence a sequência de Fibonacci.");
        }else{
            System.out.println("O número " + n + ", NÃO pertence a sequência de Fibonacci.");
        }
        
    }
    
    public boolean pertenceAFibonacci(int n){
        if(n < 0){
            return false;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        while (c < n) {
            c = a + b;
            a = b;
            b = c;
        }

        return c == n;
    }

}
