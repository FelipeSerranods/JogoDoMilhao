public class Pergunta {
    private String enunciado;
    private String[] opcoes;
    private String respostaCorreta;
    private int pontuacao;

    public Pergunta(String enunciado, String[] opcoes, String respostaCorreta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.pontuacao = 100000;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void exibirOpcoes() {
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
    }
}