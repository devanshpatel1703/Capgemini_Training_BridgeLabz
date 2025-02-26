import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.*;
import java.util.*;

class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;

    public IPLMatch(int match_id, String team1, String team2, int score1, int score2, String winner,
            String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score = new HashMap<>();
        this.score.put(team1, score1);
        this.score.put(team2, score2);
        this.winner = winner;
        this.player_of_match = player_of_match;
    }

    public IPLMatch() {
    }
}

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            List<IPLMatch> matches = readJson("src/main/java/iplData.json");
            matches = applyCensorship(matches);
            writeJson(matches, "src/main/java/censoredIplData.json");

            List<IPLMatch> csvMatches = readCsv("src/main/java/iplData.csv");
            csvMatches = applyCensorship(csvMatches);
            writeCsv(csvMatches, "src/main/java/censoredIplData.csv");

            System.out.println("Data processing complete. Censored files generated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<IPLMatch> readJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class);
        return objectMapper.readValue(new File(filePath), listType);
    }

    public static void writeJson(List<IPLMatch> matches, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }

    public static List<IPLMatch> readCsv(String filePath) throws IOException {
        List<IPLMatch> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(",");
                matches.add(new IPLMatch(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4]),
                        values[5],
                        values[6]));
            }
        }
        return matches;
    }

    public static void writeCsv(List<IPLMatch> matches, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing header
            writer.write("match_id,team1,team2,score_team1,score_team2,winner,player_of_match\n");

            for (IPLMatch match : matches) {
                writer.write(match.match_id + "," +
                        match.team1 + "," +
                        match.team2 + "," +
                        match.score.get(match.team1) + "," +
                        match.score.get(match.team2) + "," +
                        match.winner + "," +
                        match.player_of_match + "\n");
            }
        }
    }

    public static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.team1 = maskTeamName(match.team1);
            match.team2 = maskTeamName(match.team2);
            match.winner = maskTeamName(match.winner);
            match.player_of_match = "REDACTED";
        }
        return matches;
    }

    public static String maskTeamName(String team) {
        int spaceIndex = team.indexOf(" ");
        return (spaceIndex != -1) ? team.substring(0, spaceIndex) + " ***" : team;
    }
}