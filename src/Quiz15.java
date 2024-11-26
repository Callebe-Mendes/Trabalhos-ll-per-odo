import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz15 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cabeçalho do programa
        exibirCabecalho();

        // Executa o quiz e conta o número de acertos e erros
        int acertos = 0;
        int erros = 0;
        List<Integer> questoesErradas = new ArrayList<>();
        List<Questao> questoes = criarQuestoes();


        for (Questao questao : questoes) {
            questao.exibirQuestao();
            String resposta = leiaResposta();
            if (questao.verificarResposta(resposta)) {
                acertos++;
            } else {
                erros++;
                questoesErradas.add(questao.numero);
            }
            System.out.println("=========================================================================");
        }

        // Exibe a mensagem final
        exibirMensagemFinal(acertos, erros, questoesErradas);
    }

    private static void exibirCabecalho() {
        System.out.println("=======================================================");
        System.out.println("Centro Universitário Alfredo Nascer - Unifan");
        System.out.println("Aluno: Callebe Mendes Ribeiro");
        System.out.println("Disciplina: Algoitmo e Programação II");
        System.out.println("Professor: Breno Pimenta");
        System.out.println("=======================================================");
        System.out.println("                Bem-vindo ao Quiz!");
        System.out.println("     Responda às perguntas selecionando a opção correta.");
        System.out.println("        As opções de resposta são: A, B, C, D e E.");
        System.out.println("=======================================================");
    }

    private static void exibirMensagemFinal(int acertos, int erros, List<Integer> questoesErradas) {
        int totalQuestoes = 15;
        double porcentagemAcertos = (double) acertos / totalQuestoes * 100;
        double porcentagemErros = (double) erros / totalQuestoes * 100;

        System.out.println("=======================================================");
        System.out.println("Fim do Quiz! Parabéns... Você acertou: " + acertos + " de " + totalQuestoes + " questões.");
        System.out.println("Você errou: " + erros + " questões.");
        System.out.println("Porcentagem de acertos: " + String.format("%.2f", porcentagemAcertos) + "%");
        System.out.println("Porcentagem de erros: " + String.format("%.2f", porcentagemErros) + "%");

        if (erros > 0) {
            System.out.println("Questões erradas: " + questoesErradas);
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

    private static List<Questao> criarQuestoes() {
        List<Questao> questoes = new ArrayList<>();

        questoes.add(new Questao(1, "Qual é o maior planeta do sistema solar?",
                "A - Marte.", "B - Terra.", "C - Júpiter.", "D - Saturno.", "E - Urano.", "C"));
        questoes.add(new Questao(2, "Quem escreveu 'Dom Quixote'?",
                "A - Gabriel García Márquez.", "B - Miguel de Cervantes.", "C - William Shakespeare.",
                "D - Jorge Luis Borges.", "E - Ernest Hemingway.", "B"));
        questoes.add(new Questao(3, "Qual é o elemento químico com símbolo 'O'?",
                "A - Ouro.", "B - Oxigênio.", "C - Osmônio.", "D - Oxônio.", "E - Platina.", "B"));
        questoes.add(new Questao(4, "Em que ano o homem pisou na Lua pela primeira vez?",
                "A - 1965.", "B - 1969.", "C - 1972.", "D - 1975.", "E - 1980.", "B"));
        questoes.add(new Questao(5, "Qual é a capital da Austrália?",
                "A - Sydney.", "B - Melbourne.", "C - Canberra.", "D - Brisbane.", "E - Adelaide.", "C"));
        questoes.add(new Questao(6, "Qual é o maior oceano do mundo?",
                "A - Oceano Atlântico.", "B - Oceano Pacífico.", "C - Oceano Índico.", "D - Oceano Ártico.", "E - Oceano Antártico.", "B"));
        questoes.add(new Questao(7, "Quem pintou a Mona Lisa?",
                "A - Vincent van Gogh.", "B - Pablo Picasso.", "C - Leonardo da Vinci.", "D - Michelangelo.", "E - Rembrandt.", "C"));
        questoes.add(new Questao(8, "Qual é o continente mais populoso?",
                "A - África.", "B - Europa.", "C - Ásia.", "D - América do Norte.", "E - América do Sul.", "C"));
        questoes.add(new Questao(9, "Qual é a fórmula química da água?",
                "A - H2O.", "B - CO2.", "C - NaCl.", "D - CH4.", "E - O2.", "A"));
        questoes.add(new Questao(10, "Qual é o menor país do mundo em termos de área?",
                "A - Mônaco.", "B - Nauru.", "C - San Marino.", "D - Vaticano.", "E - Liechtenstein.", "D"));
        questoes.add(new Questao(11, "Qual é o planeta mais próximo do Sol?",
                "A - Vênus.", "B - Terra.", "C - Marte.", "D - Mercúrio.", "E - Netuno.", "D"));
        questoes.add(new Questao(12, "Qual é o maior deserto do mundo?",
                "A - Deserto do Saara.", "B - Deserto de Gobi.", "C - Deserto de Kalahari.", "D - Deserto da Antártica.", "E - Deserto de Atacama.", "D"));
        questoes.add(new Questao(13, "Quem foi o primeiro presidente dos Estados Unidos?",
                "A - George Washington.", "B - Abraham Lincoln.", "C - Thomas Jefferson.", "D - John Adams.", "E - James Madison.", "A"));
        questoes.add(new Questao(14, "Qual é o símbolo químico do ferro?",
                "A - Fe.", "B - F.", "C - Ir.", "D - Fr.", "E - Fl.", "A"));
        questoes.add(new Questao(15, "Qual é o nome do maior animal terrestre?",
                "A - Elefante africano.", "B - Girafa.", "C - Baleia azul.", "D - Rinoceronte.", "E - Hipopótamo.", "A"));

        return questoes;
    }
}
