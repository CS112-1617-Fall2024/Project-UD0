/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author ???
 * @version ???
 */

/*
 * UML CLASS DIAGRAM:
 * -------------------------------------------------------
 *   Card
 * -------------------------------------------------------
 * - value : int
 * - suit : char
 * + HEART : char			//static constant with value ♥
 * + DIAMOND : char			//static constant with value ♦
 * + CLUB : char			//static constant with value ♣
 * + SPADE : char			//static constant with value ♠
 * + DEFAULT_VALUE : int	//static constant with value 1
 * + DEFAULT_SUIT : char	//static constant with value ♥
 * -------------------------------------------------------
 * + Card()
 * + Card(value : int, suit : char)
 * + Card(original : Card)
 * + setValue(value : int) : boolean
 * + setSuit(suit : char) : boolean
 * + setAll(value : int, suit : char) : boolean
 * + getSuit() : char
 * + getValue() : int
 * + getPrintValue() : String
 * + getPrintCard() : String
 * + toString() : String
 * + equals(otherCard : Card) : boolean
 * + printCard() : void
 * -------------------------------------------------------
 */

public class Card {

    // Constants for suits and default values
    public static final char SPADE = 'S';
    public static final char HEART = 'H';
    public static final char DIAMOND = 'D';
    public static final char CLUB = 'C';
    public static final char DEFAULT_SUIT = SPADE;
    public static final int DEFAULT_VALUE = 1;

    // Instance variables
    private int value; // 1-13 (Ace to King)
    private char suit; // S, H, D, C

    // Default constructor
    public Card() {
        this.value = DEFAULT_VALUE;
        this.suit = DEFAULT_SUIT;
    }

    // Full constructor with validation
    public Card(int value, char suit) {
        if (!isValidValue(value) || !isValidSuit(suit)) {
            System.out.println("Invalid card parameters, shutting down program.");
            System.exit(1);
        }
        this.value = value;
        this.suit = suit;
    }

    // Copy constructor
    public Card(Card other) {
        if (other == null) {
            System.out.println("Null card passed to copy constructor, shutting down program.");
            System.exit(1);
        }
        this.value = other.value;
        this.suit = other.suit;
    }

    // Getters
    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    // Setters
    public boolean setValue(int value) {
        if (isValidValue(value)) {
            this.value = value;
            return true;
        }
        return false;
    }

    public boolean setSuit(char suit) {
        if (isValidSuit(suit)) {
            this.suit = suit;
            return true;
        }
        return false;
    }

    public boolean setAll(int value, char suit) {
        if (isValidValue(value) && isValidSuit(suit)) {
            this.value = value;
            this.suit = suit;
            return true;
        }
        return false;
    }

    // Utility methods 
    private boolean isValidValue(int value) {
        return value >= 1 && value <= 13;
    }

    private boolean isValidSuit(char suit) {
        return suit == SPADE || suit == HEART || suit == DIAMOND || suit == CLUB;
    }

    // Returns the card's printable value (A, 2-10, J, Q, K)
    public String getPrintValue() {
        switch (value) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(value);
        }
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "[" + getPrintValue() + " " + suit + "]";
    }

    // equals method to compare two Card objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.value == other.value && this.suit == other.suit;
    }

    // Main method 
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        int index = 0;

        // Populate the deck with all 52 cards
        for (char suit : new char[]{SPADE, HEART, DIAMOND, CLUB}) {
            for (int value = 1; value <= 13; value++) {
                deck[index++] = new Card(value, suit);
            }
        }

        // Print all cards 
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
