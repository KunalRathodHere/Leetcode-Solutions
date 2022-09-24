class Solution {
    
    List<List<Integer>> ans;
    Set<List<Integer>> set;
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        
        ans = new ArrayList<List<Integer>>();
        set = new HashSet<List<Integer>>();
        
        
        Arrays.sort(nums);
        
        for(int i =0; i<nums.length; i++){
            
            int curr = nums[i];
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            twoSum(nums, -1*curr, i+1);
            
        }
        
        return ans;
    }
    
    public void twoSum(int[] nums, int target, int i){
        
        int j = nums.length-1;
        
        while(i < j){
            
            if(nums[i] + nums[j] == target){
                
                ans.add(Arrays.asList(-1*target, nums[i], nums[j]));
                i++;
                while(i<j && nums[i] == nums[i-1]){
                    i++;
                }
            }
            
            if(nums[i] + nums[j] < target) i++;
            if(nums[i] + nums[j] > target) j--;
            
        }
        
    }
}