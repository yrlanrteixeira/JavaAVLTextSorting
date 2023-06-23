public class ListaDuplamenteEncadeada {
    private NoLista primeiro;
    private NoLista ultimo;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionarInicio(Palavras palavra) {
        NoLista novoNo = new NoLista(palavra);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro.setAnterior(novoNo);
            primeiro = novoNo;
        }
    }

    public void adicionarFim(Palavras palavra) {
        NoLista novoNo = new NoLista(palavra);
        if (ultimo == null) {
            primeiro = novoNo;
        } else {
            novoNo.setAnterior(ultimo);
            ultimo.setProximo(novoNo);
        }
        ultimo = novoNo;
    }

    public void exibirLista() {
        NoLista atual = primeiro;
        while (atual != null) {
            atual = atual.getProximo();
        }
        System.out.println("******************Lista ordenada por ordem lexicográfica******************");
        exibirListaOrdemLexografica();
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("***************** Lista ordenada por contador em ordem decrescente ******************");
        exibirListaPorContador();
    }

    public void exibirListaOrdemLexografica() {
        NoLista atual = primeiro;

        while (atual != null) {
            System.out.println(
                    "Ordem lexicográfica: " + atual.getPalavra().getNome() + " - Quantidade de vezes contadas: "
                            + atual.getPalavra().getContador());
            atual = atual.getProximo();
        }
    }

    public void exibirListaPorContador() {
        ordenarPorContador();

        NoLista atual = primeiro;
        while (atual != null) {
            System.out
                    .println("Ordem por contador: " + atual.getPalavra().getNome() + "\t"
                            + " - Quantidade de vezes contadas: "
                            + atual.getPalavra().getContador());
            atual = atual.getProximo();
        }
    }

    public void ordenarPorContador() {
        NoLista atual = primeiro;

        while (atual != null) {
            NoLista max = atual;

            NoLista temp = atual.getProximo();
            while (temp != null) {
                if (temp.getPalavra().getContador() > max.getPalavra().getContador()) {
                    max = temp;
                }
                temp = temp.getProximo();
            }
            Palavras tmp = atual.getPalavra();
            atual.setPalavra(max.getPalavra());
            max.setPalavra(tmp);

            atual = atual.getProximo();
        }
    }

    private static class NoLista {
        private Palavras palavra;
        private NoLista anterior;
        private NoLista proximo;

        public NoLista(Palavras palavra) {
            this.palavra = palavra;
            this.anterior = null;
            this.proximo = null;
        }

        public Palavras getPalavra() {
            return palavra;
        }

        public void setPalavra(Palavras palavra) {
            this.palavra = palavra;
        }

        public NoLista getAnterior() {
            return anterior;
        }

        public void setAnterior(NoLista anterior) {
            this.anterior = anterior;
        }

        public NoLista getProximo() {
            return proximo;
        }

        public void setProximo(NoLista proximo) {
            this.proximo = proximo;
        }

    }
}
