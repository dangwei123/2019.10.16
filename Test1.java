1.
给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

示例 1:

输入: 
nums = [1, 7, 3, 6, 5, 6]
输出: 3
解释: 
索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
同时, 3 也是第一个符合要求的中心索引。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-pivot-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int sum=0;
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
        }
         if(sum==0){
            return 0;
        }
        int sum1=0;
        for(int i=1;i<nums.length;i++){
            sum1+=nums[i-1];
             int sum2=0;
            for(int j=i+1;j<nums.length;j++){
                sum2+=nums[j];
            }
            if(sum1==sum2){
                return i;
            }
        }
        return -1;
    }
}

2.
给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

示例 1:

输入: [4,2,3]
输出: True
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3){
            return true;
        }
        int changecount=0;
        if(nums[0]>nums[1]){
            changecount++;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(nums[i-1]>nums[i+1]){
                    nums[i+1]=nums[i];
                }else{
                    nums[i]=nums[i-1];
                }
                changecount++;
            }
            if(changecount>=2){
                return false;
            }
        }
        return true;
    }
}


