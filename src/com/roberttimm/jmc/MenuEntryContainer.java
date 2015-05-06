package com.roberttimm.jmc;
import java.util.ArrayList;


public class MenuEntryContainer {

	/** the label for this container */
	private String label;
	
	/** the list of entries for this container */
	private ArrayList<MenuEntry> entries;
	
	/** is this the home container? */
	private boolean isHome;
	
	public MenuEntryContainer(String label, boolean isHome){
		this.label = label;
		this.isHome = isHome;
		entries = new ArrayList<MenuEntry>();
	}
	
	public MenuEntryContainer(String label){
		this(label, false);
	}
	
	/**
	 * Get a MenuEntry by a specified selector
	 * @param selector MenuEntry
	 * @return null | MenuEntry
	 */
	public MenuEntry getBySelector(String selector){
		for(MenuEntry me : entries){
			if(me.hasSelector(selector)){
				return me;
			}
		}return null;
	}
	
	/**
	 * Add an entry to this container
	 * @param me MenuEntry
	 */
	public void addEntry(MenuEntry me){
		for(MenuEntry e : entries){
			if(e.hasSelector(me.getSelector())){
				System.err.println("Selector '"+me.getSelector()+"' is already being used by this container.");
				return;
			}
		}
		entries.add(me);
	}
	
	public String toString(){
		String s = this.label + "\n";
		for(MenuEntry me : entries){
			s += me + "\n";
		}
		s += "\n";
		if(!isHome){
			s += "home\t:Home Menu\n";
		}
		s += "mem\t:Print Memory\n";
		s += "clear\t:Clear Memory\n";
		s += "q\t:Exit Program\n";
		return s;
	}
	
}
