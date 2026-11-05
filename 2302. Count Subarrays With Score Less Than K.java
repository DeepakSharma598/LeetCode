import java.util.*;
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        for(right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum * (right - left + 1) >= k){
                sum = sum - nums[left];
                left++;
            }
            count = count + right - left + 1;
        }
        return count;
    }
}