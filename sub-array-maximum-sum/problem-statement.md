Problem Statement:
Given an array of integers find the largest sum of contiguous subarray.

Solution:
Here Kadane's algorithm is employed which looks for all positive contiguous segments of the array
and keep track of maximum sum contiguous segment among all segments searched so far.
Entire array is traversed only once so giving a linear time complexity i.e., O(n).
