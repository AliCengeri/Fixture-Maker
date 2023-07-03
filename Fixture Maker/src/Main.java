import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<String> teams = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String team = input.next();
            teams.add(team);
        }
        if (teams.size() % 2 == 1) {
            teams.add("Bay");
        }

        List<List<String>> matches = new ArrayList<>();

        for (int i = 0; i < teams.size() - 1; i++) {
            List<String> homeTeam = new ArrayList<>();
            List<String> awayTeam = new ArrayList<>();
            for (int j = 0; j < teams.size() / 2; j++) {
                homeTeam.add(teams.get(j));
                awayTeam.add(teams.get(teams.size() - 1 - j));
            }
            matches.add(homeTeam);
            matches.add(awayTeam);

            String lastTeam = teams.remove(teams.size() - 1);
            teams.add(1, lastTeam);
        }
        
        int rnCt = 1;
        for (int i = 0; i < matches.size(); i++) {
            System.out.println("\n" + "Round " + rnCt);
            for (int j = 0; j < matches.get(i).size(); j++) {
                System.out.print(matches.get(i).get(j) + " vs " + matches.get(i + 1).get(j) + "\t");
            }
            System.out.println();
            rnCt++;
            i++;
        }

        for (int i = matches.size() - 1; i >= 0; i--) {
            System.out.println("\n" + "Round " + rnCt);
            for (int j = matches.get(i).size() - 1; j >= 0; j--) {
                System.out.print(matches.get(i).get(j) + " vs " + matches.get(i - 1).get(j) + "\t");
            }
            System.out.println();
            rnCt++;
            i--;
        }
    }
}
