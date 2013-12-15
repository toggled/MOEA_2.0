/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

import org.moeaframework.core.Solution;
import org.moeaframework.problem.DTLZ.*;

/**
 *
 * @author andy
 */
class generate_random_sol_DTLZ {

    public generate_random_sol_DTLZ() {
        super();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int number_of_objective=2;
        int number_of_decvars=number_of_objective+9;
        int numberofpoints = 1000;
        int dtlzwhat=3;
        
        
        String filename="/home/andy/Desktop/MOEAFramework-2.0/pf/DTLZ"+Integer.toString(dtlzwhat) +"_"+Integer.toString(number_of_objective)+"D"+".pf";
        double [] objective_value;
        DTLZ dt=new DTLZ2(number_of_decvars,number_of_objective);
        Solution sol=null;
        File file = new File(filename);
	Writer output = null;
	String text=null;
	output = new BufferedWriter(new FileWriter(file));
        text="";
        for(int j=0;j<numberofpoints;j++){
            sol=dt.generate();
            objective_value=sol.getObjectives();				
            for(int i=0;i<objective_value.length;i++){
		text = text + " " + Double.toString(objective_value[i]);
					
            }
            text=text+"\n";
            //System.out.println(j);
            //System.out.println("\n");
        }
	output.write(text);
	output.close();
    }
}
