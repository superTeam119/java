package UserClasses;
public class Employee extends Person{
    private final int salary;
public Employee(String S0,int S1,int S2){
super(S0,S1);
this.salary=S2;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Employee other = (Employee) otherObj;
return this.salary==other.salary ;}
@Override
public String toString(){return super.toString() + "[" + "salary=" + salary + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 5*Integer.valueOf(salary).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Employee others=(Employee)other;
if(super.compareTo(other)==0 && (Integer.valueOf(salary) - Integer.valueOf(others.salary))==0 )
	return 0;
return (int)(super.compareTo(other) + (salary - others.salary));}}