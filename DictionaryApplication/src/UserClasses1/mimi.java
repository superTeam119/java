package UserClasses1;
import DictionaryApplication.SuperType;
public class mimi extends SuperType{
    private final Account asda;
    private final String sada;
public mimi(Account S0,String S1){
this.asda=S0;
this.sada=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
mimi other = (mimi) otherObj;
return ((this.asda==null && other.asda==null)||(this.asda!=null && this.asda.equals(other.asda))) && ((this.sada==null && other.sada==null)||(this.sada!=null && this.sada.equals(other.sada))) ;}
@Override
public String toString(){return super.toString() + "[" + "asda=" + asda.toString() + "," + "sada=" + sada.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*asda.hashCode() + 3*sada.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
mimi others=(mimi)other;
if(super.compareTo(other)==0 && (asda.compareTo(others.asda))==0 && (sada.compareTo(others.sada))==0 )
	return 0;
return (int)(super.compareTo(other) + asda.compareTo(others.asda) + sada.compareTo(others.sada));}}