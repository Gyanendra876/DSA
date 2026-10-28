class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        boolean ans[]=new boolean[queries.length];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            ls.get(u).add(v);

        }
        for(int i=0; i<queries.length; i++){
            int u=queries[i][0];
            int v=queries[i][1];
            q.add(u);
            while(!q.isEmpty()){
                int curr=q.remove();
                for(int j=0; j<ls.get(curr).size(); j++){
                    int s=ls.get(curr).get(j);
                    if(s==v){
                        ans[i]=true;
                    }
                    else{
                        q.add(s);
                    }
                }

            }
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for (boolean num : ans) {
            list.add(num);
        }
        return list;


    }
}