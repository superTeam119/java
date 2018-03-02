package UserClasses1;
import DictionaryApplication.SuperType;
public class Person extends SuperType{
    private final String name;
    private final int birthyear;
public Person(String S0,int S1){
this.name=S0;
this.birthyear=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Person other = (Person) otherObj;
return this.birthyear==other.birthyear ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "," + "birthyear=" + birthyear + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(birthyear).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Person others=(Person)other;
if(super.compareTo(other)==0 && (Integer.valueOf(birthyear) - Integer.valueOf(others.birthyear))==0 )
	return 0;
return (int)(super.compareTo(other) + (birthyear - others.birthyear));}}