package UserClasses1;
import DictionaryApplication.SuperType;
public class tedy extends SuperType{
    private final String fsda;
public tedy(String S0){
this.fsda=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
tedy other = (tedy) otherObj;
return ((this.fsda==null && other.fsda==null)||(this.fsda!=null && this.fsda.equals(other.fsda))) ;}
@Override
public String toString(){return super.toString() + "[" + "fsda=" + fsda.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*fsda.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
tedy others=(tedy)other;
if(super.compareTo(other)==0 && (fsda.compareTo(others.fsda))==0 )
	return 0;
return (int)(super.compareTo(other) + fsda.compareTo(others.fsda));}}