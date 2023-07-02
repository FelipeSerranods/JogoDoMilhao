public class Menus{
    public static void telaInicial(){
        System.out.println("Jogo de Quiz");
        System.out.println("- - - - - - - - - - ");
        System.out.println("1 - Iniciar Jogo");
        System.out.println("2 - Ranking"); // Mostra o Usuario que conseguiu chegar mais longe
        System.out.println("3 - Regras");
        System.out.println("4 - Sair");
        System.out.println();
        System.out.print("Selecione uma opção: ");
    }
    public static void telaRegras(){
        System.out.println();
        System.out.println("Regras do Jogo");
        System.out.println("- - - - - - - - - - - ");
        System.out.println(" - O jogo consiste em 10 perguntas, que valem um prêmio máximo de um milhão de reais.");
        System.out.println(" - Cada pergunta vale cem mil reais.");
        System.out.println(" - A última pergunta vale um milhão de reais e é chamada de 'arrisca tudo'.");
        System.out.println(" - Se o participante errar uma pergunta ele ganha metade do valor obtido até o momento.");
        System.out.println(" - Se o participante acertar todas as perguntas, ele ganha o prêmio de um milhão de reais.");
    }
}