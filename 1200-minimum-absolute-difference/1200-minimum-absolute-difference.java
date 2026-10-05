class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int minimum=Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
              int difference=arr[i+1]-arr[i];
             if(difference<minimum){
                 minimum=difference;
                 ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i+1]));
             }
             else{
                if(minimum==difference){
                     ans.add(Arrays.asList(arr[i], arr[i+1]));
                }
             }
        }
        return ans;
    }
}