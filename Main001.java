/*Given an array of integers where each element
 represents the max number of steps that can be made 
 forward from that element. Find the minimum number of 
 jumps to reach the end of the array 
 (starting from the first element). If an element is 0,
  then you cannot move through that element.

Example 1:

Input:
N=11 
arr=1 3 5 8 9 2 6 7 6 8 9 
Output: 3 
Explanation: 
First jump from 1st element to 2nd 
element with value 3. Now, from here 
we jump to 5th element with value 9, 
and from here we will jump to last. 

Example 2:

Input :
N= 6
arr= 1 4 3 2 6 7
Output: 2 
Explanation: 
First we jump from the 1st to 2nd element 
and then jump to the last element.

Your task:
You don't need to read input or print anything.
 Your task is to complete function minJumps() which 
 takes the array arr and it's size N as input parameters 
 and returns the minimum number of jumps.

Constraints:
1 = N = 107
0 <= a[i] <= 107
*/

import java.util.*;
import java.io.*;

class Main001
{
    public static int findMinStep(int[] arr,int start,int end)
    {
        if((arr[start]+start)>=end)
        {
            return 1;
        }
        if(arr[start]==0)
        {
            return end+1;
        }
        int min=Integer.MAX_VALUE;
        int x=0;
        for(int i=start+1;i<=start+arr[start];i++)
        {
             x =1+findMinStep(arr,i,end);
            if(min>x)
            {
                min=x;
            }
            x=0;
        }
        return min;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
        }
        int result=findMinStep(a,0,n-1);
        if(result>n)
        {
            System.out.println("Not possible to reach end");
        }
        else
        {
            System.out.println(result);
        }
    }
}