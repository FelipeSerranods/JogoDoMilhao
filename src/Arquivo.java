import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Arquivo {
    public static ArrayList<Pergunta> lerArquivo(String quests) {
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(quests));
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                if (dados.length != 6) {
                    System.out.println("Linha inválida: " + linha);
                } else {
                    String enunciado = dados[0];
                    String[] opcoes = new String[4];
                    for (int i = 1; i <= 4; i++) {
                        opcoes[i-1] = dados[i];
                    }
                    String respostaCorreta = dados[5];
                    Pergunta pergunta = new Pergunta(enunciado, opcoes, respostaCorreta);
                    perguntas.add(pergunta);
                }
                linha = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return perguntas;
    }
}
