class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans=new ArrayList<>();
        int largest=Integer.MIN_VALUE;
        for(int i=0; i<candies.length; i++){
            if(largest<candies[i]){
                largest=candies[i];
            }
        }
        for(int i=0; i<candies.length; i++){
            int nums=candies[i];
            if((nums+extraCandies)>=largest){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}