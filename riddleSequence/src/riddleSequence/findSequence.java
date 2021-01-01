package riddleSequence;

import java.math.BigInteger;
import java.util.ArrayList;

public class findSequence {

	public static boolean works(ArrayList<String> arg)
	{
		if(Integer.parseInt(arg.get(0)) == 0) //assume 0 is not a multiple of anything
			return false;
		
		for(int i = 0; i < arg.size(); i++)
		{
			if (!checkDivisibility(arg, i + 1))
				return false;
		}
		return true;

	}
	
	public static boolean checkDivisibility(ArrayList<String> arg, int num)
	{
		if(num == 0)
			return true;
		
		String temp = "";
		
		for(int i = 0; i < num; i++)
		{
			temp += arg.get(i);
		}
		BigInteger dividend = new BigInteger(temp);
		BigInteger modulus = dividend.mod(new BigInteger(String.valueOf(num)));
		
		if(modulus.equals(new BigInteger("0")))
			return true;
		
		return false;
	}
	
	public static void callPermutations(int n, iterationSolutions transfer)
	{
		ArrayList<String> numbers = new ArrayList<String>();
		
		for(int i = 0; i < n; i++)
		{
			numbers.add(String.valueOf(i));
		}
		
		permutations(numbers, new ArrayList<String>(), transfer);
	}
	
	public static void permutations(ArrayList<String> arg, ArrayList<String> perm, iterationSolutions transfer)
	{
		if (arg.size() == 0)
		{
            if(works(perm))
            {
            	transfer.addIterationSolution(perm);
            }
            return; 
        } 
		
		for(int i = 0; i < arg.size(); i++)
		{
			String digit = arg.get(i);
			
			ArrayList<String> remainder = (ArrayList<String>)arg.clone();
			remainder.remove(i);
			
			perm.add(digit);
			permutations(remainder, perm, transfer); 
			
			remainder.clear();
			perm.remove(perm.size() - 1);
		}
  
	}
	
	public static void main(String[] args) {

		final int numIterations = 15;
		
		iterationSolutions currentSolutions = new iterationSolutions();
		
		for(int n = 1; n <= numIterations; n++)
		{
			callPermutations(n, currentSolutions);
			
			System.out.print(n + "\t");
			currentSolutions.printReset();
		}
		System.out.println("Done");
	}

}