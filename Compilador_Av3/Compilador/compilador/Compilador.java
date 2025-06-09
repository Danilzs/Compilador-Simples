package compilador;

import java.io.*;

public class Compilador {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java compilador.Compilador <arquivo_entrada>");
            System.exit(1);
        }

        String inputFile = args[0];

        try {
            System.out.println("LOG: --- iniciando compilação do arquivo: " + inputFile + " ---");
            
    // Comentário atualizado: 1. análise léxica (scanner é chamado pelo parser)
            System.out.println("LOG: \n--- etapa 1: análise léxica (tokens gerados pelo scanner) ---");
    // Comentário atualizado: O scanner será instanciado e chamado dentro do parser.
    // Comentário atualizado: Para demonstração separada (opcional), poderíamos rodar testeanalisadorlexico aqui.
    // Comentário atualizado: Mas a integração já demonstra isso implicitamente.

    // Comentário atualizado: 2. análise sintática (parser)
            System.out.println("LOG: \n--- etapa 2 e 3: análise sintática e integração (parser processando tokens) ---");
            Scanner scanner = new Scanner(new FileReader(inputFile));
            parser p = new parser(scanner); 
            
    // Comentário atualizado: Executa a análise sintática.
    // Comentário atualizado: As ações semânticas no .cup (system.out.println) serão executadas durante o parse.
    // Comentário atualizado: Se houver erros sintáticos, o parser os reportará.
            p.parse(); 

            System.out.println("LOG: \n--- compilação concluída (análise léxica e sintática) ---");
            System.out.println("LOG: Arquivo \"" + inputFile + "\" processado com sucesso.");
            System.out.println("LOG: Nota: a árvore sintática não está sendo explicitamente construída ou impressa neste exemplo, apenas mensagens de reconhecimento de regras (se houver) e erros sintáticos.");

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado: " + inputFile);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro de I/O ao ler o arquivo: " + inputFile);
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
    // Comentário atualizado: Captura erros de análise sintática ou outros erros inesperados
            System.err.println("\n--- Erro Durante a Compilação ---");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
