/**
*@author David Garner
*@version 1.0
*
*
*I used Java in this example for two reasons: first, Java is the language
*in which I am most comfortable programming. Second, as Cascade is Java
*based, it is beneficial to demonstrate any aptitude whatsoever in its
*implementation.
*
*
*/

import java.util.ArrayList;
import java.lang.Math.*;

public class Prime{

public static void main(String args[]){
	
	/*
	* Create a list of primes up to 10,000
	* and run the test to determine whether
	* Secret is additive
	*/
	ArrayList<Integer> primes = primality(10000);
	boolean additive = isAdditive(primes);
	
	System.out.println(additive);
}

/**
* Finds all prime numbers from 0 to a given upper limit
* @param n The range of numbers to be looked at
* @return A list of all prime numbers within the specified range
*/
public static ArrayList<Integer> primality(int n){

	boolean isPrime;

	ArrayList<Integer> prime = new ArrayList<>();

	/*
	*The numbers 2, 3, 5, and 7 are established as
	*base cases to save time
	*/
	prime.add(2);
	prime.add(3);
	prime.add(5);
	prime.add(7);
	
		/*
		*Only look at odd numbers.
		*/
	for(int i = 11; i<n; i+=2){

		double root = Math.sqrt(i);
		isPrime = true;

		/*
		*Only compare numbers against primes that we
		*have previously encountered. Any odd non-prime
		*natural number can be divided cleanly against a
		*prime less than or equal to its square root.
		*/
		for(int j=1; j<prime.size(); j++){

			/*
			*The primality of a number can be determined
			*up to the square root of the number. If we
			*have not found a divisor by this point, we
			*know that the number in question is prime.
			*
			*Additionally, if the number in question is a
			*perfect square, we have nothing to do.
			*/
			if((prime.get(j) > root) || (prime.get(j)%root==0))
				break;
	
			if(i%prime.get(j) == 0){
				isPrime = false;
				break;
			}
		}

		if(isPrime == true)
			prime.add(i);
	}

	return prime;
}

/**
*Determines whether the function Secret is additive
*@param arr A list of primes up to a given number N
*@return A boolean stating whether the function Secret is additive
*/
public static boolean isAdditive(ArrayList<Integer> arr){
	
	boolean additive = true;
	
	/*
	*A nested for loop iterates through each element in
	*the list to test against all combinations of the
	*list of primes. Computation time of this operation,
	*not including the Secret functions themselves, is
	*equivalent to the average case of a reversed Insertion
	*sort.
	*/
	for(int i=0; i<(arr.size()); i++){
		for(int j=(i+1); j<(arr.size()); j++){
			int x = arr.get(i);
			int y = arr.get(j);
			
			/*
			* One case is all we need to determine that 
			* the function in question is not additive
			*/
			if(Secret(x+y) != (Secret(x) + Secret(y))){
				additive = false;
				break;
			}
		}

		if(additive==false)
			break;
	}
	
	return additive;
}

}