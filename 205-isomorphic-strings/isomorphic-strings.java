class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len=s.length();
        Map<Character,Character> map=new HashMap<>();
        Map<Character,Character> sMap=new HashMap<>();

        for(int i=0;i<len;i++){
            char chS=s.charAt(i);
            char chT=t.charAt(i);

            if(map.containsKey(chS) && map.get(chS)!=chT)
                return false;
            else
                map.put(chS,chT);

            if(sMap.containsKey(chT) && sMap.get(chT)!=chS)
                return false;
            else
                sMap.put(chT,chS);
            
        }

        return true;
    }
}