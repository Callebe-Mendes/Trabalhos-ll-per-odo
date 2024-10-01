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

       System.out.println("=======================================================");
       System.out.println("Fim do Quiz! Parabéns... Você acertou: " + resultado.acertos + " de " + totalPerguntas + " perguntas.");
       System.out.println("Você errou: " + resultado.erros + " perguntas.");
       System.out.println("Porcentagem de acertos: " + String.format("%.2f", porcentagemAcertos) + "%");
       System.out.println("Porcentagem de erros: " + String.format("%.2f", porcentagemErros) + "%");

       if (resultado.erros > 0) {
           System.out.println("Perguntas erradas: " + resultado.perguntasErradas);
       }
       System.out.println("=======================================================");
   }

   private static String leiaResposta() {
       String resposta;
       do {
           System.out.print("Digite a resposta (A, B, C, D, E): ");
           resposta = scanner.next().toUpperCase();
       } while (!respostaValida(resposta));
       return resposta;
   }

   private static boolean respostaValida(String resposta) {
       if (resposta.matches("[A-E]")) {
           return true;
       }
       System.out.println("Resposta inválida. Por favor, digite A, B, C, D ou E.");
       return false;
   }

   private static List<Pergunta> criarPerguntas() {
       List<Pergunta> perguntas = new ArrayList<>();

       perguntas.add(new Pergunta(1, "Qual é o maior planeta do sistema solar?",
               "A - Marte.", "B - Terra.", "C - Júpiter.", "D - Saturno.", "E - Urano.", "C"));
       perguntas.add(new Pergunta(2, "Quem escreveu 'Dom Quixote'?",
               "A - Gabriel García Márquez.", "B - Miguel de Cervantes.", "C - William Shakespeare.",
               "D - Jorge Luis Borges.", "E - Ernest Hemingway.", "B"));
       perguntas.add(new Pergunta(3, "Qual é o elemento químico com símbolo 'O'?",
               "A - Ouro.", "B - Oxigênio.", "C - Osmônio.", "D - Oxônio.", "E - Platina.", "B"));
       perguntas.add(new Pergunta(4, "Em que ano o homem pisou na Lua pela primeira vez?",
