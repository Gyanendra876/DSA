class TimeMap {
    class Info {
        int i;
        String s;
        Info(int i,String s){
            this.i=i;
            this.s=s;
        }
       
    }
    HashMap <String,ArrayList<Info>> hm;
    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key,new ArrayList<>());
        }
        
            hm.get(key).add(new Info(timestamp,value));
        
        
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        int low=0;
        ArrayList<Info> list=hm.get(key);
        int high=list.size()-1;
        String s1="";
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid).i==timestamp){
                return list.get(mid).s;
            }
            if(list.get(mid).i<timestamp){
              s1=list.get(mid).s;
              low=mid+1;

            }
            else{
                high=mid-1;
            }
        }
        return s1;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */