package cs146F22.Nguyen.project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 1. Variables
	Method Variables
	(long) variable needed for line #, day number, case number, and file column - lineCount, dayNumber, caseNumber
	(long [][]) variable needed to save profits from array - profits
	(String) variable needed temporarily when tokenizing line
	(StringTokenizer) variable needed to start tokenizing lines - st
2. Input
	none
3. Processing
	Open file, file reader, and buffered reader
	while not end of file, read each line
		tokenize each line 
			1st token is the student id
			try to save student id
			try to save quiz scores
		loop and go to next line
 */

public class Utility {

	public Utility() {
	}

	public static long[][] readFile(String filename) {
		int lineCount = 0, dayNumber = 0, caseNumber = 0;
		long[][] profits = new long[10][103];
		String profit = "";
		try {
			FileReader file = new FileReader(filename); // Open the file using FileReader Object.
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine(); // In a loop read a line using readLine method.
				lineCount++;
				if (line == null)
					eof = true;
				else {
					if (lineCount % 2 == 0)
						;// do nothing if line number is even
					if (lineCount > 0 && line.length() > 0) {
						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreTokens()) {
							for (int fileColumn = 0; fileColumn < 103; fileColumn++) {
								profit = st.nextToken(); // get next part of token
								profits[caseNumber][dayNumber] = Integer.parseInt(profit); // convert string profit
																								// to integer

								dayNumber++;
							}
							caseNumber++;
							dayNumber = 0;
						}

					}
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}

		return profits;
	}
}
