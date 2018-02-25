package UserClasses1;
import DictionaryApplication.SuperType;
public class ggg extends SuperType{
    private final String sss;
public ggg(String S0){
this.sss=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
ggg other = (ggg) otherObj;
return ((this.sss==null && other.sss==null)||(this.sss!=null && this.sss.equals(other.sss))) ;}
@Override
public String toString(){return super.toString() + "[" + "sss=" + sss.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*sss.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
ggg others=(ggg)other;
if(super.compareTo(other)==0 && (sss.compareTo(others.sss))==0 )
	return 0;
return (int)(super.compareTo(other) + sss.compareTo(others.sss));}}