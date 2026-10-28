class Solution {
    public int par[];
     public void init(int n){
        par=new int[n];
            for(int i=0; i<n; i++){
               par[i]=i;
            }
      
    }
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public void union(int parA,int parB){
        int a=find(parA);
        int b=find(parB);
        if(a!=b){
            par[b]=a;
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> hm=new HashMap<>();
        List<List<String>> ls=new ArrayList<>();
        int n=accounts.size();
        init(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String s=accounts.get(i).get(j);
                if(hm.containsKey(s)){
                    union(hm.get(s),i);
                }
                else{
                    hm.put(accounts.get(i).get(j),i);

                }
            }
        }
        ArrayList<String>[] mergedmail=new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedmail[i]=new ArrayList<>();
        }
        List<String> allkeys=new ArrayList<>(hm.keySet());
        for(int i=0; i<allkeys.size(); i++){
            String mail=allkeys.get(i);
            int node=find(hm.get(mail));
            mergedmail[node].add(mail);

        }
        List<List<String>> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(mergedmail[i].size()==0){
                continue;
            }
          Collections.sort(mergedmail[i]);
          List<String> temp=new ArrayList<>();
          temp.add(accounts.get(i).get(0));
          temp.addAll(mergedmail[i]);
          ans.add(temp);
        }
        return ans;

       


    }
}