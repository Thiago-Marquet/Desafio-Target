package questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DesafioTres {
    
    // Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

    // SP – R$67.836,43
    // RJ – R$36.678,66
    // MG – R$29.229,88
    // ES – R$27.165,48
    // Outros – R$19.849,53

    // Escreva um programa na linguagem que desejar 
    // onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.

    private Map<String,BigDecimal> faturamentos = new HashMap<>();


    public DesafioTres(){
        faturamentos.put("SP", BigDecimal.valueOf(67836.43));
        faturamentos.put("RJ", BigDecimal.valueOf(36678.66));
        faturamentos.put("MG", BigDecimal.valueOf(29229.88));
        faturamentos.put("ES", BigDecimal.valueOf(27165.48));
        faturamentos.put("Outros", BigDecimal.valueOf(19849.53));
    }

    public Map<String,BigDecimal> calculaPercentualRepresentacaoEstado(){
        BigDecimal total = faturamentos.values().stream().map(x -> x).reduce(BigDecimal::add).get();
        Map<String,BigDecimal> faturamentosPercent = new HashMap<>();
        
        for (Map.Entry<String,BigDecimal>  set : faturamentos.entrySet()) {
            BigDecimal porcentagem = set.getValue()
                .multiply(BigDecimal.valueOf(100))
                .divide(total,2,RoundingMode.HALF_UP);//(valor * 100) / total
            
            faturamentosPercent.put(set.getKey(), porcentagem);
        }

        return faturamentosPercent;
    }

    public void mostrarRepresentaçãoPercentualDeCadaEstado(){
        Map<String,BigDecimal> faturamentoPercentual = calculaPercentualRepresentacaoEstado();
        for (Map.Entry<String,BigDecimal>  set : faturamentoPercentual.entrySet()) {
            System.out.println(set.getKey() + " - " + set.getValue() + " %");
        }
    }

    public void monstrarFaturamentos(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        BigDecimal total = faturamentos.values().stream().map(x -> x).reduce(BigDecimal::add).get();

        for (Map.Entry<String,BigDecimal>  set : faturamentos.entrySet()) {
            System.out.println(set.getKey() + " - " + formatter.format(set.getValue()));
        }

        System.out.println("\nTotal: " + formatter.format(total));
    }

}
