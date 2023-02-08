package pl.javastart.voting;

import java.util.*;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();
        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        VotingResult votingResult = new VotingResult();
        for (String voter : voters) {
            String decision;
            do {
                System.out.println("Jak głosuje " + voter + "? (z - za, p - przeciw, w - wstrzymanie się)");
                String option = getOption(scanner);
                decision = option;
            } while (decision.equals(""));
            Vote vote = new Vote(voter, decision);
            votingResult.addVote(vote);
        }
        return votingResult;
    }

    private String getOption(Scanner scanner) {
        String option = scanner.nextLine().toLowerCase();
        switch (option) {
            case "z":
                return "za";
            case "p":
                return "przeciw";
            case "w":
                return "wstrzymał się";
            default:
                return "";
        }
    }
}
