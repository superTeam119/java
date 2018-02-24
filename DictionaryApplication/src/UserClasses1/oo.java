package UserClasses1;
import DictionaryApplication.SuperType;
public class oo extends SuperType{
    private final String kk;
    private final String kka;
public oo(String S0,String S1){
this.kk=S0;
this.kka=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
oo other = (oo) otherObj;
return ((this.kk==null && other.kk==null)||(this.kk!=null && this.kk.equals(other.kk))) && ((this.kka==null && other.kka==null)||(this.kka!=null && this.kka.equals(other.kka))) ;}
@Override
public String toString(){return super.toString() + "[" + "kk=" + kk.toString() + "," + "kka=" + kka.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*kk.hashCode() + 3*kka.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
oo others=(oo)other;
if(super.compareTo(other)==0 && (kk.compareTo(others.kk))==0 && (kka.compareTo(others.kka))==0 )
	return 0;
return (int)(super.compareTo(other) + kk.compareTo(others.kk) + kka.compareTo(others.kka));}}