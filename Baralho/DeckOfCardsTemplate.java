import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class DeckOfCardsTemplate {
    protected List<Card> deck;
    protected final int NUMBER_OF_CARDS = 52;
    protected Random randomNumbers;

    public DeckOfCardsTemplate() {
        deck = new ArrayList<Card>();
        randomNumbers = new Random();

        initializeDeck();
        shuffle();
    }

    // Método abstrato implementado na subclasse
    protected abstract void initializeDeck();

    // Método abstrato implementado na subclasse
    protected abstract void dealCards();

    // Método abstrato implementado na subclasse
    protected abstract void playSpecificGame();

    public boolean hasCard() {
        return !deck.isEmpty();
    }

    public void shuffle() {
        for (int first = 0; first < deck.size(); first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
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

    public DeckOfCardsTemplate copy() {
        List<Card> deckCopy = new ArrayList<Card>();
        for (Card card : deck) {
            Card cardCopy = new Card(card.getFace(), card.getSuit(), card.getValue());
            deckCopy.add(cardCopy);
        }
        DeckOfCardsTemplate deckOfCardsCopy = createDeckWithCopy(deckCopy, this.randomNumbers);
        return deckOfCardsCopy;
    }

    // Método abstrato para criar uma instância da classe atual com o baralho copiado
    protected abstract DeckOfCardsTemplate createDeckWithCopy(List<Card> deckCopy, Random randomNumbers);
}