public class SuecaTest {
    public static void main(String[] args) {
        Sueca sueca = new Sueca();

        // Embaralha o baralho
        sueca.shuffle();

        // Imprime todas as cartas no baralho na ordem em que são distribuídas
        System.out.println("Baralho Size: " + sueca.size());
        System.out.println(sueca);

        // Cria uma cópia do baralho
        System.out.println("Criando Clone do Baralho de Sueca:");
        Sueca novoSueca = (Sueca) sueca.clone();
        System.out.println("Novo Baralho de Sueca Size: " + novoSueca.size());

        // Distribui 10 cartas a partir do topo do baralho
        System.out.println("Distribuindo 10 cartas a partir do topo do Baralho: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-20s\n", sueca.dealCard());
        }

        System.out.println("Baralho Size: " + sueca.size());
        System.out.println("Novo Baralho Size: " + novoSueca.size());
        System.out.println(novoSueca);
    }
}

