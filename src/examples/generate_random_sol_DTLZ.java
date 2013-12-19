/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        // TODO code application logic here
        int number_of_objective=2;
        int numberofpoints = 1000;
        int dtlzwhat=7;
    
        String filename=System.getProperty("user.dir")+"/src/pf/DTLZ"+Integer.toString(dtlzwhat) +"_"+Integer.toString(number_of_objective)+"D"+".pf";
        //System.out.println("filename: "+filename);
        double [] objective_value;
        Class [] paramTypes = { int.class, int.class }; // DTLZ(int,int) 
        Object []paramValues=new Object[]{number_of_objective};
        
        Class <?> clazz=Class.forName("org.moeaframework.problem.DTLZ.DTLZ"+dtlzwhat); //invoke class
        System.out.println("invoking class: "+clazz.getName());
        
        Constructor<?> ctor=clazz.getConstructor(paramTypes); // create constructor 
        
        //System.out.println(ctor.getName());
        Object o=ctor.newInstance(paramValues); //create new instance calling the constructor with arguments.
        DTLZ dt=(DTLZ)o;
       
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
