//Write a function that takes a string as input and returns the string reversed.
//The below method is to reverse the string in place. TC=O(n/2), SP=O(1)
class Solution {
    public String reverseString(String s) {
        int i=0,j=s.length()-1;
        char[] reverseArr = new char[s.length()];
        while(i<=j){
           /* System.out.println("******s.charAt(i)"+s.charAt(i));
            System.out.println("******s.charAt(j)"+s.charAt(j));*/
            reverseArr[i]=s.charAt(j);
            reverseArr[j]=s.charAt(i);
            i++;
            j--;
            
        }
        return String.valueOf(reverseArr);
    }
}
