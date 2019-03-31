import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TryPriorityQueue {
    public static void topWords(String[] words, int k){
        Map<String, Integer> counts = new HashMap<>();
        for(String word: words){
            if(!counts.containsKey(word)){
                counts.put(word, 1);
            } else{
                counts.put(word, counts.get(word) + 1);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return counts.get(o2) - counts.get(o1);
            }
        });
        for(String word: counts.keySet()){
            pq.add(word);
        }
        for(int i=0; i < k; i++){
            System.out.println(pq.poll());
        }
    }

    public static void main(String[] args){
        String[] words = new String[]{"i", "am", "a", "i", "i", "a"};
        topWords(words, 3);
    }
}

