package UserClasses1;
import DictionaryApplication.SuperType;
public class Amani extends Person{
    private final int age;
public Amani(String S0,int S1,int S2){
super(S0,S1);
this.age=S2;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Amani other = (Amani) otherObj;
return this.age==other.age ;}
@Override
public String toString(){return super.toString() + "[" + "age=" + age + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 5*Integer.valueOf(age).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Amani others=(Amani)other;
if(super.compareTo(other)==0 && (Integer.valueOf(age) - Integer.valueOf(others.age))==0 )
	return 0;
return (int)(super.compareTo(other) + (age - others.age));}}