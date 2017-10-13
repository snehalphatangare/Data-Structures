/*JAVA Code for Merging two unsorted arrays in sorted order */
import java.util.*;
 
class mergeUnsortedArraysIntoSorted {
     
    public static void sortedMerge(int a[], int b[]   )
                               
    {
      int n= a.length;
      int m=b.length;
       // Final merge list
        int res[] = new int[n + m];
        // Sorting a[] and b[]
        Arrays.sort(a);
        Arrays.sort(b);
      
        // Merge two sorted arrays into res[]
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i += 1;
                k += 1;
            } else {
                res[k] = b[j];
                j += 1;
                k += 1;
            }
        }    
         
        while (i < n) {  // Merging remaining
                         // elements of a[] (if any)
            res[k] = a[i];
            i += 1;
            k += 1;
        }    
        while (j < m) {   // Merging remaining
                         // elements of b[] (if any)
            res[k] = b[j];
            j += 1;
            k += 1;
        }
        
        System.out.print( "Sorted merged list :");
        for (int i = 0; i < n + m; i++)
            System.out.print(" " + res[i]);
    }
     
    public static void main(String[] args) 
    {
        int a[] = { 10, 5, 15 };
        int b[] = { 20, 3, 2, 12 };
 
        sortedMerge(a, b);
           
    }
}
