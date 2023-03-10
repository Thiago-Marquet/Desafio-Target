package questoes;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import questoes.model.Faturamento;

public class DesafioDois {

    // Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, 
    // faça um programa, na linguagem que desejar, que calcule e retorne:
    // • O menor valor de faturamento ocorrido em um dia do mês;
    // • O maior valor de faturamento ocorrido em um dia do mês;
    // • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
    
    // IMPORTANTE:
    // a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
    // b) Podem existir dias sem faturamento, como nos finais de semana e feriados. 
    // Estes dias devem ser ignorados no cálculo da média;

    private List<Faturamento> faturamentos;
    private double media = 0.0;

    public DesafioDois(){
        faturamentos = new ArrayList<>();
    }

    public Faturamento calculaMaiorValorFaturamento(){

        double max = 0.0;
        Faturamento maiorFaturamento = new Faturamento();

        for (Faturamento faturamento : faturamentos) {
            if(faturamento.getValor() > 0 && faturamento.getValor() > max){
                max = faturamento.getValor();
                maiorFaturamento = faturamento;
            }
        }

        return maiorFaturamento;
    }

    public Faturamento calculaMenorValorFaturamento(){

        double min = Double.MAX_VALUE;
        Faturamento menorFaturamento = new Faturamento();

        for (Faturamento faturamento : faturamentos) {
            if(faturamento.getValor() > 0 && faturamento.getValor() < min){
                min = faturamento.getValor();
                menorFaturamento = faturamento;
            }
        }

        return menorFaturamento;
    }

    public void calculaMediaValoresFaturamento(){
        
        int divisor = 0;
        double somaDosValores = 0.0;
        
        for (Faturamento faturamento : faturamentos) {
            if(faturamento.getValor() > 0)
                divisor++;
                somaDosValores += faturamento.getValor();
        }

        this.media = somaDosValores/divisor;
    }

    public List<Faturamento> calculaDiasDoMesFaturamentoMaiorQueMedia(){
        List<Faturamento> faturamentosMaioresQueMedia = new ArrayList<>();

        for (Faturamento faturamento : faturamentos) {
            if(faturamento.getValor() > this.media){
                faturamentosMaioresQueMedia.add(faturamento);
            }
        }

        return faturamentosMaioresQueMedia;
    }

    public void lerDadosFaturamentoJson() throws IOException, ParseException{
        
        JSONParser jsonParser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src\\Data\\dados.json"));
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);

                faturamentos.add(new Faturamento((Long)object.get("dia"),(Double)object.get("valor")));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }


    public List<Faturamento> getFaturamentos() {
        return faturamentos;
    }

    public void setFaturamentos(List<Faturamento> faturamentos) {
        this.faturamentos = faturamentos;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

}
