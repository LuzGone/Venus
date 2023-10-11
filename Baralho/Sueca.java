import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sueca extends DeckOfCardsTemplate {
    
    private String trunfo;
    private String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
    private String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
    "Seven", "Jack", "Queen", "King" };
    
    //Ace = 11, Seven = 10, King = 4, Queen = 3, Jack = 2
    
    // chamando construtor da classe DeckOfCardsTemplate
    public Sueca() {
        super();
    }

    // Inicializa o baralho de Sueca, removendo as cartas 8, 9 e 10 de todos os naipes
    @Override
    public void initializeDeck() {
        int randomIndex = this.randomNumbers.nextInt(4);
        this.trunfo = suits[randomIndex];
        this.NUMBER_OF_CARDS = 40;
    }

}
