package riddleSequence;

import java.util.ArrayList;

public class iterationSolutions {

	private ArrayList<String> solutions = new ArrayList<String>();
	
	public void addIterationSolution(ArrayList<String> val)
	{
		String solution = String.join("", val);
		
		solutions.add(solution);
	}
	
	public void printReset()
	{
		System.out.print(solutions.size() + "\t");
		
		for(String sol: solutions)
		{
			System.out.print(sol + "  ");
		}
			
		System.out.println();
		solutions.clear();
	}
}
