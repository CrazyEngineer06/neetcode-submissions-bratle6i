class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = sumOfSquares(n);
            if(n == 1){
                return true;
            }
        }
        return false;
    }
    public int sumOfSquares(int n){
        int sum = 0;

        while(n > 0){
            int last = n%10;

            sum += last*last;

            n /= 10;
        }

        return sum;
    }
}
