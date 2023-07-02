import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcaoOperacional = 0;

        // Cria um ArrayList de objetos Jogador
        ArrayList<Jogador> jogadores = new ArrayList<>();

        while (opcaoOperacional != 4) {
            Menus.telaInicial();
            opcaoOperacional = Integer.parseInt(input.nextLine());
            switch (opcaoOperacional) {
                case 1:
                    System.out.println("Pergunta");
                    Pergunta[] perguntas = {
                            new Pergunta("Qual é a capital do Brasil?", new String[]{"a) São Paulo", "b) Rio de Janeiro", "c) Brasília", "d) Salvador"}, "c"),
                            new Pergunta("Qual é o maior planeta do Sistema Solar?", new String[]{"a) Marte", "b) Júpiter", "c) Saturno", "d) Terra"}, "b"),
                            new Pergunta("Qual é o elemento químico com símbolo H?", new String[]{"a) Hélio", "b) Hidrogênio", "c) Oxigênio", "d) Carbono"}, "b"),
                            new Pergunta("Qual é a capital da Austrália?", new String[]{"a) Sydney","b) Melbourne","c) Canberra","d) Perth"}, "c" ),
                            new Pergunta("Quem escreveu o livro O Pequeno Príncipe?", new String[]{"a) Antoine de Saint-Exupéry","b) Júlio Verne","c) Lewis Carroll","d) Ernest Hemingway"}, "a" ),
                            new Pergunta("Qual é o nome do maior osso do corpo humano?", new String[]{"a) Fêmur","b) Tíbia","c) Úmero","d) Esterno"}, "a" ),
                            new Pergunta("Qual é o nome do rio que corta a cidade de Paris?", new String[]{"a) Sena","b) Tâmisa","c) Reno","d) Danúbio"}, "a" ),
                            new Pergunta("Qual é o nome do instrumento musical de cordas que tem a forma de um triângulo?", new String[]{"a) Violino","b) Harpa","c) Bandolim","d) Cítara"}, "b" ),
                            new Pergunta("Qual é o nome do maior deserto do mundo?", new String[]{"a) Gobi","b) Atacama","c) Kalahari","d) Saara"}, "d" ),
                            new Pergunta("Qual foi a empresa responsável por levar turistas para conhecer o Titanic por 250 mil dólares?", new String[]{"a) Blue Origin","b) OceanGate Expeditions","c) Turismo Titanic","d) Virgin Galactic"}, "b" )
                    };

                    int pontuacao = 0;
                    int contador = 1;

                    // Pede o nome do jogador
                    System.out.println("Digite o seu nome para estar participando do Quiz: ");
                    String nome = input.nextLine();

                    for (Pergunta pergunta : perguntas) {
                        System.out.println("\nPergunta " + contador + "/10");
                        System.out.println(pergunta.getEnunciado());
                        pergunta.exibirOpcoes();

                        System.out.println("-------------------------------------");
                        System.out.println("Digite a sua Resposta: ");
                        String resposta = input.nextLine();

                        if (resposta.equalsIgnoreCase(pergunta.getRespostaCorreta())) {
                            System.out.println("Resposta correta! Você ganhou R$" + pergunta.getPontuacao() + " reais!");
                            pontuacao += pergunta.getPontuacao();
                        } else {
                            System.out.println("Resposta incorreta! Você perdeu...");
                            System.out.println("A resposta correta era a letra: " + pergunta.getRespostaCorreta());
                            System.out.println();
                            //Como dito nas regras, caso o jogador erre ele recebe apenas a metade do valor ganho
                            pontuacao = pontuacao / 2;
                            break;
                        }
                        contador++;
                    }
                    System.out.println("Fim do jogo! Sua pontuação final é: R$" + pontuacao);
                    System.out.println();

                    // Cria um novo Jogador e o add ao array com o nome e a pontuação
                    Jogador jogador = new Jogador(nome, pontuacao);
                    jogadores.add(jogador);

                    break;
                case 2:
                    Ranking ranking = new Ranking(jogadores);

                    // Verifica se o ArrayList de jogadores não está vazio
                    if (!jogadores.isEmpty()) {
                        ranking.exibirRanking();
                    } else {
                        System.out.println("Não há jogadores no ranking.");
                        System.out.println();
                    }
                    break;
                case 3:
                    Menus.telaRegras();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Saindo do game, Até a próxima....");
                    break;
                default:
                    System.out.println("[ERRO] Opção inválida! Tente novamente.");
                    System.out.println();
            }
        }
    }
}