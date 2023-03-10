import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import questoes.DesafioDois;
import questoes.DesafioQuatro;
import questoes.DesafioTres;
import questoes.DesafioUm;
import questoes.model.Faturamento;

public class App {

    public final static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws IOException, ParseException{
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("{ 1 } - Desafio 1 (Fibonacci)");
        System.out.println("{ 2 } - Desafio 2 (Faturamento Distribuidora)");
        System.out.println("{ 3 } - Desafio 3 (Faturamento Percentual)");
        System.out.println("{ 4 } - Desafio 4 (Inverter String)");
        System.out.println("{ 0 } - SAIR");
        int opcao = input.nextInt();
        
        switch (opcao) {
            case 1 ->{
                desafioUmMenu();
            }

            case 2 ->{
                desafioDoisMenu();
            }

            case 3 ->{
                desafioTresMenu();
            }

            case 4 ->{
                desafioQuatroMenu();
            }

            case 0 ->{
                return;
            }
                
            default ->{
                System.out.println("Opção inválida!");
                menu();
            }
        }
    }

    public static void desafioUmMenu(){
        DesafioUm desafioUm = new DesafioUm();
        desafioUm.desafioUmPrompt();
    }

    public static void desafioDoisMenu() throws IOException, ParseException {
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

        DesafioDois desafioDois = new DesafioDois();
        desafioDois.lerDadosFaturamentoJson();
        desafioDois.calculaMediaValoresFaturamento();

        Faturamento menorFaturamento = desafioDois.calculaMenorValorFaturamento();
        Faturamento maiorFaturamento = desafioDois.calculaMaiorValorFaturamento();
        
        System.out.println("------------------------------------------------------");
        System.out.println("MENOR FATURAMENTO DO MÊS");
        System.out.println("DIA: " + menorFaturamento.getDia());
        System.out.println("VALOR: " + formatter.format(menorFaturamento.getValor()));

        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        System.out.println("MAIOR FATURAMENTO DO MÊS");
        System.out.println("DIA: " + maiorFaturamento.getDia());
        System.out.println("VALOR: " + formatter.format(maiorFaturamento.getValor()));
        
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");

        System.out.println("MÉDIA DE FATURAMENTO DO MÊS");
        System.out.println(formatter.format(desafioDois.getMedia()));
        
        System.out.println("------------------------------------------------------");

        List<Faturamento> faturamentos = desafioDois.calculaDiasDoMesFaturamentoMaiorQueMedia();

        System.out.println("------------------------------------------------------");
        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + faturamentos.size());

        for (Faturamento faturamento : faturamentos) {
            System.out.println("\nDIA: " + faturamento.getDia());
            System.out.println("VALOR: " + formatter.format(faturamento.getValor()));
        }
    }

    public static void desafioTresMenu() {
        DesafioTres desafioTres = new DesafioTres();
        
        System.out.println("--------------------------------");
        desafioTres.monstrarFaturamentos();
        System.out.println("--------------------------------");
        desafioTres.mostrarRepresentaçãoPercentualDeCadaEstado();
        System.out.println("--------------------------------");
    }

    public static void desafioQuatroMenu() {
        DesafioQuatro desafioQuatro = new DesafioQuatro();
        desafioQuatro.promptDesafioQuatro();
    }
    
}
