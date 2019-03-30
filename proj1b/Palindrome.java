public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> L = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }
        return L;
    }
    public boolean isPalindrome(String word){
        int n = word.length();
        if(n>1){
            Deque<Character> L = new LinkedListDeque<Character>();
            L = wordToDeque(word);
            for (int i = 0; i < n/2; i++){
                if(L.removeFirst() != L.removeLast()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        int n = word.length();
        if (n>1){
            for (int i=0; i < n/2; i++){
                if(!cc.equalChars(word.charAt(i),word.charAt(n-1-i))){
                    return false;
                }
            }
        }
        return true;
    }
}
