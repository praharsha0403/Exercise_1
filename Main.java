import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        if (args.length < 1) {
            System.out.println("Usage: java WordFrequency </Users/nelaturipraharsha/Desktop/Excercise 1/pride-and-prejudice.txt>");
            return;
        }
        
        
        String stopWordsFile = "/Users/nelaturipraharsha/Desktop/Excercise 1/stop_words.txt";
        String stopWordsContent = new String(Files.readAllBytes(Paths.get(stopWordsFile)));
        String[] stopWordsArray = stopWordsContent.toLowerCase().split(",");
        
        Set<String> stopwords = new HashSet<>();
        for (String word : stopWordsArray) {
            stopwords.add(word);
        }
        
        
        String text = new String(Files.readAllBytes(Paths.get(args[0])));
        text = text.toLowerCase();
        
        
        Pattern pattern = Pattern.compile("[a-z]{2,}");
        Matcher matcher = pattern.matcher(text);
        
        Map<String, Integer> wordCounts = new HashMap<>();
        
        while (matcher.find()) {
            String word = matcher.group();
            
            
            if (stopwords.contains(word)) {
                continue;
            }
            
            
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        
        
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCounts.entrySet());
        
        
        sortedWords.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        
        
        System.out.println("25 most frequent words:");
        for (int i = 0; i < 25 && i < sortedWords.size(); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}