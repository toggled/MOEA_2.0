package org.moeaframework.problem.WFG;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;




/**
 * Demonstrates how a new problem is defined and used within the MOEA
 * Framework.
 */
public class wfg_problems_proteek {

	/**
	 * Implementation of the WFG function with different parameter.
	 */
	public static class MyWFG1 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG1() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG1(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG1(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG2 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG2() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG2(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG2(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG3 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG3() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG3(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG3(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG4 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG4() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG4(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG4(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG5 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG5() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG5(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG5(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG6 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG6() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG6(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG6(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG7 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG7() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG7(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG7(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG8 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG8() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG8(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG8(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static class MyWFG9 extends AbstractProblem {

		protected int k;// The number of position-related variables defined by this problem.
		protected int l;// The number of distance-related variables defined by this problem.
		protected int M;// The number of objectives defined by this problem.

		public MyWFG9() {
			super(50, 2);
			this.k = 36;
			this.l = 14;
			this.M = 2;
		}
		public MyWFG9(int k, int l, int M) {
			super(k+l, M);
			this.k = k;
			this.l = l;
			this.M = M;
		}

		@Override
		public Solution newSolution() {
			Solution solution = new Solution(k + l, M);

			for (int i = 0; i < k + l; i++) {
				solution.setVariable(i, new RealVariable(0.0, 2.0 * (i + 1)));
			}

			return solution;
		}
		@Override
		public void evaluate(Solution solution) {
			double[] v = EncodingUtils.getReal(solution);
			double[] f = Problems.WFG9(v, k, M);
			solution.setObjectives(f);
		}
	}
	public static void main(String[] args) {
		
		Object[] obj = new Object[9];
		obj[0] = new MyWFG1();
		obj[1] = new MyWFG2();
		obj[2] = new MyWFG3();
		obj[3] = new MyWFG4();
		obj[4] = new MyWFG5();
		obj[5] = new MyWFG6();
		obj[6] = new MyWFG7();
		obj[7] = new MyWFG8();
		obj[8] = new MyWFG9();
		
		
		//String[] problems = {"wfg1","wfg2","wfg3","wfg4","wfg5","wfg6","wfg7","wfg8","wfg9"};
                String[] problems = {"wfg1","wfg2"};
		//String[] algorithms = {"eNSGAII","MOEAD", "GDE3", "eMOEA","NSGAII"};
                String[] algorithms = {"NSGAII"};
		int [] dim={2,3,5,7,10,13,19};
		int j,k,i,r,M,i2,i3,l;
		
		
		NondominatedPopulation result;
		double [] fit;
		File file = null;
		Writer output = null;
		String text=null;
		
		i=0;
		i2=7;
		i3=5;
		for(i=3;i<algorithms.length;i++)
		{
		
			for(i2=0;i2<problems.length;i2++)
			{
				for(i3=0;i3<dim.length-1;i3++)
				{			
					M= dim[i3];
					
					file = new File(problems[i2]+"_"+algorithms[i].toLowerCase()+"_"+M+".txt");
			
					try {output = new BufferedWriter(new FileWriter(file));}
					catch (IOException e) {e.printStackTrace();}
					text="";
					for (r=0;r<10;r++)
					{
						result = new Executor()
							 .withProblemClass(obj[i2].getClass(),36,14,M)
							 .withAlgorithm(algorithms[i])
							 .withMaxEvaluations(25000)
							 .withProperty("populationSize", 100)
							 .distributeOnAllCores()
							 .run();
									
					    j=0;
					    //for (Solution solution : result) 
					    Solution solution= null;
						for(l=result.size()-1;l>=0;l--)
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
					    try 
						{
							System.out.println("Total Size = "+text.length()+"\n");
							output.write(text.toLowerCase());
							
						}
					    catch (IOException e) {e.printStackTrace();}
					}
					try{ output.close();}
					catch (IOException e) {e.printStackTrace();}
				}
			}
		}
		System.out.println("Done");
		
		
		
		
		
		
		
		
		
		/*
		//configure and run the DTLZ2 function
		Object obj =new MyWFG1(36,14,10);
		//mywfg.setNumberOfObjectives(10);
		NondominatedPopulation result = new Executor()
				//.withProblemClass(MyWFG1.class,36,14,10) //MyWFG1.class)
				.withProblemClass(obj.getClass(),36,14,10)
				.withAlgorithm("NSGAII")
				.withMaxEvaluations(10000)
				.run();
				
		
		//display the results
		for (Solution solution : result) 
		{
			for (int i=0;i<10;i++)
			{
				System.out.print(solution.getObjective(i));
				System.out.print(' ');
			}
			System.out.println("\n");
		}*/
	}
	
}
