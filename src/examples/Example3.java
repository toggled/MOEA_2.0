/* Copyright 2009-2013 David Hadka
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
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Set;
import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.core.Solution;

/**
 * Demonstrates the use of the {@code Instrumenter} to collect run-time
 * dynamics.  The output lists the NFE, elapsed time and generational distance
 * throughout the run.
 */
public class Example3 {
	
	public static void main(String[] args) throws IOException {
            /*
		Instrumenter instrumenter = new Instrumenter()
				.withReferenceSet(new File("/home/andy/Desktop/MOEAFramework-2.0/pf/UF1.dat"))
				.withFrequency(100)
				.attachElapsedTimeCollector()
				.attachGenerationalDistanceCollector();
             * */
             
                                
                Instrumenter insall=new Instrumenter()
                            .withReferenceSet(new File("/home/andy/Desktop/MOEAFramework-2.0/pf/UF1.dat"))
                             .withFrequency(100)
                             .attachAll();
               
		
                /*
		new Executor()
				.withProblem("UF1")
				.withAlgorithm("NSGAII")
				.withMaxEvaluations(1000)
				.withInstrumenter(instrumenter)
				.run();
                 
                    Accumulator accumulator = instrumenter.getLastAccumulator(); 
                
		for (int i=0; i<accumulator.size("NFE"); i++) {
			System.out.println(accumulator.get("NFE", i) + "\t" + 
					accumulator.get("Elapsed Time", i) + "\t" +
					accumulator.get("GenerationalDistance", i));
		}
                 
                 */
                                new Executor().withProblem("UF1")
                                .withAlgorithm("NSGAII")
                                .withMaxEvaluations(1000)
                               .withInstrumenter(insall)
                                .run();
                
                 
                Accumulator accumulator = insall.getLastAccumulator();
                System.out.println(accumulator.keySet());
                Set s = accumulator.keySet();
                
                String [] keys= (String[]) s.toArray(new String[s.size()]);
                for (int j = 0; j < accumulator.size("NFE"); j++) {
                    //System.out.print(accumulator.get("NFE", j));
                    for (int i = 0; i < keys.length; i++) {
                        String string = keys[i];
                        switch(string)
                        {
                            case "Approximation Set":
                                ArrayList sol=(ArrayList) accumulator.get(string, j);
                                for (int k = 0; k < sol.size(); k++) {
                                    System.out.print(k+":");
                                    Solution sl=(Solution) sol.get(k);
                                    for (int m = 0; m < sl.getNumberOfObjectives(); m++) {
                                        System.out.print(sl.getObjective(m)+" ");
                                    }
                                    System.out.println();
                                }
                                
                                break;
                            default:
                                System.out.println(string+": "+accumulator.get(string,j));
                        }
                        
                    }
                   
                    System.out.println();
                
                }
                

	}

}
