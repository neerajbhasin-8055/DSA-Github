class GroupAnagram{

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for(int f:freq){
                sb.append(f).append('#');
            }
            String key = sb.toString(); // stored key as string because in java hashmap arrays cannot be stored because the arrays are reference type
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }
        }

        map.forEach((key,value)->{
            output.add(value);
        });
        return output;
    }
}

