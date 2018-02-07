package UserClasses;
public class Vehicle extends superDictionary{
    private final int salary;
public Vehicle(int S0){
this.salary=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Vehicle other = (Vehicle) otherObj;
return this.salary==other.salary ;}
@Override
public String toString(){return super.toString() + "[" + "salary=" + salary + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(salary).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Vehicle others=(Vehicle)other;
if(super.compareTo(other)==0 && (Integer.valueOf(salary) - Integer.valueOf(others.salary))==0 )
	return 0;
return (int)(super.compareTo(other) + (salary - others.salary));}}