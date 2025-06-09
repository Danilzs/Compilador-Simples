# Compilador - Projeto AV3

Este projeto é um compilador simples desenvolvido como parte da avaliação AV3 da disciplina de Compiladores. Ele utiliza **JFlex** para análise léxica e **Java CUP** para análise sintática.

## 📁 Estrutura do Projeto

```plaintext
compilador/
├── analisador_lexico.flex         # Definição do analisador léxico
├── analisador_sintatico.cup       # Definição do analisador sintático
├── input.txt                      # Código de entrada para testes
├── run.bat                        # Script de execução
├── run_erro.bat                   # Script de execução com tratamento de erro
├── Scanner.java~                  # Backup do scanner
└── .idea/, *.iml                  # Configurações do IntelliJ IDEA


## ⚙️ Requisitos

- Java JDK (8 ou superior)
- [JFlex](https://jflex.de/)
- [Java CUP](http://www2.cs.tum.edu/projects/cup/)

## 🚀 Como Executar

1. Pode modificar a entrada no arquivo input.txt, portanto que atenda os requisitos da linguagem. E então, abra o cmd ou powershell e use o comando run.bat (ou ./run.bat)

📄 Exemplo de Entrada (input.txt)

int a;
a = 10 + 20;

🧪 Testes
Para testar diferentes entradas, edite o arquivo input.txt conforme necessário.

🛠️ Desenvolvimento
Este projeto foi desenvolvido utilizando a IDE IntelliJ IDEA. As configurações da IDE estão incluídas na pasta .idea/.

📚 Tecnologias Utilizadas
Java

JFlex

Java CUP

👨‍💻 Autor
Danilo Silva - 2218928
Cassio Tiago - 2316229







