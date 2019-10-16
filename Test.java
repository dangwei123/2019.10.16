1.
在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。

至少有一个空座位，且至少有一人坐在座位上。

亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。

返回他到离他最近的人的最大距离。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxDistToClosest(int[] seats) {
        int count=0;
        int maxcount=0;
        int flag=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                flag++;
            }
            if(flag==1&&seats[i]==0){
                count++;
                if(count>maxcount){
                    maxcount=count;
                }
            }
            if(flag==2){
                flag=1;
                count=0;
            }
        }
        int len1=0;
        if(maxcount%2!=0){
            len1=maxcount/2+1;
        }else{
            len1=maxcount/2;
        }
        count=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
               count++; 
            }else{
                break;
            }
        }
        int len2=count;
        count=0;
        for(int j=seats.length-1;j>=0;j--){
            if(seats[j]==0){
                count++;
            }else{
                break;
            }
        }
        int len3=count;
        int a=len1>len2?len1:len2;
        return a>len3?a:len3;
    }
}

2.
在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。

返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。

 

示例 1：

输入：[30,20,150,100,40]
输出：3
解释：这三对的总持续时间可被 60 整数：
(time[0] = 30, time[2] = 150): 总持续时间 180
(time[1] = 20, time[3] = 100): 总持续时间 120
(time[1] = 20, time[4] = 40): 总持续时间 60

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

法一：
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count=0;
        int[] arr=new int[time.length];
        for(int i=0;i<time.length;i++){
            arr[i]=time[i]%60;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==60||arr[i]+arr[j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}

法二：
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count=0;
        int[] arr=new int[time.length];
        int[] res=new int[60];
        for(int i=0;i<time.length;i++){
            arr[i]=time[i]%60;
        }
       for(int i:arr){
           res[i]++;
       }
        for(int i=1;i<30;i++){
            count+=res[i]*res[60-i];
        }
        count+=(res[0]*(res[0]-1))/2;
        count+=(res[30]*(res[30]-1))/2;
        return count;
    }
}
3.
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
示例 2:

输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int num=0;
       int[] res=new int[cost.length];
        for(int i=0;i<res.length;i++){
            if(i<2){
                res[i]=cost[i];
            }else{
                res[i]=Math.min(res[i-1],res[i-2])+cost[i];
            }
        }
       return Math.min(res[res.length-1],res[res.length-2]);
    }
}

4.
给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

示例 1:

输入: [3, 1, 4, 1, 5], k = 2
输出: 2
解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
尽管数组中有两个1，但我们只应返回不同的数对的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                for(int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[i]==k){
                    count++;
                    break;
                }
                if(nums[j]>nums[i]+k){
                    break;
                }
            }
            }
            
        }
        return count;
    }
}