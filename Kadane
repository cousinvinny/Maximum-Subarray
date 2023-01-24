package cs146F22.Nguyen.project2;

public class Kadane {

	public Kadane() {
	}//default constructor

	/* kadane's algorithm
	 * The method will solve the max subarray problem with kadane's algorithm
	 * 1. Variables
	 *	(long) variables needed to hold max sum, max temp, arrival day, departing day, temporary arrive day, and returning array
	 *			- maxSum, maxTemp, arrive, depart, tempArrive, result[]
	 * 2. Method Parameters
	 *  (long) variable needed that has the data - arr[]
	 * 3. Processing/How the method works
	 * 	loop through whole array
	 * 	keep adding each individual index
	 * 	if sum becomes negative, reset sum and continue through array
	 *  return  maxSum, arrival day, and departing day
	 */
	public static long[] kadanesAlgorithm(long[] arr) {
		long result[] = new long[3];
		long maxSum = 0, maxTemp = 0, arrive = -1, depart = -1, tempArrive = 0;
		for (long i = 0; i < arr.length; i++) {
			maxTemp += arr[(int) i];
			if (maxTemp < 0) {
				maxTemp = 0;
				arrive = i + 1;
			}
			if (maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
			
		}
		if(maxSum < 0) {
			maxSum = 0;
			arrive = -1;
			depart = -1;
		}
		arrive = tempArrive;
		result[0] = maxSum;
		result[1] = arrive;
		result[2] = depart;
		return result;
	}
	
	/*
	public static void print(long result[]) {
		System.out.println("==Kadane's Algorithm==");
		System.out.println("Max Profit: " + result[0] + ", Arrival Day: " + result[1] + ", Departing Day: "
				+ result[2] + "\n");
	}*/

}
