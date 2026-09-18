class AuthenticationManager {
    int timeToLive;
    Map<String,Integer> map;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
        this.map=new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId)>currentTime)
            map.put(tokenId,currentTime+timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int ans=0;
        for(int val:map.values()){
            if(val>currentTime)
                ans++;
        }

        return ans;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */