class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        result[n-1] = 0;
        st.push(n-1);

        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = 0;
            }else{
                result[i] = st.peek() - i;
            }
            st.push(i);
        }
        return result;
    }
}