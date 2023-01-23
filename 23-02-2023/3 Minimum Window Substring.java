class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        for(char ch : t.toCharArray())
        {
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int maxCount = t.length();
        String res = "";
        int count = 0,i = 0,j = 0;
        HashMap<Character,Integer> map2 = new HashMap<>();
        while(true)
        {
            boolean flag = false;
            while(i<s.length() && count!=maxCount)
            {
                char curr = s.charAt(i);
                map2.put(curr,map2.getOrDefault(curr,0)+1);
                if(map1.containsKey(curr) && map1.get(curr)>=map2.get(curr))
                {
                    count++;
                }
                i++;
                flag = true;
            }
            while(j<i && count==maxCount)
            {
                if(res.length() > i-j || res.equals(""))
                {
                    res = s.substring(j,i);
                }
                char curr = s.charAt(j);

                if(map2.get(curr)==1)
                {
                    map2.remove(curr);
                }
                else
                {
                    map2.put(curr,map2.get(curr)-1);
                }
                if(map1.containsKey(curr) && map2.getOrDefault(curr,0)<map1.get(curr))
                {
                    count--;
                }
                j++;
                flag = true;
            }
            if(!flag)
            {
                break;
            }
        }
        return res;

    }
}
