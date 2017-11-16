#include <iostream>

using namespace std;

int max(int num1, int num2) {
  return (num1 >= num2 ? num1 : num2);
}


int maxSum(int *arr, int size_array) {
  int current_max, global_max;
  current_max = global_max = arr[0];

  for(int i=1; i<size_array; i++) {
    current_max = max(arr[i], current_max+arr[i]);
    if(current_max > global_max)
      global_max = current_max;
  }
  return global_max;
}

int main () {
  int size_array;
	cin >> size_array;

  int *arr = new int[size_array];
	for (int i=0; i<size_array; i++)
    cin >> arr[i];

	cout << maxSum(arr, size_array) << endl;

	return 0;
}
