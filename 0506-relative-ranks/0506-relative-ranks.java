
class Solution {
    static class pair implements Comparable<pair>{
    int score;
    int idx;
    pair(int score,int idx){
        this.score=score;
        this.idx=idx;
    }
    public int compareTo(pair p2){
        return p2.score-this.score;
    }
}
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for(int i=0; i<score.length; i++){
            pair p=(new pair(score[i],i));
            pq.add(p);
        }
        String[] ans=new String[score.length];
        int rank=1;
        while(pq.size()>0){
            pair p=pq.remove();
            if(rank==1){
                ans[p.idx]="Gold Medal";
            }
            else if(rank==2){
                ans[p.idx]="Silver Medal";
            }
            else if(rank==3){
                ans[p.idx]="Bronze Medal";
            }
            else{
                ans[p.idx]=String.valueOf(rank);
            }
            rank++;
        }
        return ans;
    }
}