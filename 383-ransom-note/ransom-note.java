class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freqRansom[]=new int[26];
        int freqMagazine[]=new int[26];
        
        for(char ch:ransomNote.toCharArray())
            freqRansom[ch-'a']++;

        for(char ch:magazine.toCharArray())
            freqMagazine[ch-'a']++;

        for(int i=0;i<ransomNote.length();i++){
            if(i!=0 && ransomNote.charAt(i)==ransomNote.charAt(i-1))
                continue;

            char ch=ransomNote.charAt(i);
            if(freqRansom[ch-'a']>freqMagazine[ch-'a'])
                return false;
        }

        return true;
    }
}