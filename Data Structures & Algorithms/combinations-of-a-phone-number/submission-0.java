class Solution {
    public List<String> letterCombinations(String digits) {
        char ch = 'a';
        List<String> res = new ArrayList<>();
        String[] digitToChar = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
        
        if(digits.isEmpty()) return res;
        backtrack(0,"",digits,res,digitToChar);
        return res;
    }
    public void backtrack(int i,String curStr,String digits,List<String> res,String[] digitToChar){
        if(curStr.length() == digits.length()){
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i)-'0'];

        for(char c:chars.toCharArray()){
            backtrack(i + 1, curStr + c, digits, res, digitToChar);
        }
    }
}