/*
Problem Statement:
Given an array of integers find the largest sum of contiguous subarray.

Solution:
Here Kadane's algorithm is employed which looks for all positive contiguous segments of the array
and keep track of maximum sum contiguous segment among all segments searched so far.
Entire array is traversed only once so giving a linear time complexity i.e., O(n).
*/


#include <iostream>

//Function to compute maximum number from passed arguments
int max(int num1, int num2) {
  return (num1 >= num2 ? num1 : num2);
}

//Function to employ Kadane's algorithm
int maxSum(int *arr, int size_array) {
  int current_max, global_max;
  current_max = global_max = arr[0];

  //Find if after including the array element pointed by pointer i the sum is greater than the global maximum sum
  //If yes then update the global maximum
  for(int i=1; i<size_array; i++) {
    current_max = max(arr[i], current_max+arr[i]);
    if(current_max > global_max)
      global_max = current_max;
  }
  return global_max;
}


//Main function
int main () {
  int size_array;
  std::cout << "\nEnter size of array: ";
	std::cin >> size_array;

  int *arr = new int[size_array];
  std::cout << "\nEnter array \n";
	for (int i=0; i<size_array; i++)
    std::cin >> arr[i];

	std::cout << "Maximum sum is: " << maxSum(arr, size_array) << std::endl;

	return 0;
}
