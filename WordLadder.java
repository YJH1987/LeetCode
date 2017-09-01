/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). 
Please reload the code definition to get the latest changes.*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> startSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> list = new HashSet<String>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        //transfer list to hashset
        for (String temp: wordList) {
            list.add(temp); 
        }
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            //search with less word's set to speed up
            if (startSet.size() > endSet.size()) {
                Set tmpSet = startSet; 
                startSet = endSet;
                endSet = tmpSet;
            }

            Set<String> tmp = new HashSet<String>();
            for (String word: startSet) {
                // put this out of the inner for loop to initialize less times. This would require to remember the changed character
                char[] charArr = word.toCharArray(); 
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        //remember the changed character and change it back later
                        char replace = charArr[i]; 
                        charArr[i] = c;
                        String s = new String(charArr);
                        //if other set contains string s means there is a intersect point between two sets. So return
                        if (endSet.contains(s)) return len + 1;
                        //HashSet contains is constant while List is not.
                        if (list.contains(s)) { 
                            tmp.add(s);
                            list.remove(s);
                        }
                        //change it back
                        charArr[i] = replace; 
                    }
                }
            }
            startSet = tmp;
            len++;
        }
        return 0;
    }
}