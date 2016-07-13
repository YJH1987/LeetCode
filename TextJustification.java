/*Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.*/

// Solution 1
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString()); 
            index = last;
        }


        return lines;
    }
}

// Solution 2
import java.util.*;
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> r = new ArrayList<String>();
        String line = words[0];
        for (int i = 1; i < words.length; i++) {
            String w = words[i];
            if (line.length() + 1 + w.length() <= L) {
                line += " " + w;
            } else {
                r.add(dist(line, L));
                line = w;
            }
        }
        int tmp = line.length();
        for (int i = 0; i < L - tmp; i++) line += " ";
        r.add(line);
        return r;
    }

    private String dist(String line, int L) {
        if (!line.contains(" ")) {
            int tmp = line.length();
            for (int i = 0; i < L - tmp; i++) line += " ";
            return line;
        }
        String[] ws = line.split(" ");
        int sc = ws.length - 1 + L - line.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc / (ws.length - 1); i++) {
            sb.append(' ');
        }
        for (int i = 0; i < ws.length - 1; i++) {
            ws[i] += sb.toString();
            if (i < sc % (ws.length - 1)) ws[i] += " ";
        }
        sb = new StringBuilder();
        for (int i = 0; i < ws.length; i++) sb.append(ws[i]);
        return sb.toString();
    }
}