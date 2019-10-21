/* *****************************************************************************
 *  Name: Minh Vu    
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name:       
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional): 7-9 hours
 *
 **************************************************************************** */

Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  to find the first index of a key that equals the search key.

Since the array is already sorted, it will compare key to the middle position. If our key is bigger, we go to the right (make lo = mid+1), if it's smaller, we go to the left (make hi = mid - 1). We keep doing this until we find the index with the same key, then we keep moving back until we hit the index that is not the same key. Then return that index + 1 (the last time we saw key)
 **************************************************************************** */



/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() :

allMatches() : Arrays.sort(result, Term.byReverseWeightOrder())

numberOfMatches() :

/* *****************************************************************************
 *  What is the order of growth of the number of compares (in the worst case)
 *  that each of the operations in the Autocomplete data type make, as a
 *  function of the number of terms n and the number of matching terms m?

 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 **************************************************************************** */

- Constructor: O(nlogn): we go through every element to check if it's null and then perform merge sort, which is nlogn
- allMatches(): logn + mlogm : log n because we perform 2*logn compare to find our first and last (n is just the length of Term[]).  mlogm because we sort our matching array by ReverseWeightOrder, which takes mlogm (where m is the number of matching term) 
- numberOfMatches(): logn . We just have to find first and last




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 
I need some help from my friend Evan toward the end of my work.

 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.   

I had some trouble writing JUnit test for BinarySearch                 
 **************************************************************************** */


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */




/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */

