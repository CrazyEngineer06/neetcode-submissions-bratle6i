class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftmost = new int[n];
        int[] rightmost = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            leftmost[i] = -1;

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                leftmost[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        for(int i=n-1;i>=0;i--){
            rightmost[i] = n;

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                rightmost[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            leftmost[i] += 1;
            rightmost[i] -= 1;

            ans = Math.max(ans,heights[i]*(rightmost[i]-leftmost[i]+1));
        }
        return ans;
    }
}
