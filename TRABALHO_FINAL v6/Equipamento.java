public class Equipamento {
    private int codigo;
    private String nome;
    private String tipo; // "barra", "kettlebell" ou "corda naval"
    private int quantidadeDisponivel;
    private double valorBase;
    private boolean seguro;

    // Construtor
    public Equipamento(int codigo, String nome, String tipo, int quantidadeDisponivel, double valorBase, boolean seguro) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valorBase = valorBase;
        this.seguro = seguro;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public double getValorBase() {
        return valorBase;
    }

    public boolean isSeguro() {
        return seguro;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    // toString
    @Override
    public String toString() {
        return "Equipamento{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", valorBase=" + valorBase +
                ", seguro=" + (seguro ? "Contratado" : "Não contratado") +
                '}';
    }

    // Método para calcular o valor do aluguel com base no período
    public double calcularValorAluguel(int dias) {
        double valor = valorBase;
        
        if (dias == 15) {
            valor *= 0.95; // 5% de desconto
        } else if (dias >= 30) {
            valor *= 0.90; // 10% de desconto
        }

        if (seguro) {
            valor *= 1.02; // 2% de acréscimo
        }

        return valor;
    }

    // Método para retirar (alugar) equipamento
    public boolean retirar() {
        if (quantidadeDisponivel > 0) {
            quantidadeDisponivel--;
            return true;
        } else {
            return false; // sem estoque
        }
    }

    // Método para devolver (devolver ao estoque)
    public void devolver() {
        quantidadeDisponivel++;
    }
}
