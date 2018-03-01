package UserClasses1;
import DictionaryApplication.SuperType;
public class Tree extends SuperType{
    private final String asda;
    private final Animal assa;
public Tree(String S0,Animal S1){
this.asda=S0;
this.assa=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Tree other = (Tree) otherObj;
return ((this.asda==null && other.asda==null)||(this.asda!=null && this.asda.equals(other.asda))) && ((this.assa==null && other.assa==null)||(this.assa!=null && this.assa.equals(other.assa))) ;}
@Override
public String toString(){return super.toString() + "[" + "asda=" + asda.toString() + "," + "assa=" + assa.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*asda.hashCode() + 3*assa.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Tree others=(Tree)other;
if(super.compareTo(other)==0 && (asda.compareTo(others.asda))==0 && (assa.compareTo(others.assa))==0 )
	return 0;
return (int)(super.compareTo(other) + asda.compareTo(others.asda) + assa.compareTo(others.assa));}}