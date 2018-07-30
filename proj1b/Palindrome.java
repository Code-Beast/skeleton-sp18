public class Palindrome {

    /**
     * Given a String, returns a Deque where the characters appear in the same order as in the String
     * @param word
     * @return
     */
	public Deque<Character> wordToDeque(String word) {
		ArrayDeque<Character> wordDeque = new ArrayDeque<>();
		for(int i = 0; i < word.length(); i ++) {
			wordDeque.addLast(word.charAt(i));
		}
		return wordDeque;
	}

    /**
     * Returns true if the given word is a palindrome, and false otherwise.
     * Any word of length 1 or 0 is a palindrome.
     * @param word
     * @return
     */
//    public boolean isPalindrome(String word) {
//        for(int i = 0; i < word.length() / 2; i ++) {
//            if(word.charAt(i) != word.charAt(word.length() - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isPalindrome(String word) {
        ArrayDeque<Character> wordDeque = (ArrayDeque<Character>) wordToDeque(word);
        for(int i = 0; i < word.length() / 2; i ++) {
            if(wordDeque.removeFirst() != wordDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the word is a palindrome according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        ArrayDeque<Character> wordDeque = (ArrayDeque<Character>) wordToDeque(word);
        for(int i = 0; i < word.length() / 2; i ++) {
            if(!cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}