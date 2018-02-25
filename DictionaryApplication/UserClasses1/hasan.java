package UserClasses1;
import DictionaryApplication.SuperType;
public class hasan extends SuperType{
    private final String sdsds;
public hasan(String S0){
this.sdsds=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
hasan other = (hasan) otherObj;
return ((this.sdsds==null && other.sdsds==null)||(this.sdsds!=null && this.sdsds.equals(other.sdsds))) ;}
@Override
public String toString(){return super.toString() + "[" + "sdsds=" + sdsds.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*sdsds.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
hasan others=(hasan)other;
if(super.compareTo(other)==0 && (sdsds.compareTo(others.sdsds))==0 )
	return 0;
return (int)(super.compareTo(other) + sdsds.compareTo(others.sdsds));}}