package UserClasses1;
import DictionaryApplication.SuperType;
public class Animal extends SuperType{
    private final String name;
    private final String type;
public Animal(String S0,String S1){
this.name=S0;
this.type=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Animal other = (Animal) otherObj;
return ((this.name==null && other.name==null)||(this.name!=null && this.name.equals(other.name))) && ((this.type==null && other.type==null)||(this.type!=null && this.type.equals(other.type))) ;}
@Override
public String toString(){return super.toString() + "[" + "name=" + name.toString() + "," + "type=" + type.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*name.hashCode() + 3*type.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Animal others=(Animal)other;
if(super.compareTo(other)==0 && (name.compareTo(others.name))==0 && (type.compareTo(others.type))==0 )
	return 0;
return (int)(super.compareTo(other) + name.compareTo(others.name) + type.compareTo(others.type));}}