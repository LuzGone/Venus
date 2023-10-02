import java.util.Random;

public class Sueca extends DeckOfCardsTemplate {
    private String trunfo;
    
    // chamando construtor da classe DeckOfCardsTemplate
    public Sueca() {
        super();
    }

    // Inicializa o baralho de Sueca, removendo as cartas 8, 9 e 10 de todos os naipes
    @Override
    protected void initializeDeck() {
    
        for (int i = 0; i < 4; i++) {
            for (int value = 1; value <= 13; value++) {
                if (value != 8 && value != 9 && value != 10) {
                    deck.add(new Card(getFace(value), getSuit(i), value));
                }
            }
        }

        // Escolhendo o trunfo
        Random random = new Random();
        int randomIndex = random.nextInt(4);
        trunfo = getSuit(randomIndex);
    }

    //falta
    private String getSuit(int i) {
        return null;
    }
    
    //falta
    private String getFace(int value) {
        return null;
    }

    @Override
    protected void dealCards() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(deck.size());
            deck.remove(randomIndex);
        }
    }

    //falta
    @Override
    protected void playSpecificGame() {
        
    }

    public String getTrunfo() {
        return trunfo;
    }
}
