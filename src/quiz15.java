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
               "A - 1965.", "B - 1969.", "C - 1972.", "D - 1975.", "E - 1980.", "B"));
       perguntas.add(new Pergunta(5, "Qual é a capital da Austrália?",
               "A - Sydney.", "B - Melbourne.", "C - Canberra.", "D - Brisbane.", "E - Adelaide.", "C"));
       perguntas.add(new Pergunta(6, "Qual é o maior oceano do mundo?",
               "A - Oceano Atlântico.", "B - Oceano Pacífico.", "C - Oceano Índico.", "D - Oceano Ártico.", "E - Oceano Antártico.", "B"));
       perguntas.add(new Pergunta(7, "Quem pintou a Mona Lisa?",
               "A - Vincent van Gogh.", "B - Pablo Picasso.", "C - Leonardo da Vinci.", "D - Michelangelo.", "E - Rembrandt.", "C"));
       perguntas.add(new Pergunta(8, "Qual é o continente mais populoso?",
               "A - África.", "B - Europa.", "C - Ásia.", "D - América do Norte.", "E - América do Sul.", "C"));
       perguntas.add(new Pergunta(9, "Qual é a fórmula química da água?",
               "A - H2O.", "B - CO2.", "C - NaCl.", "D - CH4.", "E - O2.", "A"));
       perguntas.add(new Pergunta(10, "Qual é o menor país do mundo em termos de área?",
               "A - Mônaco.", "B - Nauru.", "C - San Marino.", "D - Vaticano.", "E - Liechtenstein.", "D"));
       perguntas.add(new Pergunta(11, "Qual é o planeta mais próximo do Sol?",
               "A - Vênus.", "B - Terra.", "C - Marte.", "D - Mercúrio.", "E - Netuno.", "D"));
       perguntas.add(new Pergunta(12, "Qual é o maior deserto do mundo?",
               "A - Deserto do Saara.", "B - Deserto de Gobi.", "C - Deserto de Kalahari.", "D - Deserto da Antártica.", "E - Deserto de Atacama.", "D"));
       perguntas.add(new Pergunta(13, "Quem foi o primeiro presidente dos Estados Unidos?",
               "A - George Washington.", "B - Abraham Lincoln.", "C - Thomas Jefferson.", "D - John Adams.", "E - James Madison.", "A"));
       perguntas.add(new Pergunta(14, "Qual é o símbolo químico do ferro?",
               "A - Fe.", "B - F.", "C - Ir.", "D - Fr.", "E - Fl.", "A"));
       perguntas.add(new Pergunta(15, "Qual é o nome do maior animal terrestre?",
               "A - Elefante africano.", "B - Girafa.", "C - Baleia azul.", "D - Rinoceronte.", "E - Hipopótamo.", "A"));

       return perguntas;
   }

   private static class Pergunta {
       private final int numero;
       private final String pergunta;
       private final String opcaoA;
       private final String opcaoB;
       private final String opcaoC;
       private final String opcaoD;
       private final String opcaoE;
       private final String respostaCorreta;

       public Pergunta(int numero, String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String respostaCorreta) {
           this.numero = numero;
           this.pergunta = pergunta;
           this.opcaoA = opcaoA;
           this.opcaoB = opcaoB;
           this.opcaoC = opcaoC;
           this.opcaoD = opcaoD;
           this.opcaoE = opcaoE;
           this.respostaCorreta = respostaCorreta;
       }

       public boolean verificarResposta(String resposta) {
           if (resposta.equals(respostaCorreta)) {
               System.out.println("Resposta correta!");
               return true;
           } else {
               System.out.println("Resposta errada. A resposta correta é: " + respostaCorreta);
               return false;
           }
       }
