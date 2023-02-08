package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */

public class VotingResult {
    private static final String VOTE_FOR_PASSAGE = "za";
    private static final String VOTE_AGAIN = "przeciw";
    private static final String VOTE_ABSTENTION = "wstrzymał się";
    private static final int MULTIPLAYER = 100;
    private List<Vote> votes = new ArrayList<>();

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        double votesNumber = votes.size();
        double votesForPassage = countVotes(votes, VOTE_FOR_PASSAGE);
        double votesAgainst = countVotes(votes, VOTE_AGAIN);
        double votesAbstention = countVotes(votes, VOTE_ABSTENTION);

        System.out.printf("Głosów za: %.2f%%\n", (votesForPassage / votesNumber) * MULTIPLAYER);
        System.out.printf("Głosów przeciw: %.2f%%\n", (votesAgainst / votesNumber) * MULTIPLAYER);
        System.out.printf("Wstrzymało się: %.2f%%\n", (votesAbstention / votesNumber) * MULTIPLAYER);

        // metoda powinna drukować wyniki głosowania
    }

    private int countVotes(List<Vote> votes, String voteType) {
        int decision = 0;
        for (Vote vote : votes) {
            if (vote.getVote().equals(voteType)) {
                decision++;
            }
        }
        return decision;
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                System.out.println(vote.getVoter() + ": " + vote.getVote().toUpperCase());
            }
        }
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }
}
