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
                    // Chama o método lerArquivo da classe Arquivo, passando o nome do arquivo.txt que contém as perguntas
                    ArrayList<Pergunta> perguntas = Arquivo.lerArquivo("quests.txt");

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
                        String resposta = input.nextLine().toLowerCase();

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