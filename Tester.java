/*

The project will use 3 different methods to calculate the maximum subarray of any given array. The three
methods are brute force, divide and conquer, and kadane's algorithm. First the program will read in 
data from the given text file (10 cases with 100 data entries) and feed the three algorithms with the data.
Calculated answers are compared with the actual answers. Then some simple test cases will be run. Finally, 
randomly generated arrays of different, large sizes will be put through each of the three algorithms and the 
time to execute will be recorded.
 */
package cs146F22.Nguyen.project2;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Project2Test {
	Utility utility = new Utility();
	long profits[][], results[][], correctAnswers[][], bruteForceResults[][], kadaneResults[][], DACResults[][];

	/* Before each test
	 * 1. Variables/Objects
	 *	(long[][]) need arrays to hold calculations from the 3 methods, correct answers, and data from text file
	 *			- bruteForceResults, DACResults, kadaneResults, correctAnswers, results, profits
	 * 2. Processing/How the method works
	 * 	Initialize each 2d array variable
	 * 	Read in data from text file and save to 2d array
	 * 	Assign data to profits 2d array and correct answers to correctAnswers 2d array
	 */
	@BeforeEach
	public void beforeEach() {
		bruteForceResults = new long[10][3];
		DACResults = new long[10][3];
		kadaneResults = new long[10][3];
		correctAnswers = new long[10][3];
		results = new long[10][103];
		profits = new long[10][100];
		results = Utility.readFile(
				"C:\\Users\\Vinh T Nguyen\\eclipse-workspace\\cs146Project2\\src\\cs146F22\\Nguyen\\project2\\maxSumtest.txt");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				profits[i][j] = results[i][j];
			}
			for (int k = 100; k < 103; k++) {
				correctAnswers[i][k - 100] = results[i][k];
			}
		}
	}

	
	@Test
	void testBruteForceTextFile() {
		for (int i = 0; i < 10; i++) {
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(profits[i]);
			assertEquals(bruteForceResults[i][0], correctAnswers[i][0]);
			assertEquals(bruteForceResults[i][1], correctAnswers[i][1]);
			assertEquals(bruteForceResults[i][2], correctAnswers[i][2]);
		}
	}

	@Test
	void testDivideAndConquerTextFile() {
		for (int i = 0; i < 10; i++) {
			DACResults[i] = DivideAndConquer.findMaxSubarray(profits[i], 0, 99);
			assertEquals(DACResults[i][0], correctAnswers[i][1]);
			assertEquals(DACResults[i][1], correctAnswers[i][2]);
			assertEquals(DACResults[i][2], correctAnswers[i][0]);
		}
	}

	@Test
	void testKadaneTextFile() {
		for (int i = 0; i < 10; i++) {
			kadaneResults[i] = Kadane.kadanesAlgorithm(profits[i]);
			assertEquals(kadaneResults[i][0], correctAnswers[i][0]);
			assertEquals(kadaneResults[i][1], correctAnswers[i][1]);
			assertEquals(kadaneResults[i][2], correctAnswers[i][2]);
		}
	}

	
	/* Testing different simple test cases	 */
	@Test
	void testSimple() {
		// test case 1
		long testCase1[] = { -2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6 };
		long[] answerTestCase1 = { 19, 2, 10 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase1);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase1[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase1, 0, testCase1.length - 1);
		assertEquals(answerTestCase1[1], DACResults[0][0]);
		assertEquals(answerTestCase1[2], DACResults[0][1]);
		assertEquals(answerTestCase1[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(testCase1);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase1[i], kadaneResults[0][i]);

		// test case 2
		long testCase2[] = { -3, -4, -5, -6, -7, -8, -9, -10, 0, 0, -1 };
		long[] answerTestCase2 = { 0, -1, -1 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase2);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase2[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase2, 0, testCase2.length - 1);
		assertEquals(answerTestCase2[1], DACResults[0][0]);
		assertEquals(answerTestCase2[2], DACResults[0][1]);
		assertEquals(answerTestCase2[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(testCase2);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase2[i], bruteForceResults[0][i]);

		// test case 3
		long testCase3[] = { -3, -4, -5 };
		long[] answerTestCase3 = { 0, -1, -1 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase3);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase3[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase3, 0, testCase3.length - 1);
		assertEquals(answerTestCase3[1], DACResults[0][0]);
		assertEquals(answerTestCase3[2], DACResults[0][1]);
		assertEquals(answerTestCase3[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(testCase3);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase3[i], bruteForceResults[0][i]);

		// test case 4
		long testCase4[] = { 1, 1, 2 };
		long[] answerTestCase4 = { 4, 0, 2 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase4);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase4[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase4, 0, testCase4.length - 1);
		assertEquals(answerTestCase4[1], DACResults[0][0]);
		assertEquals(answerTestCase4[2], DACResults[0][1]);
		assertEquals(answerTestCase4[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(answerTestCase4);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase4[i], bruteForceResults[0][i]);

		// test case 5
		long testCase5[] = { 1, -3, 4, 1 };
		long[] answerTestCase5 = { 5, 2, 3 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase5);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase5[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase5, 0, testCase5.length - 1);
		assertEquals(answerTestCase5[1], DACResults[0][0]);
		assertEquals(answerTestCase5[2], DACResults[0][1]);
		assertEquals(answerTestCase5[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(answerTestCase5);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase5[i], bruteForceResults[0][i]);
		
		long testCase6[] = { -1, -3, -4, -1 };
		long[] answerTestCase6 = { 0, -1, -1 };
		bruteForceResults[0] = BruteForce.bruteForceFindMaxSubArr(testCase6);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase6[i], bruteForceResults[0][i]);
		DACResults[0] = DivideAndConquer.findMaxSubarray(testCase6, 0, testCase6.length - 1);
		assertEquals(answerTestCase6[1], DACResults[0][0]);
		assertEquals(answerTestCase6[2], DACResults[0][1]);
		assertEquals(answerTestCase6[0], DACResults[0][2]);
		kadaneResults[0] = Kadane.kadanesAlgorithm(answerTestCase6);
		for (int i = 0; i < 3; i++)
			assertEquals(answerTestCase6[i], bruteForceResults[0][i]);
	}

	//The tests for different sizes of randomly generated arrays for brute force method
	@Test
	void randomBruteForce() {
		System.out.println("\n=====Brute Force=====");
		Random random = new Random();
		double startTime = 0, endTime = 0, runTime = 0, elapsedTime = 0;
		random.setSeed(20);

		long integer, randomArray[];
		int size = 100;
		randomArray = new long[size];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}

		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10.0);

		size = 200;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10.0);

		size = 500;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 1000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 2000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 4000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 5000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		size = 6000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		size = 8000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 10000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 12000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 14000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 16000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 18000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 20000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			bruteForceResults[i] = BruteForce.bruteForceFindMaxSubArr(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run brute force method (n = %d): %.2f ms\n", size, elapsedTime / 10);
	}

	//The tests for different sizes of randomly generated arrays for divide and conquer
	@Test
	void randomDivideAndConquer() {
		System.out.println("\n=====Divide And Conquer=====");
		Random random = new Random();
		double startTime = 0, endTime = 0, runTime = 0, elapsedTime = 0;
		random.setSeed(20);
		int size;
		long integer, randomArray[];
		size = 100;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10.0);

		size = 200;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 500;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 1000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 2000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);
		
		size = 4000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 5000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 6000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 8000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 10000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 12000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 14000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);

		size = 16000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);
		
		size = 18000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);
		
		size = 20000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			DACResults[i] = DivideAndConquer.findMaxSubarray(randomArray, 0, size - 1);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to run divide and conquer algorithm (n = %d): %.2f ms\n", size,
				elapsedTime / 10);
	}

	//The tests for different sizes of randomly generated arrays for kadane's algorithm
	@Test
	void randomKadane() {
		System.out.println("\n=====Kadane's Algorithm=====");
		Random random = new Random();
		double startTime = 0, endTime = 0, runTime = 0, elapsedTime = 0;
		random.setSeed(20);
		int size;
		long integer, randomArray[];
		size = 100;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			// Kadane.print(kadaneResults[i]);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 200;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 500;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 1000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 2000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 4000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 5000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;

			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);

			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 6000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 8000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 10000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 12000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 14000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);

		size = 16000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 18000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);
		
		size = 20000;
		randomArray = new long[size];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < size; j++) {
				integer = random.nextInt();
				randomArray[j] = integer;
			}
			startTime = System.currentTimeMillis();
			kadaneResults[i] = Kadane.kadanesAlgorithm(randomArray);
			endTime = System.currentTimeMillis();
			runTime = endTime - startTime;
			elapsedTime += runTime;
		}
		System.out.printf("Average time to Kadane's algorithm (n = %d): %.2f ms\n", size, elapsedTime / 10);
	}
}
