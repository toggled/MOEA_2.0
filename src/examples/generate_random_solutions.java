/* Copyright 2009-2012 David Hadka
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

import java.io.*;

import org.moeaframework.core.PRNG;

import org.moeaframework.core.Solution;

//import org.moeaframework.core.variable.RealVariable;

import org.moeaframework.problem.WFG.*;
import org.moeaframework.problem.WFG.WFG1;
import org.moeaframework.problem.WFG.WFG2;
import org.moeaframework.problem.WFG.WFG3;
import org.moeaframework.problem.WFG.WFG4;
import org.moeaframework.problem.WFG.WFG5;
import org.moeaframework.problem.WFG.WFG6;
import org.moeaframework.problem.WFG.WFG7;
import org.moeaframework.problem.WFG.WFG8;
import org.moeaframework.problem.WFG.WFG9;
import org.moeaframework.problem.WFG.*;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;


/* This code is based on the Walking Fish Group implementation.
 * 
 * Copyright 2005 The Walking Fish Group (WFG).
 *
 * This material is provided "as is", with no warranty expressed or implied.
 * Any use is at your own risk. Permission to use or copy this software for
 * any purpose is hereby granted without fee, provided this notice is
 * retained on all copies. Permission to modify the code and to distribute
 * modified code is granted, provided a notice that the code was modified is
 * included with the above copyright notice.
 *
 * http://www.wfg.csse.uwa.edu.au/
 */
class generate_random_solutions {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private generate_random_solutions() {
		super();
	}


public static void main(String[] args) throws IOException
{
		//configure and run this experiment
		//NondominatedPopulation result = new Executor()
		//		.withProblem("UF1")
		//		.withAlgorithm("NSGAII")
		//		.withMaxEvaluations(10000)
		//		.distributeOnAllCores()
		//		.run();
		
		//display the results
		//for (Solution solution : result) {
		//	System.out.println(Arrays.toString(solution.getObjectives()));
		//	System.out.println("Number of coauthors: Number of persons");
			
			int i,j;
			int k=2;
			int l=4;
			//int n=k+l;
			int M=2;
			double [] fit;
			WFG1 wfg = new WFG1(k,l,M);
			Solution sol_wfg=null;
			File file = new File("wfg1_pf_2_java.pf");
			Writer output = null;
			String text=null;
		    output = new BufferedWriter(new FileWriter(file));
			

		    	//sol_wfg = new Solution(fit);
				//double[] v = EncodingUtils.getReal(sol_wfg);
				//double[] f = Problems.WFG6(v, k, M);
				//sol_wfg.setObjectives(f);


				//Solution solution = newSolution();
				//EncodingUtils.setReal(solution,
					//	Solutions.WFG_2_thru_7_random_soln(k, l));
				//evaluate(solution);
				//return solution;
		    
		    text="";
			for(j=0;j<1000;j++)
			{
				sol_wfg=wfg.generate();
				fit=sol_wfg.getObjectives();				
				text = text + Double.toString(fit[0]);
				for(i=1;i<fit.length;i++)
				{
					text = text + " " + Double.toString(fit[i]);
					
				}
				text=text+"\n";
			    
			    System.out.println(j);
			    System.out.println("\n");

			}
			output.write(text);
		    output.close();
			System.out.println("Done");
			
		
}

}//close class