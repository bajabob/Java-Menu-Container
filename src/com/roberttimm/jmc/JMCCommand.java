package com.roberttimm.jmc;
import java.util.ArrayList;


public interface JMCCommand {

	/**
	 * Execute a defined enpoint function
	 * @param inputs ArrayList<MenuInput> - inputs specified by the user
	 * @param memory MenuMenory - persistant memory for accessing/storing info
	 * @return String - something to report back to the user
	 */
	public String execute(ArrayList<JMCInput> input, JMCMemory memory);
	
}
