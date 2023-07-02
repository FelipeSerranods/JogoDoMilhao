import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
class Ranking {
    private ArrayList<Jogador> jogadores;

    public Ranking(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    public void exibirRanking() {

        // Ordena em ordem decrescente
        Collections.sort(jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return j2.getPontuacao() - j1.getPontuacao();
            }
        });

        // Exibe o ranking usando um laço for
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println((i + 1) + " - " + jogadores.get(i).getNome() + " - R$" + jogadores.get(i).getPontuacao());
        }
        System.out.println();
    }

}
