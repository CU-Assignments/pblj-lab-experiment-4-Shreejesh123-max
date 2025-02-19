import java.util.*;

class Card {
    String value;
    String suit;

    
    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    
    @Override
    public String toString() {
        return value + " of " + suit;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value.equals(card.value) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }
}

class CardCollection {
    private Set<Card> cardSet;
    private Map<String, List<Card>> suitMap; 
    
    public CardCollection() {
        cardSet = new HashSet<>();
        suitMap = new HashMap<>();
    }

    
    public void addCard(Card card) {
        if (cardSet.contains(card)) {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        } else {
            cardSet.add(card);
            suitMap.computeIfAbsent(card.suit, k -> new ArrayList<>()).add(card);
            System.out.println("Card added: " + card);
        }
    }

    
    public void findCardsBySuit(String suit) {
        if (suitMap.containsKey(suit)) {
            List<Card> cards = suitMap.get(suit);
            for (Card card : cards) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    
    public void displayAllCards() {
        if (cardSet.isEmpty()) {
            System.out.println("No cards found.");
        } else {
            for (Card card : cardSet) {
                System.out.println(card);
            }
        }
    }

    
    public void removeCard(Card card) {
        if (cardSet.contains(card)) {
            cardSet.remove(card);
            suitMap.get(card.suit).remove(card);
            System.out.println("Card removed: " + card);
        } else {
            System.out.println("Error: Card \"" + card + "\" does not exist.");
        }
    }
}

public class CardCollectionSystem {

    public static void main(String[] args) {
        CardCollection cardCollection = new CardCollection();

       
        System.out.println("Test Case 1: No Cards Initially");
        cardCollection.displayAllCards();

       
        System.out.println("\nTest Case 2: Adding Cards");
        cardCollection.addCard(new Card("Ace", "Spades"));
        cardCollection.addCard(new Card("King", "Hearts"));
        cardCollection.addCard(new Card("10", "Diamonds"));
        cardCollection.addCard(new Card("5", "Clubs"));

        
        System.out.println("\nTest Case 3: Finding Cards by Suit");
        cardCollection.findCardsBySuit("Hearts"); 

       
        System.out.println("\nTest Case 4: Searching Suit with No Cards");
        cardCollection.findCardsBySuit("Diamonds"); 

        
        System.out.println("\nTest Case 5: Displaying All Cards");
        cardCollection.displayAllCards(); 

        
        System.out.println("\nTest Case 6: Preventing Duplicate Cards");
        cardCollection.addCard(new Card("King", "Hearts")); 

        
        System.out.println("\nTest Case 7: Removing a Card");
        cardCollection.removeCard(new Card("10", "Diamonds")); 
        cardCollection.displayAllCards();
    }
}



//output

Test Case 1: No Cards Initially
No cards found.

Test Case 2: Adding Cards
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
King of Hearts

Test Case 4: Searching Suit with No Cards
10 of Diamonds

Test Case 5: Displaying All Cards
Ace of Spades
10 of Diamonds
5 of Clubs
King of Hearts

Test Case 6: Preventing Duplicate Cards
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Card removed: 10 of Diamonds
Ace of Spades
5 of Clubs
King of Hearts
