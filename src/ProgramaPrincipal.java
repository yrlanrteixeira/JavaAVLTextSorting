import java.util.List;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        ListaDuplamenteEncadeada listaEncadeada;

        String caminhoArquivo = "C:\\Users\\yrlan.teixeira\\Documents\\Pessoal\\Atividades_PUC\\Atividades_AEDSII\\Trabalho_Pratico_Aplicação Java\\arquivoComCodigo.txt";
        ArquivoTexto arquivoTexto = new ArquivoTexto(caminhoArquivo);

        List<Palavras> palavras = arquivoTexto.coletarPalavras();

        for (Palavras palavra : palavras) {
            arvoreAVL.inserir(palavra);
        }

        arvoreAVL.percorrerEmOrdem();
        listaEncadeada = arvoreAVL.getLista();

        listaEncadeada.exibirLista();

    }
}
