public class Cliente {
    private int matricula;
    private String nome;
    private String academia;
    private Equipamento equipamentoAlugado;

    // Construtor
    public Cliente(int matricula, String nome, String academia, Equipamento equipamentoAlugado) {
        this.matricula = matricula;
        this.nome = nome;
        this.academia = academia;
        this.equipamentoAlugado = equipamentoAlugado;
    }

    // Getters
    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getAcademia() {
        return academia;
    }

    public Equipamento getEquipamentoAlugado() {
        return equipamentoAlugado;
    }

    // Setters
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public void setEquipamentoAlugado(Equipamento equipamentoAlugado) {
        this.equipamentoAlugado = equipamentoAlugado;
    }

    // toString
    @Override
    public String toString() {
        return "Cliente{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", academia='" + academia + '\'' +
                ", equipamentoAlugado=" + (equipamentoAlugado != null ? equipamentoAlugado.toString() : "Nenhum") +
                '}';
    }
}