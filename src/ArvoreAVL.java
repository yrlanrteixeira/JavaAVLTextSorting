public class ArvoreAVL {
    private NoAVL raiz;
    private ListaDuplamenteEncadeada lista;

    /* Cria uma nova árvore AVL vazia. */
    public ArvoreAVL() {
        this.raiz = null;
        this.lista = new ListaDuplamenteEncadeada();
    }

    /**
     * Insere um objeto Palavras na estrutura de dados.
     *
     * @param palavra o objeto Palavras a ser inserido
     */

    public void inserir(Palavras palavra) {
        raiz = inserirNo(raiz, palavra);
    }

    /**
     * Insere um novo nó na árvore AVL com base na palavra fornecida e sua
     * comparação
     * com a palavra do nó atual. Se o nó for nulo, retorna um novo nó com a palavra
     * fornecida.
     * Caso contrário, chama recursivamente a si mesmo em um dos subárvores esquerda
     * ou direita,
     * dependendo do resultado da comparação. Também atualiza a altura e o fator de
     * balanceamento do nó
     * e realiza rotações, se necessário.
     *
     * @param no      o nó atual sendo comparado
     * @param palavra a palavra a ser inserida
     * @return o nó raiz da árvore AVL atualizada
     */

    private NoAVL inserirNo(NoAVL no, Palavras palavra) {
        if (no == null) {
            NoAVL novoNo = new NoAVL(palavra);
            return novoNo;
        }
        if (palavra.getNome().compareTo(no.getPalavra().getNome()) < 0) {
            no.setEsquerdo(inserirNo(no.getEsquerdo(), palavra));
        } else if (palavra.getNome().compareTo(no.getPalavra().getNome()) > 0) {
            no.setDireito(inserirNo(no.getDireito(), palavra));
        } else {
            no.getPalavra().incrementarContador();
            return no;
        }
        no.setAltura(1 + Math.max(obterAltura(no.getEsquerdo()), obterAltura(no.getDireito())));
        int fatorBalanceamento = calcularFatorBalanceamento(no);
        if (fatorBalanceamento > 1) {
            if (palavra.getNome().compareTo(no.getEsquerdo().getPalavra().getNome()) < 0) {
                return rotacaoDireita(no);
            } else {
                no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
                return rotacaoDireita(no);
            }
        }
        if (fatorBalanceamento < -1) {
            if (palavra.getNome().compareTo(no.getDireito().getPalavra().getNome()) > 0) {
                return rotacaoEsquerda(no);
            } else {
                no.setDireito(rotacaoDireita(no.getDireito()));
                return rotacaoEsquerda(no);
            }
        }
        return no;
    }

    public void remover(Palavras palavra) {
        this.raiz = removerNo(raiz, palavra);
    }

    /**
     * Remove um nó com uma determinada palavra da árvore AVL e a reequilibra se
     * necessário.
     *
     * @param no      o nó atual sendo analisado
     * @param palavra a palavra a ser removida da árvore
     * @return o nó que substitui o nó removido
     */

    private NoAVL removerNo(NoAVL no, Palavras palavra) {
        if (no == null)
            return null;

        int cmp = palavra.getNome().compareTo(no.getPalavra().getNome());
        if (cmp < 0)
            no.setEsquerdo(removerNo(no.getEsquerdo(), palavra));
        else if (cmp > 0)
            no.setDireito(removerNo(no.getDireito(), palavra));
        else {
            if (no.getEsquerdo() == null)
                return no.getDireito();
            else if (no.getDireito() == null)
                return no.getEsquerdo();
            NoAVL aux = no.getEsquerdo();
            while (aux.getDireito() != null)
                aux = aux.getDireito();
            no.setPalavra(aux.getPalavra());
            no.setEsquerdo(removerNo(no.getEsquerdo(), aux.getPalavra()));
        }

        no.setAltura(1 + Math.max(obterAltura(no.getEsquerdo()), obterAltura(no.getDireito())));
        int fatorBalanceamento = calcularFatorBalanceamento(no);

        if (fatorBalanceamento > 1 && palavra.getNome().compareTo(no.getEsquerdo().getPalavra().getNome()) < 0)
            return rotacaoDireita(no);
        if (fatorBalanceamento < -1 && palavra.getNome().compareTo(no.getDireito().getPalavra().getNome()) > 0)
            return rotacaoEsquerda(no);
        if (fatorBalanceamento > 1) {
            if (palavra.getNome().compareTo(no.getEsquerdo().getPalavra().getNome()) > 0) {
                no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
            }
            return rotacaoDireita(no);
        }
        if (fatorBalanceamento < -1) {
            if (palavra.getNome().compareTo(no.getDireito().getPalavra().getNome()) < 0) {
                no.setDireito(rotacaoDireita(no.getDireito()));
            }
            return rotacaoEsquerda(no);
        }
        return no;
    }

    /**
     * Realiza uma operação de rotação à direita em um nó AVL especificado. Este
     * método recebe um objeto NoAVL z e o rotaciona à direita.
     *
     * @param noZ O nó AVL a ser rotacionado.
     * @return O novo nó raiz após a rotação.
     */

    private NoAVL rotacaoDireita(NoAVL noZ) {
        NoAVL noY = noZ.getEsquerdo();
        NoAVL noT3 = noY.getDireito();

        noY.setDireito(noZ);
        noZ.setEsquerdo(noT3);

        // Atualiza as alturas de noZ e noY
        int alturaEsquerdaZ = obterAltura(noZ.getEsquerdo());
        int alturaDireitaZ = obterAltura(noZ.getDireito());
        int alturaNovaZ = 1 + Math.max(alturaEsquerdaZ, alturaDireitaZ);
        noZ.setAltura(alturaNovaZ);

        int alturaEsquerdaY = obterAltura(noY.getEsquerdo());
        // int alturaDireitaY = obterAltura(noY.getDireito());
        int alturaNovaY = 1 + Math.max(alturaEsquerdaY, alturaNovaZ);
        noY.setAltura(alturaNovaY);

        return noY;
    }

    /**
     * Rotaciona o nó da árvore AVL para a esquerda.
     *
     * @param noZ o nó a ser rotacionado
     * @return a nova raiz da sub-árvore após a rotação
     */

    private NoAVL rotacaoEsquerda(NoAVL noZ) {
        NoAVL noY = noZ.getDireito();
        NoAVL noT2 = noY.getEsquerdo();

        noY.setEsquerdo(noZ);
        noZ.setDireito(noT2);

        // Atualiza as alturas de noZ e noY
        int alturaEsquerdaZ = obterAltura(noZ.getEsquerdo());
        int alturaDireitaZ = obterAltura(noZ.getDireito());
        int alturaNovaZ = 1 + Math.max(alturaEsquerdaZ, alturaDireitaZ);
        noZ.setAltura(alturaNovaZ);

        int alturaEsquerdaY = obterAltura(noY.getEsquerdo());
        // int alturaDireitaY = obterAltura(noY.getDireito());
        int alturaNovaY = 1 + Math.max(alturaEsquerdaY, alturaNovaZ);
        noY.setAltura(alturaNovaY);

        return noY;
    }

    /**
     * Retorna a altura de um nó em uma árvore AVL.
     *
     * @param no o nó cuja altura será obtida
     * @return a altura do nó, ou 0 se for nulo
     */
    private int obterAltura(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    /**
     * Calcula o fator de balanceamento de um nó da árvore AVL.
     *
     * @param no o nó da árvore AVL para calcular o fator de balanceamento
     * @return um inteiro representando o fator de balanceamento do nó
     */
    private int calcularFatorBalanceamento(NoAVL no) {
        if (no == null) {
            return 0;
        }
        return obterAltura(no.getEsquerdo()) - obterAltura(no.getDireito());
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdem(raiz);
    }

    /**
     * Realiza uma travessia em ordem na árvore AVL enraizada no nó fornecido,
     * adicionando cada palavra do nó a uma lista.
     *
     * @param no o nó raiz da árvore AVL a ser percorrida
     */

    private void percorrerEmOrdem(NoAVL no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerdo());
            lista.adicionarFim(no.getPalavra());
            percorrerEmOrdem(no.getDireito());
        }
    }

    public ListaDuplamenteEncadeada getLista() {
        return lista;
    }
}
