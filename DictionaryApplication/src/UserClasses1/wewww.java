package UserClasses1;
import DictionaryApplication.SuperType;
public class wewww extends SuperType{
    private final String ssss;
public wewww(String S0){
this.ssss=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
wewww other = (wewww) otherObj;
return ((this.ssss==null && other.ssss==null)||(this.ssss!=null && this.ssss.equals(other.ssss))) ;}
@Override
public String toString(){return super.toString() + "[" + "ssss=" + ssss.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*ssss.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
wewww others=(wewww)other;
if(super.compareTo(other)==0 && (ssss.compareTo(others.ssss))==0 )
	return 0;
return (int)(super.compareTo(other) + ssss.compareTo(others.ssss));}}