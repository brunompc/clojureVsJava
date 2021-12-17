package src.java.pastrami;

public class Aluno {
    String nome;
    int nota;
    String nacionalidade;

    public Aluno(String nome, int nota, String nacionalidade) {
        this.nome = nome;
        this.nota = nota;
        this.nacionalidade = nacionalidade;
    }

    public boolean estaAprovado() {
        return nota >= 10;
    }

    @Override
    public String toString() {
        return nome + "";
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}
