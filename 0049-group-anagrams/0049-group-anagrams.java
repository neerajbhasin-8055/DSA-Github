class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String st : strs){
            int[] freq = new int[26];
            for(char ch :st.toCharArray()){
                freq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int f : freq){
                sb.append(f).append('#');
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                map.get(key).add(st);
            }else{
                map.put(key,new ArrayList<>());
                map.get(key).add(st);
            }
        }
        map.forEach((key,value)->{
            result.add(value);
        });
        return result;
    }
}
