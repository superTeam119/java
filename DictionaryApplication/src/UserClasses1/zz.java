package UserClasses1;
import DictionaryApplication.SuperType;
public class zz extends SuperType{
    private final String ss;
    private final String zz;
public zz(String S0,String S1){
this.ss=S0;
this.zz=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
zz other = (zz) otherObj;
return ((this.ss==null && other.ss==null)||(this.ss!=null && this.ss.equals(other.ss))) ;}
@Override
public String toString(){return super.toString() + "[" + "ss=" + ss.toString() + "," + "zz=" + zz.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*ss.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
zz others=(zz)other;
if(super.compareTo(other)==0 && (ss.compareTo(others.ss))==0 )
	return 0;
return (int)(super.compareTo(other) + ss.compareTo(others.ss));}}