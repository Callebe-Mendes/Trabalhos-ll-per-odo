// Classe interna para representar cada questão
public class Questao {
    final int numero;
    private final String questao;
    private final String opcaoA;
    private final String opcaoB;
    private final String opcaoC;
    private final String opcaoD;
    private final String opcaoE;
    private final String respostaCorreta;

    public Questao(int numero, String questao, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String respostaCorreta) {
        this.numero = numero;
        this.questao = questao;
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

    public void exibirQuestao() {
        System.out.println("Questão " + numero + ": " + questao);
        System.out.println("A - " + opcaoA);
        System.out.println("B - " + opcaoB);
        System.out.println("C - " + opcaoC);
        System.out.println("D - " + opcaoD);
        System.out.println("E - " + opcaoE);
        System.out.println();
    }
}

