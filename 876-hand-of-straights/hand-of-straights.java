class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n=hand.length;
        HashMap<Integer, Integer>hm=new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(hand[i])){
                hm.put(hand[i],hm.get(hand[i])+1);
            }
            else{
                hm.put(hand[i],1);
            }
        }
        for(int i=0; i<n; i++){
            if(hm.containsKey(hand[i])){
                int prev=hand[i];
                if(hm.get(prev)==1)hm.remove(prev);
                else{
                    hm.put(prev,hm.get(prev)-1);
                }
                for(int j=1; j<groupSize; j++){
                    if(hm.containsKey(hand[i]+j)){
                        if(hm.get(hand[i]+j)==1){
                            hm.remove(hand[i]+j);
                        }
                        else{
                            hm.put(hand[i]+j,hm.get(hand[i]+j)-1);
                        }
                    }
                    else{
                        return false;
                    }
                } 
            }
           
        }
        return true;

    }
}