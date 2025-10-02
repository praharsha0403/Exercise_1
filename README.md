## So I’m relatively new to Java
### First, this is the structure of the code I thought of 
- Reading the text files..that I have given, Pride and prejudice, and the stopwords file 
- nThen we do some fine-tuning along like making all the words to lowercase so that it won’t have issues comparing, and also through an error, i have learnt that I should only be considering the words with 2 or more letters so that a or I won’t be counted 
- So my code checks out these statements one if it has stop words, and if the sentence does not…that will be added to the count…if it’s the same word that has been encountered before, it adds one, and if not, it creates a new word count 
- As mentioned in the given output, I have noticed that words with the highest count were placed at the top…it took some figuring out on how to sort that…and I discovered that sort() in which I created a custom way to compare tw enties and compare two word cound pairs…the using the getValue()…it arranges that words in decending order…
> This was the basic brainstorming session 

## The file names are as folllows 
```
Main.java
stop_words.txt
pride-and-prejudice.txt
```

Now the code 
- I imported all the required modules: `java.io` to read and write files, and `java.nio.file` to read the entire file. I thought using `Files.readAllBytes()` would be a good option, for which `I imported java.nio.file.*`
> For using the HashMap, I imported `java.util.*`
> To compare and match patterns, I imported `java.util.regex.*`
- Then I wrote the code to solve the problems that I had brainstormed.
> `Files.readAllBytes()` reads all the bytes from the file, `Paths.get(stopWordsFile)` converts the string path into a Path object, and new String(...) converts those bytes into readable text.

> `.toLowerCase()` makes everything lowercase (so "The" and "the" are treated as the same), and `.split(",")` cuts the string at every comma.
I used the HashMap concept to first create an empty set to hold stop words, so that all the stop words can be stored there.
- To read the entire Pride and Prejudice text file, in order to read all the bytes, same logic as used for stopwords I first had to convert it into a path using `Paths.get(args[0])`.
Now, to compare and match patterns, I first converted all the letters into lowercase so that "Darcy" and "darcy" would not be treated as different words. Then I created a word-finding pattern where I used ` [a-z]{2,}`, meaning that all lowercase letters and words with 2 or more letters would be considered. 
- Then I used the matcher because the Matcher actually does the searching—it goes through the text finding all words.
> To create a counting notebook, I used the HashMap. Here, I used `Map<String, Integer>` so that words could be counted accordingly.I used a while loop with the pattern matcher to check each and every word.
- Now, to actually store the words that the matcher found, I used `group()` to group all the matched words, and if it encounters any stop words, it will skip them as I have used `‘ continue; ‘`
- If any word has already been encountered before, it gets the word and adds 1 to that particular word's count.
> If it's the first time seeing a word, it starts counting from one.
- Now, to make a list of these groups, `wordCounts.entrySet()` gets all the word-count pairs, and new `ArrayList<>(...)` puts them in a list.
> To sort words by their count, I used `sortedWords.sort()` to compare two entries using `new Comparator<...>()`, and to get descending order, I used `b-a`.

### Then finally, I printed out the top 25 words. To stop at 25, I used `i<25` in the for loop.
