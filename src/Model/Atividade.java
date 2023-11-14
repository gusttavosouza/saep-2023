package Model;

public class Atividade {
    private int numero;
    private String nome;

    public Atividade(String nome) {
        this.nome = nome;
    }

    public Atividade(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
}
