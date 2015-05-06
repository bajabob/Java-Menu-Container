package com.roberttimm.jmc;
import java.util.ArrayList;


public class JMCEntry {
	
	/** the label for this entry (shown on the menu) */
	private String label;
	
	/** the input instructions shown after the user selects this entry */
	private ArrayList<String> inputInstructions;
	
	/** the selector (like, "home", "mem") to use to select this entry */
	private String selector;
	
	/** the menu command to call when the user is done entering information */
	private JMCCommand command;
	
	/** a container that is a sub-menu to this entry (for creating hierarchies) */
	private JMCEntryContainer entries;
		
	public JMCEntry(String label, String selector, JMCCommand command){
		this.label = label;
		this.selector = selector.toLowerCase().trim();
		this.command = command;
		this.inputInstructions = new ArrayList<String>();
		this.entries = new JMCEntryContainer(label);
		
		if(this.selector.equals("q")){
			System.err.println("'q' is a reserved menu selector. Please choose another.");
		}
		
		if(this.selector.equals("home")){
			System.err.println("'home' is a reserved menu selector. Please choose another.");
		}
		
		if(this.selector.equals("clear")){
			System.err.println("'clear' is a reserved menu selector. Please choose another.");
		}
		
		if(this.selector.equals("mem")){
			System.err.println("'mem' is a reserved menu selector. Please choose another.");
		}
	}
	
	
	public JMCEntry(String labal, String selector){
		this(labal, selector, null);
	}
	
	
	/**
	 * Add input instructions to this entry
	 * @param instruction String
	 */
	public void addInputInstructions(String instruction){
		inputInstructions.add(instruction);
	}
	
	/**
	 * Does this entry require user inputs?
	 * @return boolean
	 */
	public boolean requiresInputs(){
		return !inputInstructions.isEmpty();
	}
	
	/**
	 * Get the list of input instructions for this entry
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getInputInstructions(){
		return inputInstructions;
	}
	
	
	/**
	 * Get the sub-menu to this entry
	 * @return MenuEntryContainer
	 */
	public JMCEntryContainer getMenuEntryContainer(){
		return this.entries;
	}
	
	/**
	 * Add an entry to this sub menu
	 * @param me MenuEntry
	 */
	public void addEntry(JMCEntry me){
		entries.addEntry(me);
	}
	
	/**
	 * Does this entry have the specified selector?
	 * @param selector String
	 * @return boolean
	 */
	public boolean hasSelector(String selector){
		return selector.toLowerCase().trim().equals(this.selector);
	}
	
	/**
	 * Get the selector for this entry
	 * @return String
	 */
	public String getSelector(){
		return this.selector;
	}
	
	/**
	 * Does this entry require input from the user?
	 * @return boolean
	 */
	public boolean isExecutable(){
		return command != null;
	}
	
	
	/**
	 * Execute this menu entry (calls the endpoint)
	 * @param inputs ArrayList<MenuInput> - list of user inputs
	 * @param memory MenuMemory
	 * @return String - a response to show the user
	 */
	public String execute(ArrayList<JMCInput> inputs, JMCMemory memory){
		return command.execute(inputs, memory);
	}
	
	public String toString(){
		String s = selector + "\t:" +label;
		return s;
	}
}
