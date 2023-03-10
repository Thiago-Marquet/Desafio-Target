package questoes.model;

public class Faturamento {

    private Long dia;
    private Double valor;

    public Faturamento(Long dia, Double valor){
        this.dia = dia;
        this.valor = valor;
    }

    public Faturamento() {
    }

    public Long getDia() {
        return dia;
    }

    public void setDia(Long dia) {
        this.dia = dia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
