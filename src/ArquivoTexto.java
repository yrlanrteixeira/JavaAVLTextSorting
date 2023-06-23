import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTexto {
    private String caminhoArquivo;

    public ArquivoTexto(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    /**
     * Coleta palavras de um arquivo e retorna uma lista das palavras únicas
     * com sua frequência. A frequência é o número de ocorrências da palavra no
     * arquivo.
     *
     * @return uma lista de palavras únicas e sua frequência
     * @throws IOException se ocorrer um erro durante a leitura do arquivo
     */

    public List<Palavras> coletarPalavras() {
        List<Palavras> palavras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavrasLinha = linha.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (String palavra : palavrasLinha) {
                    if (!palavra.isEmpty()) {
                        Palavras novaPalavra = new Palavras(palavra);
                        if (palavras.contains(novaPalavra)) {
                            int index = palavras.indexOf(novaPalavra);
                            palavras.get(index).incrementarContador();
                        } else {
                            palavras.add(novaPalavra);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return palavras;
    }
}
