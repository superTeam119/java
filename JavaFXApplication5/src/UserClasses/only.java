package UserClasses;
public class only extends superDictionary{
    private final String name;
public only(String S0){
this.name=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
only other = (only) otherObj;
return ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*name.hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
only others=(only)other;
if(super.compareTo(other)==0 && (name.compareTo(others.name))==0 )
	return 0;
return (int)(super.compareTo(other) + name.compareTo(others.name));}}