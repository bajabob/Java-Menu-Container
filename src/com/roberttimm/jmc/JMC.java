package com.roberttimm.jmc;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class allows you to easily create a menu system
 */
public class JMC {

	/**
	 * The top level elements of this menu
	 */
	private JMCEntryContainer topLevel;
	
	/**
	 * The current menu level the user is on
	 */
	private JMCEntryContainer traversal;
	
	/**
	 * Used for storing data processed by end points at MenuCommand
	 */
	private JMCMemory memory;
	
	public JMC(String homeLabel){
		topLevel = new JMCEntryContainer(homeLabel, true);
		traversal = topLevel;
		memory = new JMCMemory();
	}
	
	/**
	 * Add a new menu entry to the top level menu
	 * @param entry MenuEntry
	 */
	public void addTopLevelEntry(JMCEntry entry){
		topLevel.addEntry(entry);
	}
	
	
	public void run(){
		String lastAction = "";
		while(true){
			
			// add some spacing to last menu print
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(lastAction+"\n");
			lastAction = "";
			
			// print out menu
			System.out.println(traversal);
			
			// get user input
			Scanner scan = new Scanner(System.in);
			System.out.print("Selection: ");
			String selection = scan.next();
			
			// terminate the program?
			if(selection.equalsIgnoreCase("q")){
				break;
			}
			
			// go back to the top level?
			if(selection.equalsIgnoreCase("home")){
				lastAction = "--> Returning To Home Menu";
				traversal = topLevel;
				continue;
			}
			
			// clear all memory?
			if(selection.equalsIgnoreCase("clear")){
				lastAction = "--> Clearing Memory";
				memory.clear();
				continue;
			}
			
			// print contents of memory?
			if(selection.equalsIgnoreCase("mem")){
				lastAction = memory.toString();
				continue;
			}
			
			// get the selector the user requested
			JMCEntry me = traversal.getBySelector(selection);
			
			// get some user inputs if there is an executable element
			//  attached to this menu item
			if(me != null){
				if(me.isExecutable()){
					ArrayList<JMCInput> inputs = new ArrayList<JMCInput>();
					if(me.requiresInputs()){
						for(String instruction : me.getInputInstructions()){
							System.out.println(instruction);
							System.out.print("Input: ");
							try{
								BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
								String input;
								while((input=br.readLine())!=null){
									inputs.add(new JMCInput(input));
									break;
								}
							}catch(IOException io){
								io.printStackTrace();
							}
						}
					}					
					
					lastAction = me.execute(inputs, memory);
				}else{
					// set a new current traversal level
					this.traversal = me.getMenuEntryContainer();
				}
			}else{
				System.out.println("No menu selection by that command exists");
			}
		}
	}
}
