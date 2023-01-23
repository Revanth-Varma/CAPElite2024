class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.equals("")){
            return 0;
        }
        int sign = 1, i = 0; 
        long res = 0;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            if(s.charAt(0)=='-'){
                sign = -1;
            }
           i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i)) && res<=Integer.MAX_VALUE){
            int ch = s.charAt(i++) - '0';
            res = res * 10 + ch;
        }
        res = res*sign;
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        else if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }

        return (int) res;
    }
}
