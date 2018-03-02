package UserClasses1;
import DictionaryApplication.SuperType;
public class Park extends SuperType{
    private final String name;
    private final int as;
public Park(String S0,int S1){
this.name=S0;
this.as=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Park other = (Park) otherObj;
return ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) && this.as==other.as ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "," + "as=" + as + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*name.hashCode() + 3*Integer.valueOf(as).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Park others=(Park)other;
if(super.compareTo(other)==0 && (name.compareTo(others.name))==0 && (Integer.valueOf(as) - Integer.valueOf(others.as))==0 )
	return 0;
return (int)(super.compareTo(other) + name.compareTo(others.name) + (as - others.as));}}