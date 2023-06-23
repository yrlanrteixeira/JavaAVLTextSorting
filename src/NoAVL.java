public class NoAVL {
    private Palavras palavra;
    private NoAVL esquerdo;
    private NoAVL direito;
    private int altura;

    public NoAVL(Palavras palavra) {
        this.palavra = palavra;
        this.esquerdo = null;
        this.direito = null;
        this.altura = 1;
    }

    public Palavras getPalavra() {
        return this.palavra;
    }

    public void setPalavra(Palavras palavra) {
        this.palavra = palavra;
    }

    public NoAVL getEsquerdo() {
        return this.esquerdo;
    }

    public void setEsquerdo(NoAVL esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NoAVL getDireito() {
        return this.direito;
    }

    public void setDireito(NoAVL direito) {
        this.direito = direito;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
        }
}
