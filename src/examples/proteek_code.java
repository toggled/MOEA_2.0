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
public class proteek_code {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//configure and run this experiment
		//String problem = {"DTLZ1_2"};
		String[] problems = {"DTLZ1_5","DTLZ1_10","DTLZ1_20","DTLZ1_30","DTLZ1_40",
				"DTLZ2_5","DTLZ2_10","DTLZ2_20","DTLZ2_30","DTLZ2_40",
				"DTLZ3_5","DTLZ3_10","DTLZ3_20","DTLZ3_30","DTLZ3_40",
				"DTLZ4_5","DTLZ4_10","DTLZ4_20","DTLZ4_30","DTLZ4_40",
				"DTLZ7_5","DTLZ7_10","DTLZ7_20","DTLZ7_30","DTLZ7_40"};
		
		
		String[] algorithms = {"MOEAD", "GDE3", "eMOEA","eNSGAII"};
		String M2=null;
		int j,k,i2,i3,r,M,functionEval;

		
		NondominatedPopulation result;
		double [] fit=new double [5];
		File file = null;
		Writer output = null;
		String text=null;
		for (i2=0;i2<algorithms.length;i2++)
		{
			for(i3=0;i3<problems.length;i3++)
			{
				M2=problems[i3].substring(5);
				M=Integer.parseInt(M2);
				if(i3>=10 && i3<=14)
					{functionEval=100000;}
				else
					{functionEval=30000;}
				
				file = new File(problems[i3].substring(0,4).toLowerCase()+"_"+algorithms[i2].toLowerCase()+"_"+M2+".txt");
				
				try {output = new BufferedWriter(new FileWriter(file));}
				catch (IOException e) {e.printStackTrace();}
				text="";
				for (r=0;r<10;r++)
				{
					System.out.println("Algorithm = "+ algorithms[i2]+ ", Problem = "+ problems[i3] + ", Dim = "+M2 );
					result = new Executor()
						.withProblem(problems[i3])
						 .withAlgorithm(algorithms[i2])
						 .withMaxEvaluations(functionEval)
						 .withProperty("populationSize", 100)
						 .distributeOnAllCores()
						 .run();
							 /*.withProperty("sbx.rate", 1)
							 .withProperty("sbx.distributionIndex", 15.0)
							 .withProperty("pm.rate", 0.02)
							 .withProperty("pm.distributionIndex", 20.0)
							 .distributeOnAllCores()
							 .run();*/
							/*result = new Executor()
							 .withProblem("WFG1_32")
							 .withAlgorithm("NSGAII")
							 .withMaxEvaluations(30000)
							 .withProperty("populationSize", 100)
							 .withProperty("sbx.rate", 1)
							 .withProperty("sbx.distributionIndex", 15.0)
							 .withProperty("pm.rate", 0.02)
							 .withProperty("pm.distributionIndex", 20.0)
							 .distributeOnAllCores()
							 .run();*/
		
				    j=0;
				    for (Solution solution : result) 
					{
				    	j++;
						fit=solution.getObjectives();				
						text = text + Double.toString(fit[0]);
						for(k=1;k<M;k++)
						{
							text = text + " " + Double.toString(fit[k]);				
						}
						text=text+"\n";  
					    System.out.println(" j = "+j+", Population Size = "+result.size());
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
