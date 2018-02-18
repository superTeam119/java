package UserClasses;
public class aaa extends SuperType{
    private final int salary;
    private final String www;
public aaa(int S0,String S1){
this.salary=S0;
this.www=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
aaa other = (aaa) otherObj;
return this.salary==other.salary ;}
@Override
public String toString(){return super.toString() + "[" + "salary=" + salary + "," + "www=" + www.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(salary).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
aaa others=(aaa)other;
if(super.compareTo(other)==0 && (Integer.valueOf(salary) - Integer.valueOf(others.salary))==0 )
	return 0;
return (int)(super.compareTo(other) + (salary - others.salary));}}