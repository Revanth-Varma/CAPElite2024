class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int temp = n;
        while(temp!=1){
            temp = digitSquareSum(temp);
            if(!set.contains(temp)){
                set.add(temp);
            }
            else{
                return false;
            }
        }
        return true;
    }
    public int digitSquareSum(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum += rem* rem;
            n/=10;
        }
        return sum;
    }
}
