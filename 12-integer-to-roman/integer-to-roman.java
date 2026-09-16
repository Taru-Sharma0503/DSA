class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> map=new HashMap<>();
        int arr[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder ans=new StringBuilder();

        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");

        while(num>0){

            for(int val:arr){
                if(val>num)
                    continue;

                ans.append(map.get(val));
                num-=val;
                break;
            }
        }

        return ans.toString();
    }
}