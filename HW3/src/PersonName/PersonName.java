package PersonName;


public class PersonName implements Comparable<PersonName>{
	private String FirstName;
	private String LastName;
	private String MiddleName;
	/**
	 * build a constructor to instantiate PersonName
	 */
	public PersonName(){
		this.FirstName = null;
		this.LastName = null;
		this.MiddleName = null;
	}
	/**
	 * create set()
	 * @param f
	 */
	public void setFirstName(String f){
		try{
		FirstName = f.substring(0, 1).toUpperCase() + f.substring(1);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Error: "+e);
		}
	}
	public void setLastName(String l){
		try{
		LastName = l.substring(0, 1).toUpperCase() + l.substring(1);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Error: "+e);
		}
		
	}
	public void setMiddleName(String m){
		try{
		MiddleName = m.substring(0, 1).toUpperCase() + m.substring(1);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Error: "+e);
		}
	}
	/**
	 * create get()
	 * @param f
	 * @return
	 */
	public String getFirstName(){
		return FirstName;
	}
	public String getLastName(){
		return LastName;
	}
	public String getMiddleName(){
		return MiddleName;
	}
	/**
	 * return full name
	 */
	public String toString(){
		String FullName = FirstName + ", " + MiddleName + ", " + LastName;
		return FullName;
	}
	/**
	 * check A = B, return Boolean 
	 * @param A
	 * @param B
	 * @return
	 */
	public Boolean equal(PersonName otherobject){
		PersonName other = otherobject;
		return FirstName.equals(other.getFirstName()) && 
			   MiddleName.equals(other.getMiddleName()) &&
			   LastName.equals(other.getLastName());
	}
	/**
	 * override compareTo
	 * @param other
	 * @return
	 */
	public int compareTo(PersonName other) {
		String fullname = this.toString();
		String otherfull = other.toString();
		int ct = fullname.compareTo(otherfull);
		if (ct<0){
			return -1;
		}
		else if(ct==0){
			return 0;
		}
		else {
		return 1;
		}
	}
	
	
}
