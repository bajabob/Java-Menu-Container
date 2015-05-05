import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MenuMemory {

	/**
	 * all the data
	 */
	private Map<String, String> memory;

	public MenuMemory(){
		memory = new HashMap<String, String>();
	}
	
	/**
	 * Add an entry to memory
	 * @param key String
	 * @param value String
	 */
	public void add(String key, String value){
		memory.put(key, value);
	}
	
	/**
	 * Get a string representation of this object
	 * @return String
	 */
	public String toString(){
		String s = "--> Memory:\n";
		Set<String> keys = memory.keySet();
		
		for(String key : keys){
			s += "--> "+ key + " => " + this.get(key) +"\n";
		}
		
		return s;
	}
	
	/**
	 * Clear all entries in memory
	 */
	public void clear(){
		memory.clear();
	}
	
	/**
	 * Is there a copy of the specified key in memory?
	 * @param key String
	 * @return boolean
	 */
	public boolean hasKey(String key){
		return memory.containsKey(key);
	}
	
	/**
	 * Get the raw entry in memory
	 * @param key String
	 * @return String
	 */
	public String get(String key){
		return memory.get(key);
	}
	
	/**
	 * Convert an entry in memory to Integer
	 * @param key String
	 * @return int
	 */
	public int getInteger(String key){
		int i = 0;
		try{
			i = Integer.parseInt(memory.get(key));
		}catch(NumberFormatException e){
			System.err.println("Input '"+memory.get(key)+"' is not of type Integer");
		}
		return i;
	}
	
	/**
	 * Convert an entry in memory to BigInteger
	 * @param key String
	 * @return BigInteger
	 */
	public BigInteger toBigInteger(String key){
		BigInteger i = new BigInteger("0");
		try{
			i = new BigInteger(memory.get(key));
		}catch(NumberFormatException e){
			System.err.println("Input '"+memory.get(key)+"' is not of type BigInteger");
		}
		return i;
	}
	
}
