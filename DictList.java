public class DictList {
	private int size;

	protected WordPair start, end;

	public DictList() {
		start = end = null;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public int getSize() {
		return size;
	}

	public boolean insert(WordPair wordpair) {
		if (isEmpty() || start.compareTo(wordpair) > 0) {
			wordpair.next = start;
			start = wordpair;
			size++;
			return true;
		} else {
			if (start.compareTo(wordpair) == 0) {
				System.out.println("\n" + wordpair.word + " already exists");
				return false;
			}
			WordPair tmp = start;
			while (tmp.next != null && tmp.next.compareTo(wordpair) < 0) {
				tmp = tmp.next;
			}
			if (tmp.next != null && tmp.next.compareTo(wordpair) == 0) {
				System.out.println("\n" + wordpair.word + " already exists");
				return false;
			}
			if (tmp.next == null) {
				tmp.next = wordpair;
				wordpair.next = null;
				end = wordpair;
				size++;
				return true;
			} else {
				wordpair.next = tmp.next;
				tmp.next = wordpair;
				size++;
				return true;
			}
		}
	}

	public WordPair find(String word) {
		if (isEmpty())
			return null;
		WordPair tmp = start;
		while (tmp.next != null) {
			if (tmp.word.compareToIgnoreCase(word) == 0) {
				return tmp;
			} else {
				tmp = tmp.next;
			}

		}
		return null;
	}

	public boolean delete(String word) {
		if (isEmpty()) {
			return false;
		}
		if (start == end && word.equals(start.word)) {
			start = end = null;
			size = 0;
			return true;
		} else if (word.equals(start.word)) {
			start = start.next;
			size--;
			return true;
		} else {
			WordPair pred, tmp;
			for (pred = start, tmp = start.next; tmp != null
					&& !tmp.word.equals(word); pred = pred.next, tmp = tmp.next)
				;
			if (tmp != null) {
				pred.next = tmp.next;
				if (tmp == end)
					end = pred;
				size--;
				return true;
			}
		}
		return false;
	}

	public boolean modifyWord(String word, String newMeaning) {
		if (isEmpty()) {
			System.out.println("No Elements in the dictionary");
			return false;
		}
		WordPair tmp = start;
		while (tmp.next != null) {
			if (tmp.word.compareToIgnoreCase(word) == 0) {
				tmp.wordMeanings = newMeaning;
				return true;
			}
			tmp = tmp.next;
		}
		System.out.println("Word not found!");
		return false;
	}

	public void printAll(String prefix) {
		if (isEmpty()) {
			System.out.println("No Elements in the dictionary");
			return;
		}
		String words = "";
		WordPair tmp = start;
		while (tmp != null) {
			if (tmp.word.startsWith(prefix)) {
				words += tmp.word + tmp.wordMeanings + "\n";
			}
			tmp = tmp.next;
		}
		if (words.equals(""))
			System.out.println("No word starts with this prefix");
		else
			System.out.println("\n" + words);

		return;
	}

	public void printSorted() {
		if (isEmpty()) {
			System.out.println("No Elements in the dictionary");
			return;
		}
		String words = "";
		WordPair tmp = start;
		while (tmp != null) {
			words += tmp.word + tmp.wordMeanings + "\n";
			tmp = tmp.next;
		}
		System.out.println("\n" + words + "\n");
		return;
	}
}
