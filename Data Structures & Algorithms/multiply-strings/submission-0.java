class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        //  Let suppose 13 X 12
        //  num1 = 13   num2 = 12
        //  array of m+n = [ , , , ]
        //  carry = i+j      mult = i+j+1
        // At every index we have to do mult + pos[p2] for adding carry
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;     // If a num greater than 10 
                pos[p1] += sum / 10;    // adding carry to p1 index
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int digit : pos){
            if(!(sb.length() == 0 && digit == 0)){
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}