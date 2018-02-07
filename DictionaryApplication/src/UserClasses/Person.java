package UserClasses;
public class Person extends superDictionary{
    private final String name;
    private final int age;
public Person(String S0,int S1){
this.name=S0;
this.age=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Person other = (Person) otherObj;
return ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) && this.age==other.age ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "," + "age=" + age + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*name.hashCode() + 3*Integer.valueOf(age).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Person others=(Person)other;
if(super.compareTo(other)==0 && (name.compareTo(others.name))==0 && (Integer.valueOf(age) - Integer.valueOf(others.age))==0 )
	return 0;
return (int)(super.compareTo(other) + name.compareTo(others.name) + (age - others.age));}}