/**
 * 
 */
package command;


/**
 * @author misskabu
 *
 */
public class StringSeparator {
	public String getFoward(String str,char separator){
		int index = str.indexOf(separator);
		return str.substring(0,index);
	}
	public String getBack(String str,char separator){
		int index = str.indexOf(separator);
		return str.substring(index + 1);
				
	}
	
}
