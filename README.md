#Class - Matrix
##Author: Aunn Raza | BSCS2B | 01248

Matrix Class provides basic matrix operations functionality that is addition, subtraction and multiplication.

#Matrix Operations (Methods)

Following are the prototypes of class methods and there description.
##matrixAddition(matrixA , matrixB) 
Matrix Addition takes two matrices as argument and perform addition position wise of the given two matrices and returns the matrix as (ArrayList of ArrayList).
##matrixSubraction(matrixA , matrixB) 
Matrix Subtraction takes two matrices as argument and subtracts matrix B from matrix A and returns the result.
##matrixMultiplication(matrixA , matrixB)
Matrix Multiplication takes two matrix as arguments, checks if there dimensions are correct for multiplication and finally perform matrix multiplication using Strassens Algorithm (divided and conquer) and returns the result.
##PrintMatrix(Matrix)
Print Matrix takes a matrix as arguments and prints out the matrix in standard matrix notation to standard output stream.

#Testing (JUnit Test Cases)
 
Validation testing of Class Matrix was performed by JUnit Test Cases. Different test cases were developed in the JUnit Class MatrixTest.
Set up phase of testing takes a file and number of matrices to be read from file to populate list of matrices on which test operations are to be performed.
Following are the some test cases used to validate the correctness and error handling of the class Matrix.
##testMatrixAddition()
In this test case, three matrices are added which are taken from the matrix list created in the setup phases and asserts the output with the exact results.
##testMatrixMultiplication()
This test case checks the correctness of the matrix multiplication operation by taking two matrices from the matrix list, performing matrix multiplication and asserting the output from the expected output.
##testMatrixMulThenAdd()
This test checks for different execution path and matrix format consistency in consecutive operations. This test firstly multiples the first two matrix in the matrix list and then adds the third matrix in the list. Assertion is performed with the expected output to check the correctness of the class.
