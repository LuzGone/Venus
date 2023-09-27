public class BaralhoTest {
    public static void main(String[] args){
        Baralho meuBaralho = new Baralho();
        meuBaralho.shuffle(); // coloca Cards em ordem aleat�ria
    
        
        // imprime todas as 52 cartas na ordem em que elas s�o distribu�das
        System.out.println( "Meu Baralho Size: " + meuBaralho.size());
        System.out.println( meuBaralho);

        System.out.println( "Criando Clone do Meu Baralho:");
        Baralho meuNovoBaralho = (Baralho) meuBaralho.clone();
        System.out.println( "Meu Novo Baralho Size: " + meuNovoBaralho.size());

        System.out.println( "Removendo 26 cartas a partir do topo do Meu baralho: ");
        
        for ( int i = 0; i < 26; i++ )
        {
            System.out.printf( "%-20s\n",meuBaralho.dealCard());
        } // for final
        System.out.println( "Meu Baralho Size: " + meuBaralho.size());
        System.out.println( "Meu Novo Baralho Size: " + meuNovoBaralho.size());
    }
}
