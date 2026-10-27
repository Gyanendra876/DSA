class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs=new HashSet<>(Arrays.asList(deadends));
        Queue<String> q=new LinkedList<>();
        String value="0000";
        if(hs.contains(value)){
            return -1;
        }
        q.add(value);
        hs.add(value);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String curr=q.remove();
                if(curr.equals(target)){
                    return level;
                }
                for(String next:calculate(curr)){
                    if(!hs.contains(next)){
                        hs.add(next);
                        q.add(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    public List<String> calculate(String curr){
        List<String> ls=new ArrayList<>();
        char arr[]=curr.toCharArray();
        for(int i=0; i<4; i++){
            char val=arr[i];
            arr[i]= val=='0' ? '9':(char)(val-1);
            ls.add(new String(arr));
            arr[i] = val=='9' ? '0':(char) (val+1);
            ls.add(new String(arr));
            arr[i]=val;
            

        }
        return ls;
    }
}