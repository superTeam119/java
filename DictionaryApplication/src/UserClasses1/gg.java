package UserClasses1;
import DictionaryApplication.SuperType;
public class gg extends SuperType{
    private final String weee;
public gg(String S0){
this.weee=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
gg other = (gg) otherObj;
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
gg others=(gg)other;
if(super.compareTo(other)==0 && (weee.compareTo(others.weee))==0 )
	return 0;
return (int)(super.compareTo(other) + weee.compareTo(others.weee));}}