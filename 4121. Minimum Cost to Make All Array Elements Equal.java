class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        int i= 0;
        while(i < n){
            int j = i;
            while(j < n && nums[j] == nums[i]){
                j++;
            }
            int len = j - i;
            if(i < n - 1 && j > 1){
            long cost = (long)(n - len)* nums[i];
            ans = Math.min(ans,cost);
            }
            i = j;
        }
        return ans;
    }
}