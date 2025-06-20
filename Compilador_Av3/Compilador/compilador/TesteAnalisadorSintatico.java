package compilador;

import java.io.*;
import java_cup.runtime.Symbol;

public class TesteAnalisadorSintatico {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java compilador.TesteAnalisadorSintatico <arquivo_entrada>");
            System.exit(1);
        }

        String inputFile = args[0];

        try {
            System.out.println("LOG: Analisando sintaticamente o arquivo: " + inputFile);
            Scanner scanner = new Scanner(new FileReader(inputFile));
            parser p = new parser(scanner); // Instancia o parser com o scanner
            
    // Comentário atualizado: Executa a análise sintática
    // Comentário atualizado: O parser gerado pelo jcup chama automaticamente o scanner para obter tokens
    // Comentário atualizado: As ações semânticas no .cup (system.out.println) serão executadas durante o parse
            p.parse(); 

            System.out.println("LOG: \nanálise sintática concluída com sucesso (sem erros fatais reportados pelo parser).");
            System.out.println("LOG: Nota: a árvore sintática não está sendo explicitamente impressa neste teste, apenas mensagens de reconhecimento de regras (se houver).");

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado: " + inputFile);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro de I/O ao ler o arquivo: " + inputFile);
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
    // Comentário atualizado: Erros sintáticos são geralmente tratados pelos métodos report_error/report_fatal_error no parser
    // Comentário atualizado: Mas uma exceção pode ocorrer em caso de erro fatal ou outro problema
            System.err.println("\nErro durante a análise sintática:");
    // Comentário atualizado: E.printstacktrace(); // descomente para detalhes do erro, se necessário
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
