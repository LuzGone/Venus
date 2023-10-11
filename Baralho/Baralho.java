import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho implements Prototype{
    private List<Card> baralho; // ArrayList usado como uma pilha de objetos
    private final int NUMERO_DE_CARTAS = 52; // n�mero constante de Cards
    private Random numerosAleatorios; // gerador de n�mero aleat�rio

    // construtor preenche baralho de cartas
    public Baralho()
    {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };    
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };     

        this.baralho = new ArrayList<Card>(); // cria List de objetos Card
        numerosAleatorios = new Random(); // cria gerador de n�mero aleat�rio

        // preenche baralho com objetos Card
        for ( int count = 0; count < NUMERO_DE_CARTAS; count++ )   {
            baralho.add(new Card( faces[ count % 13 ], suits[ count / 13 ], (count % 13)+1  ));
        }
    } // fim do construtor DeckOfCards

    public Baralho(Baralho baralho){
        for (Card carta : baralho.baralho){
            Card copiaCarta = new Card(carta.getFace(),carta.getSuit(),carta.getValue());
            this.baralho.add(copiaCarta);
        }
        this.numerosAleatorios = baralho.numerosAleatorios;
    }

    public boolean hasCard() {
        return baralho.size() > 0;
    }
    // embaralha as cartas com um algoritmo de uma passagem
    public void shuffle()
    {
        // depois de embaralhar, a distribui��o deve iniciar em deck[ 0 ] novamente


        // para cada Card, seleciona outro Card aleat�rio e os compara
        for ( int first = 0; first < baralho.size(); first++ )
        {
            // seleciona um n�mero aleat�rio entre 0 e 51
            int second =  numerosAleatorios.nextInt( NUMERO_DE_CARTAS );

            // compara Card atual com Card aleatoriamente selecionado
            Card temp = baralho.remove( second );     
            baralho.add(0, temp);
        } // for final
    } // fim do m�todo shuffle

    // distribui um Card, do topo do monte
    public Card dealCard()
    {
        return baralho.remove(baralho.size()-1); // retorna Card atual no array
    } // fim do m�todo dealCard
    
    
    public int size() {
        return baralho.size();
    }
    
    public String toString() {
        String s = "";
        for (Card card : baralho) {
            s += card.toString() + "\n";	
        }
        return s;
    }
    
    @Override
    public Prototype clone() {
        return new Baralho(this);
    }

}
