class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        rec(ans,n,0,0,new StringBuilder());

        return ans;
    }
    public void rec(List<String> ans,int n,int l,int r,StringBuilder sb){
        if(r == n){
            ans.add(sb.toString());
            return;
        }
        if(l < n){
            sb.append('(');
            rec(ans,n,l+1,r,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(r < l){
            sb.append(')');
            rec(ans,n,l,r+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
