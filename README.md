# Dictionary-Data-Structure

Each line of a text-file dictionary.txt contains a unique word followed by the meaning or meanings of that word. Each word is a one-word string, the meaning or meanings of a word can be a string of one or more words and it may contain punctuation characters. The dictionary is case-insensitive. 

Write a Java program that implements a dictionary by reading, each time the program starts, the text-file and initializing an efficient data structure with the words and their meanings. After the initialization all dictionary operations must be performed on the data structure and not on the text-file. Before your program exits, it must update the text-file if the dictionary has been modified in the data structure. This means your dictionary must be persistent.
Your data structure must support the following operations that are implemented as a menu driven console program: 

method	description:

public boolean isEmpty(): returns true if the dictionary is empty, false otherwise.

public int getSize(): returns and displays how many words are currently stored in the dictionary.

public boolean insert (WordPair wordpair): inserts word pair into dictionary if not already present. Returns true if the insertion is successful; otherwise, it returns false if the word exists in the dictionary.

public WordPair find(String word): returns and displays a WordPair if the word is present; otherwise, it returns null and displays the message: "Word not in dictionary".

public boolean delete(String word): deletes the wordPair associated with word if the word exists. It returns true if the word exists; otherwise it returns false.

public boolean modifyWord(String word, String newMeanings): modifies a word to a new meaning, if the word exists in the dictionary. Returns true if the word exits; false otherwise.

public void printAll(String suffix): prints all words that start with suffix, together with their meanings. Prints the message: "No word starts with this suffix" if no such word exists.  
public void printSorted():	prints the words in the data structure together with their meanings in lexicographic order.

 Your program must use the menu shown below. It must run in a continuous loop until the option 7 is chosen:

1.	Insert a new word with its meanings
2.	Search for a word
3.	Delete a word and its meanings
4.	Modify the meanings of a word
5.	Print all words with a given suffix and their meanings
6.	Print the contents of the dictionary sorted in lexicographic order
7.	Exit

Provide appropriate required behaviour for each of the above options.

