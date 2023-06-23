# Leitura e Ordenação de Palavras em um Arquivo de Texto usando Árvore AVL - Aplicação Java

## Inicialização

Este é um programa Java que lê um arquivo de texto, coleta as palavras presentes no arquivo e as insere em uma árvore AVL. Em seguida, a árvore é percorrida em ordem, e as palavras são exibidas em duas listas: uma ordenada por ordem lexicográfica e outra ordenada por contador em ordem decrescente.

## 💻 Requisitos

Certifique-se de ter o Java Development Kit (JDK) instalado em seu sistema para compilar e executar o programa.

## 🚀 Uso

1. Baixe os arquivos do projeto.
2. Abra um terminal e navegue até o diretório onde os arquivos estão localizados.
3. Compile os arquivos Java usando o seguinte comando:

```bash
javac ProgramaPrincipal.java
```

4. Execute o programa usando o seguinte comando:

```
java ProgramaPrincipal
```

5. O programa irá ler o arquivo especificado no caminho fornecido em caminhoArquivo na classe ProgramaPrincipal e exibirá as palavras ordenadas em duas listas diferentes.

Observação: Certificando-se de que o arquivo de texto fornecido no caminho fornecido em caminhoArquivo existe.

#### Exemplo de caminho de arquivo

```bash
 String caminhoArquivo = "C:\arquivos\palavras.txt";
```

## Estrutura do Projeto

O projeto consiste nos seguintes arquivos Java:

- `ProgramaPrincipal.java`: Contém o método main que é o ponto de entrada do programa.

- `Palavras.java:` Define a classe Palavras que representa uma palavra com seu nome e contador.

- `NoAVL.java:` Define a classe NoAVL que representa um nó de uma árvore AVL.

- `ListaDuplamenteEncadeada.java:` Define a classe ListaDuplamenteEncadeada que implementa uma lista duplamente encadeada para armazenar as palavras.

- `ArvoreAVL.java:` Define a classe ArvoreAVL que implementa uma árvore AVL e fornece métodos para inserção e percurso em ordem.

- ` ArquivoTexto.java:` Define a classe ArquivoTexto que lê o arquivo de texto, coleta as palavras e retorna uma lista de palavras.

## 📝 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.
