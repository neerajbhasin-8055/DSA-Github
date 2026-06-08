import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class fruitBaskets{
    public int maxFruits(int[] fruits){
        Map<Integer,Integer> baskets = new  HashMap<>();

        int maxFruites = 0 ;
        int i = 0 ;
        for(int j =0 ; j < fruits.length ; j++){
            baskets.put(fruits[j], baskets.getOrDefault(fruits[j], 0)+1);
            while(baskets.size()> 2){
                baskets.put(fruits[i], baskets.getOrDefault(fruits[i],baskets.getOrDefault(fruits[i],0)-1));
                if(baskets.get(fruits[i]) == 0){
                    baskets.remove(fruits[i]);
                }
                i++;
            }
            maxFruites = Math.max(maxFruites, j-i+1);
        }
        return maxFruites;
    }
}