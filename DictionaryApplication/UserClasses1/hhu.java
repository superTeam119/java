package UserClasses1;
import DictionaryApplication.SuperType;
public class hhu extends SuperType{
    private final String dsd;
public hhu(String S0){
this.dsd=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
hhu other = (hhu) otherObj;
return ((this.dsd==null && other.dsd==null)||(this.dsd!=null && this.dsd.equals(other.dsd))) ;}
@Override
public String toString(){return super.toString() + "[" + "dsd=" + dsd.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*dsd.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("ggggg");
hhu others=(hhu)other;
if(super.compareTo(other)==0 && (dsd.compareTo(others.dsd))==0 )
	return 0;
return (int)(super.compareTo(other) + dsd.compareTo(others.dsd));}}