import java.util.HashSet;
import java.util.Set;

class fruitBaskets{
    public int maxFruits(int[] fruits){
        Set<Integer> visited = new HashSet<>();
        int baskets = 2 ;
        int currBaskets = 0 ;
        int maxFruites = 0 ;
        int i = 0 ;
        for(int j =0 ; j < fruits.length ; j++){
            visited.add(fruits[j]);
            currBaskets++;
            while(currBaskets > baskets){
                visited.remove(fruits[i]);
                i++;
                currBaskets --;
            }
            maxFruites = Math.max(maxFruites, j-i+1);
        }
        return maxFruites;
    }
}