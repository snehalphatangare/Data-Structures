//Leetcode 392

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || s=="")
            return true;
        //Store the index of previous character
        int maxIndex=-1;
        char[] sCharArray= s.toCharArray();
        for(int i=0;i<sCharArray.length;i++){
            System.out.println("maxindex="+maxIndex);
            System.out.println("character="+sCharArray[i]+" index="+t.indexOf(sCharArray[i],maxIndex+1));
            //Check if index of next character starting from (maxIndex+1) is greater than index of previous character
            if(t.indexOf(sCharArray[i],maxIndex+1) > maxIndex)
                maxIndex=t.indexOf(sCharArray[i],maxIndex+1);
            else 
                return false;
        }
        return true;
    }
}
