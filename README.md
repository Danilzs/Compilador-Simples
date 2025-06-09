# Compilador Simples - Avaliação AV3

Este projeto implementa um compilador front-end desenvolvido para a avaliação AV3 da disciplina de Compiladores. Ele realiza análise léxica com **JFlex** e análise sintática com **Java CUP**, processando códigos-fonte em uma linguagem simplificada e validando sua estrutura com suporte a detecção de erros léxicos e sintáticos.

## 🎯 Objetivo

Construir um compilador capaz de:
- Identificar tokens válidos (palavras-chave, identificadores, literais, operadores, delimitadores) usando análise léxica.
- Validar a sintaxe do código-fonte com base em uma gramática definida, utilizando análise sintática.
- Detectar e reportar erros léxicos (ex.: símbolos inválidos) e sintáticos (ex.: falta de ponto e vírgula).
- Demonstrar a integração entre lexer e parser por meio de testes automatizados.

## 📁 Estrutura do Projeto

A organização do projeto é modular, facilitando manutenção e testes:


### Descrição dos Componentes
- **Diretório `/compilador`**: Contém as classes Java geradas e os scripts de teste compilados.
- **Diretório `/lib`**: Armazena as bibliotecas externas necessárias para JFlex e Java CUP.
- **Arquivos de Especificação**:
  - `analisador_lexico.flex`: Define as regras léxicas para reconhecimento de tokens.
  - `analisador_sintatico.cup`: Define a gramática para análise sintática.
- **Arquivos de Teste**:
  - `input.txt`: Código-fonte válido para testes gerais.
  - `entrada_erro_lex.txt`: Inclui erro léxico (ex.: símbolo inválido `@`).
  - `entrada_erro_sin.txt`: Inclui erro sintático (ex.: falta de `;`).
  - `exemplo_lex.txt`: Exemplo para validação léxica e sintática.
- **Scripts de Automação**:
  - `run.bat`: Automatiza a geração, compilação e execução do compilador.
  - `run_erro.bat`: Executa testes específicos para erros léxicos e sintáticos.
- **Arquivos Opcionais**:
  - `Scanner.java~`: Backup gerado automaticamente (pode ser ignorado).
  - `/.idea` e `*.iml`: Configurações do IntelliJ IDEA, úteis para desenvolvimento na IDE.

## ⚙️ Requisitos

- **Java JDK**: Versão 8 ou superior (testado com JDK 1.8.0_451; recomenda-se JDK 11+ para maior estabilidade).
- **JFlex**: Versão 1.9.1 (incluída em `lib/jflex-full-1.9.1.jar`).
- **Java CUP**: Versão 11b (incluída em `lib/java-cup-11b.jar` e `lib/java-cup-11b-runtime.jar`).
- **Sistema Operacional**: Windows (scripts `.bat` fornecidos); adaptável para Linux/Mac com ajustes nos scripts.
- **IDE (Opcional)**: IntelliJ IDEA para desenvolvimento e depuração (configurações inclusas em `/.idea`).

## 🚀 Como Executar

O projeto inclui scripts de automação para simplificar a compilação e execução no Windows.

### Execução Geral
1. Edite o arquivo `input.txt` com o código-fonte a ser compilado, respeitando a gramática da linguagem (ex.: declarações de variáveis, funções, comandos `if`, `while`, `print`).
2. Abra o PowerShell ou Prompt de Comando no diretório do projeto:

   cd C:\caminho\para\compilador
3. Execute o script de automação:

   .\run.bat
O script realiza:
- Limpeza de arquivos gerados anteriormente.
- Geração do analisador léxico (`Scanner.java`) com JFlex.
- Geração do analisador sintático (`parser.java`, `sym.java`) com Java CUP.
- Compilação de todas as classes Java.
- Execução de testes léxicos e sintáticos com `exemplo_lex.txt`.
- Compilação do código em `input.txt` com exibição de tokens e regras reconhecidas.

### Testes de Erro
1. Os arquivos `teste_erroL.txt` (contém símbolo inválido `@`) e `erro_sintatico.txt` (falta de `;`) estão prontos para testar a detecção de erros.
2. Execute o script de testes de erro:

   .\run_erro.bat
O script executa:
- Teste léxico com `teste_erroLlex.txt`, reportando símbolos inválidos.
- Teste sintático com `erro_sintatico.txt`, reportando erros de gramática.

## 📄 Exemplo de Entrada (`input.txt`)

```c
int calculaFatorial(int valor) {
  if (valor == 0) {
 return 1;
  } else {
 return valor * calculaFatorial(valor - 1);
  }
}

void pontoDeEntrada() {
  int numero = 5;
  int resultado;
  print("Calculando fatorial de ");
  print("5");
  resultado = calculaFatorial(numero);
  print("Resultado: ");
  print("120");
}

Saída Esperada:

Tokens identificados (ex.: INT, ID, SEMICOLON) com linha e coluna.
Regras sintáticas reconhecidas (ex.: "Declaração simples de variável", "Definição de função calculaFatorial").
Mensagem de compilação bem-sucedida ou erros, se houver.

🧪 Testes

Testes Gerais: Edite input.txt ou exemplo_lex.txt para testar diferentes códigos válidos. Execute run.bat para verificar a análise léxica e sintática.
Testes de Erro:
teste_erroL.txt: Verifica a detecção de símbolos inválidos (ex.: @).
erro_sintatico.txt: Valida a identificação de erros sintáticos (ex.: falta de ; após int x = 10).
Use run_erro.bat para executar esses testes automaticamente.


Resultados: Os erros são reportados com linha, coluna e descrição (ex.: "Erro léxico: Símbolo não reconhecido '@' na linha 15, coluna 1").

🛠️ Desenvolvimento

IDE: Desenvolvido no IntelliJ IDEA, com configurações salvas em /.idea e *.iml para facilitar a importação do projeto.
Workflow:
Especificações definidas em analisador_lexico.flex (tokens) e analisador_sintatico.cup (gramática).
Geração automatizada de Scanner.java, parser.java e sym.java via scripts.
Testes implementados em ExecutorTesteLexico.java (léxico), ExecutorTesteSintatico.java (sintático) e CompiladorPrincipal.java (integração).


Observação: A gramática suporta construções como variáveis (int, float), funções, comandos if, while, return, print, mas não gera uma árvore sintática explícita, apenas mensagens de reconhecimento.

📚 Tecnologias Utilizadas

Java: Linguagem principal para lógica e execução.
JFlex 1.9.1: Geração do analisador léxico.
Java CUP 11b: Geração do analisador sintático.
IntelliJ IDEA: Ambiente de desenvolvimento integrado.

👥 Autores

Danilo Silva - Matrícula: 2218928
Cassio Tiago - Matrícula: 2316229

📝 Notas Adicionais

A linguagem suportada é simplificada, com suporte a tipos int, float, void, expressões aritméticas, relacionais, controle de fluxo e impressão.
Os scripts .bat são otimizados para Windows. Para Linux/Mac, adapte os comandos de classpath e separadores de caminho (/ em vez de \, : em vez de ;).
Para suporte ou dúvidas, contate os autores via matrículas institucionais.



