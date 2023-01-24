package cs146F22.Nguyen.project2;

public class BruteForce {


	public BruteForce() {
	}// default constructor

	/* brute force method
	 * The method will solve the max subarray problem with brute force
	 * 1. Variables
	 *	(long) variables needed to hold sum, max profit, arrival day, departing day, and return array 
	 *			- sum, maxProfit, arrivalDay, departingDay, result[]
	 * 2. Method Parameters
	 *  (long) variable needed that has the data - arr[]
	 * 3. Processing/How the method works
	 * 	Use nested for loops to loop through the rest of array after the index from the first for loop
	 *	return maxProfit, arrivalDay, and departingDay
	 *  
	 */
	public static long[] bruteForceFindMaxSubArr(long[] arr) {
		long[]result = new long[3];
		long sum = 0, maxProfit = 0, arrivalDay = -1, departingDay = -1;
		for (int i = 0; i < arr.length; i++) {
			arrivalDay = i;
			sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum = sum + arr[j];
				if (maxProfit < sum) {
					maxProfit = sum;
					departingDay = j;
					result[0] = maxProfit;
					result[1] = arrivalDay;
					result[2] = departingDay;
				}
			}
		}
		if(maxProfit <= 0) {
			result[0] = 0;
			result[1] = -1;
			result[2] = -1;
		}
		return result;
	}
	
	/*
	public static void print(long result[]) {
		System.out.println("==Brute Force Method==");
		System.out.println("Max Profit: " + result[0] + ", Arrival Day: " + result[1] + ", Departing Day: "
				+ result[2] + "\n");
	}*/
}
