import java.math.BigInteger;
import java.util.ArrayList;

import com.roberttimm.jmc.JMC;
import com.roberttimm.jmc.JMCCommand;
import com.roberttimm.jmc.JMCEntry;
import com.roberttimm.jmc.JMCInput;
import com.roberttimm.jmc.JMCMemory;

public class Main
{
	/**
	 * 
	 * Menu option callbacks
	 * ---------------------
	 * Allows the programmer to add custom actions to menu elements
	 *  and persist any processed data in memory.
	 *
	 */
	public static class MenuOption1 implements JMCCommand{

		@Override
		public String execute(ArrayList<JMCInput> inputs, JMCMemory memory) {
			
			String input1 = inputs.get(0).getInput();
			String input2 = inputs.get(1).getInput();
			
			// do something with the inputs
			
			// store the result in memory
			memory.add("input-1", input1);
			memory.add("input-2", input2);
			
			// report back to the user something!
			return "Inputs:\n"+
				"Input 1: "+ input1 +"\n"+
				"Input 2: "+ input2 +"\n"+
				"Type 'mem' to see what is stored in memory!";
		}
	}
	
	public static class MenuOption2 implements JMCCommand{

		@Override
		public String execute(ArrayList<JMCInput> inputs, JMCMemory memory) {
			
			// report back to the user something!
			return "Hello World";
		}
	}

	public static class SubMenuOption1 implements JMCCommand{

		@Override
		public String execute(ArrayList<JMCInput> inputs, JMCMemory memory) {
			
			int input1 = inputs.get(0).toInteger();
			int input2 = inputs.get(1).toInteger();
			
			int result = input1 * input2;
			
			memory.add("multiply", result);
			
			// report back to the user something!
			return input1 + " * " + input2 + " = " + result;
		}
	}
	
	public static class MenuOption4 implements JMCCommand{

		@Override
		public String execute(ArrayList<JMCInput> inputs, JMCMemory memory) {
			
			if(memory.hasKey("input-1")){
				return "Input-1 = "+memory.get("input-1");
			}
			return "Input-1 Not Found! Use menu option '1' to populate it!";
		}
	}
	
	
	/**
	 * End of menu option callbacks
	 * ----------------------------
	 */
	
	public static void main( String[] args )
	{	
		// create demo menu
		
		String label = "Example Menu Container\n" +
					   "----------------------\n";

		JMC menu = new JMC(label);
		
		// add menu option 1
		JMCEntry op1 = new JMCEntry("Menu Option 1", "1", new MenuOption1());
		op1.addInputInstructions("Enter some text to store in memory");
		op1.addInputInstructions("Enter some more text to store in memory");
		menu.addTopLevelEntry(op1);
		
		JMCEntry op2 = new JMCEntry("Print 'Hello World'", "hw", new MenuOption2());
		menu.addTopLevelEntry(op2);
		
		JMCEntry op3 = new JMCEntry("Sub-Menu", "sub");
		JMCEntry op3_1 = new JMCEntry("Multiply Two Numbers", "1", new SubMenuOption1());
		op3_1.addInputInstructions("Enter an integer value");
		op3_1.addInputInstructions("Enter a second integer value");
		
		// add sub-menus to parent menu entry
		op3.addEntry(op3_1);
		op3.addEntry(new JMCEntry("Another Option", "2"));
		op3.addEntry( new JMCEntry("Another Option", "3"));
		menu.addTopLevelEntry(op3);
		
		JMCEntry op4 = new JMCEntry("Check Memory For 'input-1'", "4", new MenuOption4());
		menu.addTopLevelEntry(op4);
		
		menu.run();
	}
}
