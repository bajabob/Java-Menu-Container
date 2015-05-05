import java.math.BigInteger;
import java.util.ArrayList;

public class Main
{
	
	public static class MenuOption1 implements MenuCommand{

		@Override
		public String execute(ArrayList<MenuInput> inputs, MenuMemory memory) {
			
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
	
	public static class MenuOption2 implements MenuCommand{

		@Override
		public String execute(ArrayList<MenuInput> inputs, MenuMemory memory) {
			
			// report back to the user something!
			return "Hello World";
		}
	}

	
	
	public static void main( String[] args )
	{
		
		
		String label = "Example Menu Container\n" +
					   "----------------------\n";

		Menu menu = new Menu(label);
		
		MenuEntry op1 = new MenuEntry("Menu Option 1", "1", new MenuOption1());
		op1.addInputInstructions("Enter some text to store in memory");
		op1.addInputInstructions("Enter some more text to store in memory");
		menu.addTopLevelEntry(op1);
		
		MenuEntry op2 = new MenuEntry("Print 'Hello World'", "hw", new MenuOption2());
		menu.addTopLevelEntry(op2);
		
		menu.run();
	}

}
