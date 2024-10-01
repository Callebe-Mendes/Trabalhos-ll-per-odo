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
       System.out.println("=======================================================");
   }

   private static QuizResultado fazerQuiz() {
       int acertos = 0;
       int erros = 0;
       List<Integer> perguntasErradas = new ArrayList<>();
       List<Pergunta> perguntas = criarPerguntas();

       // Itera sobre as perguntas e acumula o número de acertos e erros
       for (Pergunta pergunta : perguntas) {

           pergunta.exibirPergunta();
           String resposta = leiaResposta();
           if (pergunta.verificarResposta(resposta)) {
               acertos++;
           } else {
               erros++;
               perguntasErradas.add(pergunta.numero);
           }
           System.out.println("=========================================================================");
       }

       return new QuizResultado(acertos, erros, perguntasErradas);
   }

   private static void exibirMensagemFinal(QuizResultado resultado) {
       int totalPerguntas = 15;
       double porcentagemAcertos = (double) resultado.acertos / totalPerguntas * 100;
       double porcentagemErros = (double) resultado.erros / totalPerguntas * 100;
