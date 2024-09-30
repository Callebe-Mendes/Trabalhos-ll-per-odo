import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Trabalho15perguntas {
  
 private static final Scanner scanner = new Scanner(System.in);


   public static void main(String[] args) {
       // Cabeçalho do programa
       exibirCabecalho();

       // Executa o quiz e conta o número de acertos e erros
       QuizResultado resultado = fazerQuiz();

       // Exibe a mensagem final
       exibirMensagemFinal(resultado);
   }

   private static void exibirCabecalho() {
       System.out.println("=======================================================");
       System.out.println("                Bem-vindo ao Quiz!");
       System.out.println("     Responda às perguntas selecionando a opção correta.");
       System.out.println("        As opções de resposta são: A, B, C, D e E.");
