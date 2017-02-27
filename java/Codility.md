## Lesson 1: Iteration  
### Task 1: BinaryGap  
Find longest sequence of zeros in binary representation of an integer.

[Solution](/java/src/main/java/com/los/codility/CountBinaryGaps.java)  
[Test](/java/src/test/java/com/los/codility/CountBinaryGapsTest.java)  

## Lesson 2: Arrays
### Task 1: OddOccurencesInArray
Find unpaired element in the odd integer array where all elements have pairs but one.
Means `[1,1,2,2,3]` 1 and 2 have a pair, 3 doesn't.

[Solution](/java/src/main/java/com/los/codility/OddOccurrencesInArray.java)  
[Test](/java/src/test/java/com/los/codility/OddOccurrencesInArrayTest.java)

### Task 2: CyclicRotation
Rotate array elements clockwise.
Example: `rotate([1,2,3,4,5],3) == [3,4,5,1,2]`

[Solution](/java/src/main/java/com/los/codility/CyclicRotation.java)  
[Test](/java/src/test/java/com/los/codility/CyclicRotationTest.java)

## Lesson 90: Tasks from Indeed Prime 2015 challenge
### Task 1: LongestPassword
You would like to set a password for a bank account. However, there are three restrictions on the format of the password:

it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
there should be an even number of letters;
there should be an odd number of digits.
You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and removing, 
the spaces. The goal is to choose the longest word that is a valid password.
For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A" and 
"pass007". Thus the longest password is "pass007" and its length is 7.  
Write a function:
```java
int solution(String spaceSeparatedPasswords);
```
[Solution](/java/src/main/java/com/los/codility/LongestPassword.java)  
[Test](/java/src/test/java/com/los/codility/LongestPasswordTest.java)

### Task 2: FloodDepth
After the rainfall, all the low-lying areas (i.e. blocks that have higher blocks on both sides) are holding as much water
 as possible. You would like to know the maximum depth of water after this entire area is flooded. You can assume that 
 the altitude outside this area is zero and the outside area can accommodate infinite amount of water.  
For example, consider array A such that:
```java
    A[0] = 3
    A[1] = 1
    A[2] = 2
```    
Its maximum depth will be 1. Since A[0] and A[2] are higher than A[1]. So maximum depth is 1. 
Cause highest level and lowest level is 2 - 1 = 1.
So surface will look like:
```
 ___
 | | 1 ___  
 | |___| |
 | |   | |
 ```
Write a function which apply only one parameter - array, which will describe 2D surface.
```java
int solution(int[] surface);
```
[Solution](/java/src/main/java/com/los/codility/FloodDepth.java)  
[Test](/java/src/test/java/com/los/codility/FloodDepthTest.java)