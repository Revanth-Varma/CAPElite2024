class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        Arrays.sort(strs);
        String max = strs[strs.length-1];
        String min = strs[0];
        int ind = 0;
        while(ind<min.length()){
            if(min.charAt(ind)==max.charAt(ind)){
                ind++;
            }
            else{
                break;
            }
        }
        return ind==0?"":max.substring(0,ind);
    }
}
