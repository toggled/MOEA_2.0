/* Copyright 2012 David Hadka
 * and Proteek Chandan Roy
 * 
 * This file is part of the MOEA Framework.
 * 
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or (at your 
 * option) any later version.
 * 
 * The MOEA Framework is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public 
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License 
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
//import java.util.Arrays;


import java.io.*;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;

/**
 * Demonstrates using an Executor to solve the UF1 test problem with NSGA-II,
 * one of the most widely-used multiobjective evolutionary algorithms.
 */
public class cec09_problems_proteek {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//configure and run this experiment
		//String problem = {"DTLZ1_2"};
		String[] problems = {"UF1","UF2","UF3","UF4","UF5","UF6","UF7","UF8","UF9","UF10","UF11","UF12","UF13"};
		
		
		String[] algorithms = {"eNSGAII","MOEAD", "GDE3", "eMOEA","NSGAII"};
		
		int j,k,i2,i3,r,M,functionEval;

		functionEval=30000;
		//functionEval=100000;//for UF12
		
		
		NondominatedPopulation result;
		double [] fit=new double [5];
		File file = null;
		Writer output = null;
		String text=null;
		
		i2=0;
		i3=0;
		r=0;
		r=r+1;
		
		for(i3=0;i3<problems.length;i3++)//i3=11;
		{
			if(i3<7)
				M=2;
			else if(i3<10)
				M=3;
			else
				M=5;
			//for (i2=0;i2<algorithms.length;i2++)
			{
				
				file = new File(problems[i3].toLowerCase()+"_"+algorithms[i2].toLowerCase()+".txt");
				
				try {output = new BufferedWriter(new FileWriter(file));}
				catch (IOException e) {e.printStackTrace();}
				text="";
				for (r=0;r<10;r++)
				{
					System.out.println("Algorithm = "+ algorithms[i2]+ ", Problem = "+ problems[i3]+ ", Run = "+ (r+1));
					result = new Executor()
						.withProblem(problems[i3])
						 .withAlgorithm(algorithms[i2])
						 .withMaxEvaluations(functionEval)
						 .withProperty("populationSize", 100)
						 .distributeOnAllCores()
						 .run();
							
		
					j=0;
				    //for (Solution solution : result) 
				    Solution solution= null;
					for(int l=result.size()-1;l>=0;l--)
				    {
						solution=result.get(l);
						fit=solution.getObjectives();				
						text = text + Double.toString(fit[0]);
						for(k=1;k<M;k++)
						{
							text = text + " " + Double.toString(fit[k]);				
						}
						text=text+"\n";  
					    System.out.println(" j = "+j+", Population Size = "+result.size());
					    j++;
					    if(j==100)
					    	break;
					}
				    text=text+"\n";
				    
				    System.out.println("\n");
				}
				try 
				{
					System.out.println("Total Size = "+text.length()+"\n");
					output.write(text.toLowerCase());
					output.close();
				}
			    catch (IOException e) {e.printStackTrace();}
			}
		}
			System.out.println("Done");
				//display the results
				//for (Solution solution : result) 
				//{
				//	System.out.println(Arrays.toString(solution.getObjectives()));
				//}

}

}
