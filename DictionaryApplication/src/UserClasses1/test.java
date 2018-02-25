package UserClasses1;
import DictionaryApplication.SuperType;
public class test extends SuperType{
    private final String sdfdsf;
public test(String S0){
this.sdfdsf=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
test other = (test) otherObj;
return ((this.sdfdsf==null && other.sdfdsf==null)||(this.sdfdsf!=null && this.sdfdsf.equals(other.sdfdsf))) ;}
@Override
public String toString(){return super.toString() + "[" + "sdfdsf=" + sdfdsf.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*sdfdsf.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
test others=(test)other;
if(super.compareTo(other)==0 && (sdfdsf.compareTo(others.sdfdsf))==0 )
	return 0;
return (int)(super.compareTo(other) + sdfdsf.compareTo(others.sdfdsf));}}