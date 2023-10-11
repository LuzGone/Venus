import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sueca extends DeckOfCardsTemplate {
    
    private String trunfo;
    
    //Ace = 11, Seven = 10, King = 4, Queen = 3, Jack = 2
    
    // chamando construtor da classe DeckOfCardsTemplate
    public Sueca() {
        super();
    }

    public Sueca(Sueca deck){
        this.deck = new ArrayList<Card>();
        for (Card carta : deck.deck){
            Card copiaCarta = new Card(carta.getFace(),carta.getSuit(),carta.getValue());
            this.deck.add(copiaCarta);
        }
        this.randomNumbers = deck.randomNumbers;
    }

    // Inicializa o baralho de Sueca, removendo as cartas 8, 9 e 10 de todos os naipes
    @Override
    public void initializeDeck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
    "Seven", "Jack", "Queen", "King" };
        
        this.trunfo = suits[this.randomNumbers.nextInt(4)];
        this.NUMBER_OF_CARDS = 40;

        for (String suit : suits){
            for (String face : faces){
                var value = 0;
                if(face == "Ace"){
                    value = 11;
                }
                if(face == "Seven"){
                    value = 10;
                }
                if(face == "King"){
                    value = 4;
                }
                if(face == "Queen"){
                    value = 3;
                }
                if(face == "Jack"){
                    value = 2;
                }
                this.deck.add(new Card(face,suit,value));
            }
        }
    }
    
    @Override
    public Prototype clone(){
        return new Sueca(this);
    }

    public String getTrunfo(){
        return this.trunfo;
    }

}
