class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int left=0;
        int right=n-1;
        int score=0;
        Arrays.sort(tokens);
        while(left<=right){
            if(tokens[left]<=power){
                power-=tokens[left];
                score++;
                left++;
            }
            else if(left<right&& score>0){
                power+=tokens[right];
                right--;
                score--;
            }
            else{
                return score;
            }
        }
        return score;
    }
}