import java.util.List;
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

    //Naipes 
    private String getSuit(int i) {
        switch (i) {
            case 0:
                return "Hearts";
            case 1:
                return "Diamonds";
            case 2:
                return "Clubs";
            case 3:
                return "Spades";
            default:
                return "";
        }
    }
    
    //Face da carta baseado no valor dela
    private String getFace(int value) {
        switch (value) {
            case 1:
                return "Ace";
            case 7:
                return "7";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(value);
        }
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

    //ver isso aqui
    @Override
    protected DeckOfCardsTemplate createDeckWithCopy(List<Card> deckCopy, Random randomNumbers) {
        return null;
    }
}
