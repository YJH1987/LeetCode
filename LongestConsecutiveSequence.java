// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
// For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
// Your algorithm should run in O(n) complexity.

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
	HashSet<Integer> set = new HashSet<Integer>();
        int max = 1;

	for (int e : num)
	    set.add(e);

	for (int e : num) {
	    int left = e - 1;
	    int right = e + 1;
	    int count = 1;
	    while (set.contains(left)) {
		count++;
		set.remove(left);
		left--;
	    }
	    while (set.contains(right)) {
		count++;
		set.remove(right);
		right++;
	    }

	    max = Math.max(count, max);
	}
	
	return max;
    }
}

------------------------------------------------------------------------------------------

import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        /*
            def longestConsecutive(self, num):
                d={}
                visited=set()
                m=1
                for n in num:
                    d[n]=1
                for n in num:
                    if not visited.__contains__(n):
                        while d.__contains__(n-1):
                            n-=1
                        visited.add(n)
                        while d.__contains__(n+1):
                            d[n+1]=d[n]+1
                            m=max(m,d[n+1])
                            n+=1
                            visited.add(n)
                return m
        */
        Map<Integer,Integer> d = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int m = 1;
        for(int i =0; i<num.length;i++) {
            d.put(num[i], 1);
        }
        for(int i =0; i<num.length;i++) {
            int n = num[i];
            if(!visited.contains(n)) {
                while(d.containsKey(n-1)) n--;
                visited.add(n);
                while(d.containsKey(n+1)) {
                    d.put(n+1,d.get(n)+1);
                    m = Math.max(m,d.get(n+1));
                    n++;
                    visited.add(n);
                }
            }
        }
        return m;
    }
}
