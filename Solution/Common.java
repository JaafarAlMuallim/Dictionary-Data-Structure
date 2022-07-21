import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Common {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DictList myList = readFile();
		menu();
		
		while(true) {
			switch(input.nextInt()) {
			
			case 1:   // Insert new word with meaning
				System.out.print("Enter the word and meaning: ");
				String word = input.next();
				String meaning = input.nextLine();
				if(myList.insert(new WordPair(word,meaning)))
					System.out.println("\nDone");
				else System.out.println("Could not insert the word " + word +" ,if you want to change the meaning, choose option 4\n" );
				menu();
				break;
			
			case 2:    // Search word
				System.out.print("Enter The Word to be found: ");
				word = input.next();
				if(myList.find(word) == null) {
					System.out.println("\nNo Such word in the dictionary\n");
				} else
					System.out.println("\n"+word + "" + myList.find(word).wordMeanings + "\n");
				menu();
				break;
				
			case 3: // Delete word and meaning
				System.out.print("Enter the word to be deleted: ");
				word = input.next();
				if(myList.delete(word))
					System.out.println("\nWord " + word +" has been deleted\n");
				else
					System.out.println("\nNo Such word in the dicitionary\n");
				menu();
				break;
					
			case 4:     // Modify meaning of word
				System.out.print("Enter the word to be modified and the new meaning: ");
				word = input.next();
				meaning = input.nextLine();
				if(myList.modifyWord(word, meaning))
					System.out.println("Word " + word + " has been modified");
				menu();
				break;
				
			case 5:         // Print with given suffix
				System.out.print("Enter the prefix: ");
				String prefix = input.next();
				myList.printAll(prefix);
				menu();
				break;
				
			case 6:         // Print sorted
				myList.printSorted();
				menu();
				break;
				
			case 7:      // Exit
				input.close();
				try {
					PrintWriter outfile = new PrintWriter("res\\dictionary.txt");
					WordPair tmp = myList.start;
					while(tmp != null) {
						outfile.println(tmp.word + "" + tmp.wordMeanings);
						tmp = tmp.next;
					}
					System.out.println("Saved");
					outfile.close();
			} catch(FileNotFoundException ex){
				System.out.println("Error");
			}
				return;
			default:
				System.out.println("No Such Option");
			}
				
		}
		
		
	}
	
	public static void menu() {
		System.out.print("1. Insert a new word with its meaning.\n2. Search for a word."
				+ "\n3. Delete a word and its meanings.\n4. Modify the meanings of a word."
				+ "\n5. Print all words with a given prefix and their meanings.\n"
				+ "6. Print all contents of the dictionary sorted in lexicographic order."
				+ "\n7. Exit.\n");
		System.out.print("Choice: ");
	}
	
	public static DictList readFile() {
		
		String fileName = "res\\dictionary.txt";
		File file = new File(fileName);
		Scanner infile;
		DictList list = new DictList();
		try {
			infile = new Scanner(file);
			while(infile.hasNext()) {
				String word = infile.next();
				String wordMeaning = infile.nextLine();
				list.insert(new WordPair(word, wordMeaning));
			}
			infile.close();	
		} catch(FileNotFoundException ex) {
			System.out.println("File is Not Found");
		}
		return list;
	}
	
}