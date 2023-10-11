import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class DeckOfCardsTemplate implements Prototype {
    
    protected List<Card> deck = new ArrayList<Card>();
    protected int NUMBER_OF_CARDS;
    protected Random randomNumbers;

    public DeckOfCardsTemplate() {
        this.randomNumbers = new Random();
        initializeDeck();
    }

    public DeckOfCardsTemplate(DeckOfCardsTemplate deck){
        for (Card carta : deck.deck){
            Card copiaCarta = new Card(carta.getFace(),carta.getSuit(),carta.getValue());
            this.deck.add(copiaCarta);
        }
        this.randomNumbers = deck.randomNumbers;
    }

    // Método abstrato implementado na subclasse
    public abstract void initializeDeck();


    public boolean hasCard() {
        return !deck.isEmpty();
    }

    public void shuffle() {
        for (int first = 0; first < deck.size(); first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck.remove(second);
            deck.add(0, temp);
        }
    }

    public Card dealCard() {
        if (hasCard()) {
            return deck.remove(deck.size() - 1);
        } else {
            return null; 
        }
    }

    public int size() {
        return deck.size();
    }

    public abstract Prototype clone();
}
