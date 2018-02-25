package UserClasses1;
import DictionaryApplication.SuperType;
public class ok extends SuperType{
    private final String weee;
public ok(String S0){
this.weee=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
ok other = (ok) otherObj;
return ((this.weee==null && other.weee==null)||(this.weee!=null && this.weee.equals(other.weee))) ;}
@Override
public String toString(){return super.toString() + "[" + "weee=" + weee.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*weee.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
ok others=(ok)other;
if(super.compareTo(other)==0 && (weee.compareTo(others.weee))==0 )
	return 0;
return (int)(super.compareTo(other) + weee.compareTo(others.weee));}}