class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int finalValue=0;
        int nums[][]=new int[boxTypes.length][2];
        for(int i=0; i<boxTypes.length; i++){
            nums[i][0]=i;
            nums[i][1]=boxTypes[i][1];
        }
        Arrays.sort(nums,Comparator.comparingDouble(o->o[1]));
        for(int i=nums.length-1; i>=0 ; i--){
            int idx=nums[i][0];
            int boxes=boxTypes[idx][0];
            int units=boxTypes[idx][1];
            if(truckSize>=boxes){
                finalValue+= boxes*units;
                truckSize-=boxes;
            }
            else{
                finalValue+= truckSize*units;
                truckSize=0;
                break;
            }
        }
        return finalValue;
    }
}