class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a = f(nums,k);
        int b = f(nums,k-1);
        return a-b;
    }
    public int f(int nums[],int k){
        int c = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            c = c + i - l + 1;
        }
        return c;
    }
}