package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

import static mst.euler.Lib.readFile;

public class s054 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s054().run());
    }

    @Override
    public String solve() {

        Long counter = 0L;
        List<String> fileContent = readFile("src/mst/euler/resources/p054_poker.txt");
        for (String l : fileContent) {
            Map<Integer, Hand> players = new HashMap<>();
            players.put(0, new Hand());
            players.put(1, new Hand());
            String[] cards = l.split(" ");
            for (int i = 0; i < cards.length; i++) {
                players.get(i / 5).addCard(cards[i]);
            }
            if (players.get(0).beats(players.get(1)))
                counter++;
        }
        return String.valueOf(counter);

//        Hand h;
//        h = new Hand();
//        h.addCard("2A").addCard("5B").addCard("7C").addCard("QD").addCard("TC");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("2A").addCard("2B").addCard("3C").addCard("4D").addCard("JC");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("AA").addCard("AB").addCard("TD").addCard("JD").addCard("TC");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("AA").addCard("AB").addCard("AD").addCard("JD").addCard("TC");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("AA").addCard("QB").addCard("KC").addCard("JD").addCard("TC");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("AA").addCard("2A").addCard("5A").addCard("JA").addCard("TA");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("3A").addCard("2A").addCard("2B").addCard("3B").addCard("3D");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("3A").addCard("3C").addCard("2B").addCard("3B").addCard("3D");
//        System.out.println(h);
//
//        h = new Hand();
//        h.addCard("3A").addCard("5A").addCard("6A").addCard("4A").addCard("7A");
//        System.out.println(h);

        }

        class Card {
            private char color;
            private char val;
            private int value;

            char getColor() {
                return color;
            }

            int getValue() {
                return value;
            }

            public String toString() {
                return "" + val + color;
            }

            Card(String s) {
                val = s.charAt(0);
                color = s.charAt(s.length() - 1);
                value = (val == 'T') ? 10 :
                        (val == 'J') ? 11 :
                                (val == 'Q') ? 12 :
                                        (val == 'K') ? 13 :
                                                (val == 'A') ? 14 :
                                                        Integer.parseInt("" + val);
            }

        }

        class Hand {
            List<Card> cards;
            private int rank;
            List<Integer> rankedValueCards;
            List<Integer> highValueCards;
            private int cardsInHand = 0;
            // 0(H) HighCard: Highest value card.
            // 1(1) OnePair: Two cards of the same value.
            // 2(2) TwoPairs: Two different pairs.
            // 3(1) ThreeOfAKind: Three cards of the same value.
            // 4(H) Straight: All cards are consecutive values.
            // 5(H) Flush: All cards of the same suit.
            // 6(1) FullHouse: Three of a kind and a pair.
            // 7(1) FourOfAKind: Four cards of the same value.
            // 9(1) Straight Flush: All cards are consecutive values of same suit.


            Hand() {
                cards = new ArrayList<>();
                rankedValueCards = new ArrayList<>();
                highValueCards = new ArrayList<>();
            }

            Hand addCard(Card c) {
                cards.add(c);
                cardsInHand++;
                if (cardsInHand == 5) eval();
                return this;
            }

            public String toString() {
                return "" + cards + " R:" + rank + rankedValueCards + " " + highValueCards;
            }

            boolean beats(Hand hand2) {
                if (rank == hand2.rank) {
                    for (int i = 0; i < rankedValueCards.size(); i++) {
                        if (rankedValueCards.get(i) - hand2.rankedValueCards.get(i) != 0)
                            return rankedValueCards.get(i) > hand2.rankedValueCards.get(i);
                    }
                    for (int i = 0; i < highValueCards.size(); i++) {
                        if (highValueCards.get(i) - hand2.highValueCards.get(i) != 0)
                            return highValueCards.get(i) > hand2.highValueCards.get(i);
                    }
                }

                return rank > hand2.rank;
            }

            private void eval() {
                rank = 0;
                Map<Integer, Integer> cardValuesCountMap = new HashMap<>();
                for (Card c : cards) {
                    if (cardValuesCountMap.containsKey(c.getValue())) {
                        cardValuesCountMap.put(c.getValue(), cardValuesCountMap.get(c.getValue()) + 1);
                    } else {
                        cardValuesCountMap.put(c.getValue(), 1);
                    }
                    highValueCards.add(c.getValue());
                }
                Collections.sort(highValueCards);
                Collections.reverse(highValueCards);

                if (cardValuesCountMap.containsValue(4)) {  //7 FourOfAKind
                    rank = 7;
                    for (int cardValue : cardValuesCountMap.keySet()) {
                        if (cardValuesCountMap.get(cardValue) == 4) rankedValueCards.add(cardValue);
                    }
                    return;
                }
                if (cardValuesCountMap.containsValue(3)) { //FullHouse or ThreeOfAKind
                    rank = (cardValuesCountMap.containsValue(2)) ? 6 : 3; //6 FullHouse or 3 ThreeOfAKind
                    for (int cardValue : cardValuesCountMap.keySet()) {
                        if (cardValuesCountMap.get(cardValue) == 3) rankedValueCards.add(cardValue);
                    }
                    return;
                }
                if (cardValuesCountMap.containsValue(2)) { //TwoPairs or OnePair
                    rank = (cardValuesCountMap.keySet().size() == 3) ? 2 : 1; //2 TwoPairs or 1 OnePair
                    for (int cardValue : cardValuesCountMap.keySet()) {
                        if (cardValuesCountMap.get(cardValue) == 2) rankedValueCards.add(cardValue);
                    }
                    Collections.sort(rankedValueCards);
                    Collections.reverse(rankedValueCards);
                    return;
                }
                boolean isStraight = true;
                for (int i = 1; i < highValueCards.size(); i++) {
                    isStraight &= highValueCards.get(i - 1) - highValueCards.get(i) == 1;
                }
                rank = isStraight ? 4 : 0; //4 Straight or 0 HighCard

                boolean isFlush = true;
                char color = cards.get(0).getColor();
                for (Card c : cards) {
                    isFlush &= c.getColor() == color;
                }

                rank += (isFlush) ? 5 : 0; //9 StraightFlush or 5 Flush or 0 HighCard
            }

            Hand addCard(String cardString) {
                addCard(new Card(cardString));
                return this;
            }
        }
    }
