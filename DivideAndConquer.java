package cs146F22.Nguyen.project2;

public class DivideAndConquer {

	public DivideAndConquer() {
	}//default constructor
	
	/* divide and conquer method
	 * The method will solve the max subarray problem with crossing sub array case
	 * 1. Variables
	 *	(long) variables needed to keep track of left half sum, right half sum, max left index, max right index, and profit 
	 *			- leftSum, rightSum, sum, maxLeftIndex, maxRightIndex, profit, result[]
	 * 2. Method Parameters
	 *  (long) parameters needed to do cross sub array - arr[], low, mid, high
	 * 3. Processing/How the method works
	 * 	loop through first half of array and find the max profit, keeping track of start and end index
	 *  loop through right half of array and find max profit, keeping track of start and end index
	 *  return the maxprofit which is leftarray profit and right array profit added together, start index and end index
	 *  
	 *  
	 *  Method will solve with left subarray and rightsubarry, and crossing subarray included
	 * 1. Variables
	 *  (long) array variables needed to hold leftSubArray, rightSubarray, and crossing subarray calculations
	 *  		- leftSubArray, rightSubArray, crossingSubArray, result
	 * 2. Method Parameters
	 *  (long) parameters needed to do cross sub array - arr[], low, high
	 * 3. Processing/How the method works
	 * 	recursively call maxSubarray method for left half, right half, and crosssing array
	 * 	compare the profit from each of the three resulting calculated arrays, and return the array with the highest profit
	 */
	public static long[] findMaxCrossingSubarray(long arr[], long low, long mid, long high) {
		long result[] = new long[3];
		long leftSum = -1, sum = 0, maxLeftIndex = 0, profit = 0;
		for (int i = (int) mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeftIndex = i;
			}
		}
		long rightSum = -1, maxRightIndex = 0;
		sum = 0;
		for (int j = (int) (mid + 1); j <= high; j++) {
			sum += arr[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRightIndex = j;
			}
		}
		if(leftSum + rightSum <= 0) {
			maxLeftIndex = -1;
			maxRightIndex = -1;
			leftSum = 0;
			rightSum = 0;
		}
		profit = leftSum + rightSum;
		result[0] = maxLeftIndex;
		result[1] = maxRightIndex;
		result[2] = profit;
		return result;
	}

	public static long[] findMaxSubarray(long arr[], long low, long high) {
		long []result = new long[3];
		long[] leftSubarray;
		long[] rightSubarray;
		long[] crossSubarray;
		if (high == low) {
			result[0] = low;
			result[1] = high;
			result[2] = arr[(int) low];
			return result;
		} else {
			long mid = (low + high) / 2;
			leftSubarray = findMaxSubarray(arr, low, mid);
			rightSubarray = findMaxSubarray(arr, mid + 1, high);
			crossSubarray = findMaxCrossingSubarray(arr, low, mid, high);
			if (leftSubarray[2] >= rightSubarray[2] && leftSubarray[2] >= crossSubarray[2])
				return leftSubarray;
			else if (rightSubarray[2] >= leftSubarray[2] && rightSubarray[2] >= crossSubarray[2])
				return rightSubarray;
			else
				return crossSubarray;
		}
	}
	
	/*
	public static void print(long result[]) {
		System.out.println("==Divide And Conquer Method==");
		System.out.println("Max Profit: " + result[2] + ", Arrival Day: " + result[0] + ", Departing Day: "
				+ result[1] + "\n");
	}*/
}
