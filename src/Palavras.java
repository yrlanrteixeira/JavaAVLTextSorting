public class Palavras {
    private String nome;
    private int contador;

    public Palavras(String nome) {
        this.nome = nome;
        this.contador = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getContador() {
        return contador;
    }

    public void incrementarContador() {
        contador++;
    }
}
