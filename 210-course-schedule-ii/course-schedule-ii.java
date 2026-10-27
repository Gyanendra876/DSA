class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();

        int indegree[]=new int[numCourses];
        boolean visited[]=new boolean[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            ls.get(v).add(u);
            indegree[u]++;

        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
                ans.add(i);

            }
        }
       
        while(!q.isEmpty()){
            int curr=q.remove();
            visited[curr]=true;
            for(int i=0; i<ls.get(curr).size(); i++){
                int val=ls.get(curr).get(i);
                indegree[val]--;
                if(indegree[val]==0){
                    q.add(val);
                    ans.add(val);
                }
            }

        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]!=0)return new int[]{};
        }
        return  ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}