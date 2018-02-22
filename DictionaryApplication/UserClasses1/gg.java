package UserClasses1;
import DictionaryApplication.SuperType;
public class gg extends SuperType{
    private final String ss;
public gg(String S0){
this.ss=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
gg other = (gg) otherObj;
return ((this.ss==null && other.ss==null)||(this.ss!=null && this.ss.equals(other.ss))) ;}
@Override
public String toString(){return super.toString() + "[" + "ss=" + ss.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*ss.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
gg others=(gg)other;
if(super.compareTo(other)==0 && (ss.compareTo(others.ss))==0 )
	return 0;
return (int)(super.compareTo(other) + ss.compareTo(others.ss));}}