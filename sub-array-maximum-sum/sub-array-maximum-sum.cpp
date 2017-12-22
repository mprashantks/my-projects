/**
  * Objective:
    Given an array of integers find the largest sum of contiguous subarray.

  * Implementation:
    Here Kadane's algorithm is employed which looks for all positive contiguous segments of the array
    and keep track of maximum sum contiguous segment among all segments searched so far.
    Entire array is traversed only once so giving a linear time complexity i.e., O(n).
 **/


#include <iostream>

//Function to compute maximum number from passed arguments
int max (int num1, int num2) {
  return (num1 >= num2 ? num1 : num2);
}

//Function to employ Kadane's algorithm
int maxSum (int *arr, int size_array) {
  int current_max, global_max;

  // Intialise current_max and global_max with first element of array
  current_max = global_max = arr[0];

  for (int i=1; i<size_array; i++) {

    // current_max stores the current maximum sum i.e.,
    // it stores the current maximum sum found so far in contiguous subarray
    current_max = max(arr[i], current_max+arr[i]);

    // global_max stores the sum of elements of a subarray which is greater than all other subarrays sum
    // Condition to check if current_max is greater then global_max
    // If yes then update global_max else skip this part
    if (current_max > global_max)
      global_max = current_max;

  }

  // Return the maximum sum of contiguous subarray
  return global_max;
}


//Main function
int main () {

  // Size of array to be entered
  int size_array;

  // Console output and input
  std::cout << "\nEnter size of array: ";
	std::cin >> size_array;

  // Dynamically create an array of required size to avoid memory wastage
  int *arr = new int[size_array];

  // Input array from console
  std::cout << "\nEnter array \n";
  for (int i=0; i<size_array; i++)
    std::cin >> arr[i];

  // maxSum() function returns the maximum possible sum
  std::cout << "Maximum sum is: " << maxSum(arr, size_array) << std::endl;

  return 0;
}
