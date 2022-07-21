public class WordPair implements Comparable<WordPair> {
	public String word;
	public String wordMeanings;
	public WordPair next;
	
	
	public WordPair(String word, String meaning) {
		this.word = word;
		this.wordMeanings = meaning;
	}
	
	@Override
	public int compareTo(WordPair o) {
		return this.word.compareToIgnoreCase(o.word);
	}
	
	
	
	
	

}
