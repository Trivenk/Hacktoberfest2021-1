class Solution {
    public boolean compare(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (char ch : map1.keySet()) {
            int f1 = map1.get(ch);

            if (map2.containsKey(ch) == false) {
                return false;
            }

            int f2 = map2.get(ch);

            if (f1 != f2) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<Integer>();
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        for (i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            int newF = map1.getOrDefault(ch, 0) + 1;
            map1.put(ch, newF);
        }

        for (i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            int newF = map2.getOrDefault(ch, 0) + 1;
            map2.put(ch, newF);
        }

        int j = 0;

        for (; i < s.length(); i++, j++) {
            if (compare(map1, map2) == true) {
                res.add(j);
            }

          
            char AcqChar = s.charAt(i);
            int newF = map2.getOrDefault(AcqChar, 0) + 1;
            map2.put(AcqChar, newF);

            
            char releaseChar = s.charAt(j);
            if (map2.get(releaseChar) == 1) {
                map2.remove(releaseChar);
            } else {
                int F = map2.get(releaseChar) - 1;
                map2.put(releaseChar, F);
            }
        }

        if (compare(map1, map2) == true) {
            res.add(j);
        }

        return res;
        
}
}
