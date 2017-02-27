# Java tasks

### Task 1: Palindrome
*Write an efficient algorithm to check if a string is a palindrome. A string is a
palindrome if the string matches the reverse of string.
Example: 1221 is a palindrome but not 1121.*

[Solution](/java/src/main/java/com/los/Palindrome.java)  
[Tests](/java/src/test/java/com/los/PalindromeTest.java)

### Task 2: find K-complementary pairs
*Write an efficient algorithm to find K-complementary pairs in a given array of
 integers. Given Array A, pair (i, j) is K- complementary if K = A[i] + A[j];*

[Solution](/java/src/main/java/com/los/ComplementaryPairs.java)  
[Tests](/java/src/test/java/com/los/ComplementaryPairsTest.java)

### Task 3: Top phrases count from file
*Given a large file that does not fit in memory (say 10GB), find the top 100000
 most frequent phrases. The file has 50 phrases per line separated by a pipe (|).
 Assume that the phrases do not contain pipe.
 Example line may look like: Foobar Candy | Olympics 2012 | PGA | CNET |
 Microsoft Bing ….
 The above line has 5 phrases in visible region.*

[Solution](/java/src/main/java/com/los/TopPhrases.java)  
[Tests](/java/src/test/java/com/los/TopPhrasesTest.java)

### Task 4: Multiply all but current
*Given array of integers. Output should be an array, where values are multiplications
of all digits in input element but current index.  
For example:*
```java
int[] input = new int[]{3, 1, 6, 4};
int[] expected = new int[]{24, 72, 12, 18};
//24 = 1 * 6 * 4
//72 = 3 * 6 * 4
//etc..
```
[Solution](/java/src/main/java/com/los/AllButIndexMultiplier.java)  
[Tests](/java/src/test/java/com/los/AllButIndexMultiplierTest.java)

### Task 5: Strip html tags
*Write a method which will accept HTML string and will strip out all its tags left only text.  
Example:*
```java
stripHtmlTags("<h1>Hello World!</h1> <p>something</p>") == "Hello World! something"; //true
```
[Solution](/java/src/main/java/com/los/StringHtmlTags.java)  
[Tests](/java/src/test/java/com/los/StringHtmlTagsTest.java)

### Task 6: InTheFuture
Peter is solving 5 tasks per day. Evan is solving 6 tasks per day.
Peter is 1 task ahead. How many days is Evan needs to overtake Peter by solved tasks?  
Answer: 2 days. 1 day to reach Peters level and another to take the lead.  
Write function which will take problem solving tempo of Peter and Evan, plus amount of problems Peter is ahead, 
and returns days needed to take the lead. If it's impossible to take the lead, return -1.
```java
int daysToOvertake(int aheadSolveTempo, int behindSolveTempo, int tasksDelta);
daysToOvertake(3,5,1) == 1;
daysToOvertake(4,5,1) == 2;
daysToOvertake(6,5,1) == -1;
```
[Solution](/java/src/main/java/com/los/InTheFuture.java)  
[Tests](/java/src/test/java/com/los/InTheFutureTest.java)

## See also
### [Codility tasks soultions](/java/Codility.md)