package codejam.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by oscar on 7/29/16.
 */
public class Combinations {

    private List<String> combinations = new ArrayList<>();
    private PriorityQueue<String> combinationsAlphabetical = new PriorityQueue<>();

    public List<String> getAllCombinations(String string) {
        boolean[] include = new boolean[string.length()];
        getAllCombinations(string, 0, include);
        return combinations;
    }

    private void getAllCombinations(String string, int index, boolean[] include) {
        if(index == string.length()){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<string.length(); i++) {
                if(include[i]) {
                    sb.append(string.charAt(i));
                }
            }
            combinations.add(sb.toString());
            combinationsAlphabetical.add(sb.toString());
        } else {
            include[index] = false;
            getAllCombinations(string, index + 1, include);
            include[index] = true;
            getAllCombinations(string, index + 1, include);
        }
    }

    public List<String> getCombinationsInAlphabeticalOrder(String string) {
        getAllCombinations(string);
        List<String> combinationsInAlphabeticalOrder = new ArrayList<>();
        while(!combinationsAlphabetical.isEmpty()){
            combinationsInAlphabeticalOrder.add(combinationsAlphabetical.poll());
        }
        return combinationsInAlphabeticalOrder;
    }
}
