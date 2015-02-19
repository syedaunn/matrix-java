package advprog.lab1;


import java.util.ArrayList;

public class matrix {

	/**
	 * @param args
	 * @author Aunn Raza
	 */
	
	/* Method: printMatrix
	 * Arguments: Matrix as ArrayList of ArrayList
	 * Description: Prints the given matrix to the standard output stream
	 */
	public static void printMatrix(ArrayList<ArrayList<Integer>> matrixA){
		for (ArrayList<Integer> row : matrixA) {
			System.out.print("| ");
			for (Integer elem : row) {
				System.out.print(elem + " ");
			}
			System.out.print("|\n");
		}

	}

	/* Method: matrixAddition
	 * Arguments: two matrices as ArrayList of ArrayList
	 * Description: Addition Matrix B to A and returns the result
	 */
	public static ArrayList<ArrayList<Integer>> matrixAddition(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB){
		if((matrixA.size() != matrixB.size()) || (matrixA.get(0).size() != matrixB.get(0).size())){
			System.err.println("Error: Matrix Dimension Mismatch");
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		try{
			for (int i = 0; i < matrixA.size(); i++) {
				ArrayList<Integer> resRow = new ArrayList<Integer>();
				ArrayList<Integer> aRow = matrixA.get(i);
				ArrayList<Integer> bRow = matrixB.get(i);
				for (int j = 0; j < matrixA.get(0).size(); j++) {
					resRow.add(bRow.get(j)+aRow.get(j));
				}
				result.add(resRow);
			}
		}catch (IndexOutOfBoundsException e){
			System.err.println("Error: "+ e.getMessage());

		}
		return result;

	} 

	/* Method: matrixSubraction
	 * Arguments: two matrices as ArrayList of ArrayList
	 * Description: Subract Matrix B from A and returns the result
	 */
	public static ArrayList<ArrayList<Integer>> matrixSubraction(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB){
		if((matrixA.size() != matrixB.size()) ){
			System.err.println("Error: Matrix Dimension Mismatch");
			return matrixA;
		}
		if(matrixA.isEmpty() || matrixB.isEmpty() ||  (matrixA.get(0).size() != matrixB.get(0).size())){	
			System.err.println("Error: Matrix Dimension Mismatch");
			return matrixA;
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(matrixA.size()<1 && matrixA.get(0).size()<1){
			System.out.println("MatA m:"+matrixA.size() +"  n:"+matrixA.get(0).size());
			System.out.println("MatA m:"+matrixB.size() +"  n:"+matrixB.get(0).size());
			
			}
		try{
			for (int i = 0; i < matrixA.size(); i++) {
				ArrayList<Integer> resRow = new ArrayList<Integer>();
				ArrayList<Integer> aRow = matrixA.get(i);
				ArrayList<Integer> bRow = matrixB.get(i);
				for (int j = 0; j < matrixA.get(0).size(); j++) {
					resRow.add(aRow.get(j)-bRow.get(j));
				}
				result.add(resRow);
			}
		}catch (IndexOutOfBoundsException e){
			System.err.println("Error: "+ e.getMessage());

		}
		return result;

	} 
	
	/* Method: matrixMultiplication
	 * Arguments: two matrices as ArrayList of ArrayList
	 * Description:  Multiply Matrix A with B and returns the result
	 */	
	public static ArrayList<ArrayList<Integer>> matrixMultiplication(ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB)  
			{  
		int size = matrixA.size();
		ArrayList<ArrayList<Integer>> a,b,c,d,e,f,g,h,i,j,k,l,m,n;
		ArrayList<ArrayList<Integer>> s1,s2,s3,s4,s5,s6,s7;
		ArrayList<ArrayList<Integer>> matrixRes;
		//intializeList(s1,size/2);
		//intializeList(s2,size/2);
		//intializeList(s3,size/2);
		//intializeList(s4,size/2);
		//intializeList(s5,size/2);
		//intializeList(s6,size/2);
		//intializeList(s7,size/2);
		

		//submatrix for first
		if(size>1){
		a = submatrix(matrixA,0,0);
		b = submatrix(matrixA,0,1);  
		c = submatrix(matrixA,1,0);  
		d = submatrix(matrixA,1,1);  
		//Submatrix for second
		e = submatrix(matrixB,0,0);  
		f = submatrix(matrixB,0,1);  
		g = submatrix(matrixB,1,0);  
		h = submatrix(matrixB,1,1);  


		m =matrixSubraction(f, h);  //f-h
		s1 = matrixMultiplication(a,m);    //s1  

		m =matrixAddition(a, b);//add(a,b,m,size/2);          //a+b  
		s2 =matrixMultiplication(m,h);  

		m = matrixAddition(c, d);//add(c,d,m,size/2);          //c+d  
		s3 =matrixMultiplication(m,e);  

		m = matrixSubraction(g, e);	//sub(g,e,m,size/2);          //g-e  
		s4 = matrixMultiplication(d,m);  

		m = matrixAddition(a, d);//add(a,d,m,size/2);          //a+d  
		n = matrixAddition(e, h);//add(e,h,n,size/2);          //e+h  
		s5 = matrixMultiplication(m,n);  

		m = matrixSubraction(b, d);//sub(b,d,m,size/2);          //b-d  
		n = matrixAddition(g, h);//add(g,h,n,size/2);          //g+h  
		s6 = matrixMultiplication(m,n);  

		m = matrixSubraction(a, c);//sub(a,c,m,size/2);          //a-c  
		n = matrixAddition(e, f);//add(e,f,n,size/2);          //e+f  
		s7 = matrixMultiplication(m,n);  

		i = matrixAddition(s5, s6);//add(s5,s6,i,size/2);  
		i = matrixAddition(s4, i);//add(i,s4,i,size/2);  
		i = matrixSubraction(i, s2);//sub(i,s2,i,size/2);     //i  
		j = matrixAddition(s1, s2);//add(s1,s2,j,size/2);    //j  
		k = matrixAddition(s3, s4);//add(s3,s4,k,size/2);    //k  
		l = matrixAddition(s5, s1);//add(s5,s1,l,size/2);  
		l = matrixSubraction(l, s7);//sub(l,s7,l,size/2);  
		l = matrixSubraction(l, s3);//sub(l,s3,l,size/2);     //l  
		matrixRes = join(i,j,k,l,size);
		}else{
			matrixRes = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> row = new ArrayList<Integer>();
			row.add(matrixA.get(0).get(0) * matrixB.get(0).get(0));
			matrixRes.add(row);
		}
		return matrixRes;

			}
    
    private static ArrayList<ArrayList<Integer>> submatrix(ArrayList<ArrayList<Integer>> mat,int m,int n)  
    {   
    	int size = mat.size();
    	ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>(); 
    	for(int i=0;i<size/2;i++){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for(int j=0;j<size/2;j++)  
    			row.add(mat.get((size/2*m)+i).get((size/2*n)+j));
    		Result.add(row);
    	}
    	return Result;
    }
    
    private static ArrayList<ArrayList<Integer>> join(ArrayList<ArrayList<Integer>> a,
    		ArrayList<ArrayList<Integer>> b,
    		ArrayList<ArrayList<Integer>> c,ArrayList<ArrayList<Integer>> d 
    		,int size)  
    {  
    	

    	int i,j;
    	ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>(); 
    	for( i=0;i<size/2;i++){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for( j=0;j<size/2;j++){  
    			row.add(a.get(i).get(j));
    		}
    		for( j=size/2;j<size;j++){  
    			row.add(b.get(i).get(j-(size/2)));
    		}
    		Result.add(row);
    	}
    	for( i=size/2;i<size;i++){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for( j=0;j<size/2;j++){  
    			row.add(c.get(i-(size/2)).get(j));
    		}
    		for( j=size/2;j<size;j++){  
    			row.add(d.get(i-(size/2)).get(j-(size/2)));
    		}
    		Result.add(row);
    	}
   	

   	return Result;  
    }
    

	
}
