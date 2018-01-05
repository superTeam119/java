package UserClasses;
public class hii extends finalsssss{
    private final int salary;
    private final String name;
public hii(String S0,String S1,double S2,int S3,String S4){
super(S0,S1,S2);
this.salary=S3;
this.name=S4;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
hii other = (hii) otherObj;
return this.salary==other.salary && ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) ;}
@Override
public String toString(){return super.toString() + "[" + "salary=" + salary + "," + "name=" + name.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 7*Integer.valueOf(salary).hashCode() + 11*name.hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
hii others=(hii)other;
if(super.compareTo(other)==0 && (Integer.valueOf(salary) - Integer.valueOf(others.salary))==0 && (name.compareTo(others.name))==0 )
	return 0;
return (int)(super.compareTo(other) + (salary - others.salary) + name.compareTo(others.name));}}