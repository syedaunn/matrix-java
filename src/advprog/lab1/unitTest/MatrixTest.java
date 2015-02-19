package advprog.lab1.unitTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advprog.lab1.matrix;

public class MatrixTest {

	List<ArrayList<ArrayList<Integer>>> matrices; 
	
	@Before
	public void setUp() throws Exception {
		String filename = "/home/aunn/Desktop/testFile";
		int numOfMatrix = 3;
		matrices = readFromFile(filename, numOfMatrix);
		
	}

	@After
	public void tearDown() throws Exception {
		matrices.clear();
	}

	@Test
	public void testMatrixAddition() {
		int n =4;
		int m =4;
		//Construct the exact result matrix as exactResult
		ArrayList<ArrayList<Integer>> exactResult = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(3);
			row.add(6);
			row.add(9);
			row.add(12);
			exactResult.add(row);
		}
		//Calculate result from the new code written
		ArrayList<ArrayList<Integer>> calculatedResult;
		calculatedResult= matrix.matrixAddition(matrices.get(0), matrices.get(1));
		calculatedResult= matrix.matrixAddition(calculatedResult, matrices.get(2));
		//Check for correctness
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				assertEquals(exactResult.get(i).get(j) ,calculatedResult.get(i).get(j));
			}
		}

	
	}

	@Test
	public void twoMultiplyoneAdd() {
		int n =4;
		int m =4;
		//Construct the exact result matrix as exactResult
		ArrayList<ArrayList<Integer>> exactResult = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(11);
			row.add(22);
			row.add(33);
			row.add(44);
			exactResult.add(row);
		}
		//Calculate result from the new code written
		ArrayList<ArrayList<Integer>> calculatedResult;
		calculatedResult= matrix.matrixMultiplication(matrices.get(0), matrices.get(1));
		calculatedResult= matrix.matrixAddition(calculatedResult, matrices.get(2));
		//Check for correctness
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				assertEquals(exactResult.get(i).get(j) ,calculatedResult.get(i).get(j));
			}
		}
	}

	@Test
	public void testMatrixMultiplication() {
		int n =4;
		int m =4;
		//Construct the exact result matrix as exactResult
		ArrayList<ArrayList<Integer>> exactResult = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(10);
			row.add(20);
			row.add(30);
			row.add(40);
			exactResult.add(row);
		}
		//Calculate result from the new code written
		ArrayList<ArrayList<Integer>> calculatedResult;
		calculatedResult= matrix.matrixMultiplication(matrices.get(0), matrices.get(1));
		//Check for correctness
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				assertEquals(exactResult.get(i).get(j) ,calculatedResult.get(i).get(j));
			}
		}
	}
	
	private List<ArrayList<ArrayList<Integer>>> readFromFile(String filename, int numOfMatrix){

		List<ArrayList<ArrayList<Integer>>> matList = new LinkedList<ArrayList<ArrayList<Integer>>>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(filename));

			for (int i = 0; i < numOfMatrix; i++) {
				String lineRead;
				ArrayList<ArrayList<Integer>> matrixA = new ArrayList<ArrayList<Integer>>();
				while ((lineRead = reader.readLine()) != null) {
					if (lineRead.trim().equals("")) {	//empty line
						break;
					} else {
						ArrayList<Integer> row = new ArrayList<Integer>();
						String[] lineArray = lineRead.split(",");
						for (String number : lineArray) {
							row.add(Integer.parseInt(number));
						}
						matrixA.add(row);
					}
				}
				matList.add(matrixA);
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return matList;

	}


}
