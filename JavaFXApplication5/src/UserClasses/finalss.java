package UserClasses;
public class finalss extends superDictionary{
    private final String name;
    private final int salary;
public finalss(String S0,int S1){
this.name=S0;
this.salary=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
finalss other = (finalss) otherObj;
return ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) && this.salary==other.salary ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "," + "salary=" + salary + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*name.hashCode() + 3*Integer.valueOf(salary).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
finalss others=(finalss)other;
if(super.compareTo(other)==0 && (name.compareTo(others.name))==0 && (Integer.valueOf(salary) - Integer.valueOf(others.salary))==0 )
	return 0;
return (int)(super.compareTo(other) + name.compareTo(others.name) + (salary - others.salary));}}