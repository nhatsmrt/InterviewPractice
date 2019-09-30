/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    private static int[] dp;
    private static int[] argmin;
    private static int[][] cost;

	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();

		for (int t = 0; t < numTest; t++) {
		    int numWords = sc.nextInt();
		    int[] words = new int[numWords];
		    for (int i = 0; i < numWords; i++)
		        words[i] = sc.nextInt();
		    int maxLength = sc.nextInt();

		    dp = new int[numWords];
		    argmin = new int[numWords];
		    cost = new int[numWords][numWords];

		    for (int i = 0; i < numWords; i++) {
		        for (int j = i; j < numWords; j++) {
		            int length = 0;
		            for (int k = i; k <= j; k++)
		                length += words[k];

		            if (length > maxLength)
		                cost[i][j] = 100000000;

		            else {
		                int diff = maxLength - length;
		                cost[i][j] = diff * diff * diff;
		            }
		        }
		    }

		    Arrays.fill(dp, -1);
		    Arrays.fill(argmin, -1);
		  //  dp[numWords - 1] = 1;
		  //  argmin[numWords - 1] = numWords;

		    dp(words, 0);
		    int curWord = 0;
		    while (curWord < numWords) {
		        int nextWord = argmin[curWord];
		        System.out.print((curWord + 1) + " " + (nextWord + 1));
		        curWord = nextWord + 1;
		    }
		  //  return dp(words, 0);
		}
	}

	public static int dp(int[] words, int i) {
	    if (i == words.length)
	        return 0;

	   if (dp[i] != -1)
	        return dp[i];

	   int ret = -1;
	   int curArgmin = -1;
	   for (int j = i; j < words.length; j++) {
	       int badness = cost[i][j] + dp(words, j + 1);
	       if (ret == -1 || ret > badness) {
	           ret = badness;
	           curArgmin = j;
	       }
	   }

	   dp[i] = ret;
	   argmin[i] = curArgmin;
	   return ret;
	}
}
