package UserClasses1;
import DictionaryApplication.SuperType;
public class ii extends SuperType{
    private final String iii;
    private final String pp;
public ii(String S0,String S1){
this.iii=S0;
this.pp=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
ii other = (ii) otherObj;
return ((this.iii==null && other.iii==null)||(this.iii!=null && this.iii.equals(other.iii))) && ((this.pp==null && other.pp==null)||(this.pp!=null && this.pp.equals(other.pp))) ;}
@Override
public String toString(){return super.toString() + "[" + "iii=" + iii.toString() + "," + "pp=" + pp.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*iii.hashCode() + 3*pp.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
ii others=(ii)other;
if(super.compareTo(other)==0 && (iii.compareTo(others.iii))==0 && (pp.compareTo(others.pp))==0 )
	return 0;
return (int)(super.compareTo(other) + iii.compareTo(others.iii) + pp.compareTo(others.pp));}}