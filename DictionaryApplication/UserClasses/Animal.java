package UserClasses;
public class Animal extends SuperType{
    private final String type;
    private final int age;
public Animal(String S0,int S1){
this.type=S0;
this.age=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Animal other = (Animal) otherObj;
return ((this.type==null && other.type==null)||(this.type!=null && this.type.equals(other.type))) && this.age==other.age ;}
@Override
public String toString(){return super.toString() + "[" + "type=" + type.toString() + "," + "age=" + age + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*type.hashCode() + 3*Integer.valueOf(age).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Animal others=(Animal)other;
if(super.compareTo(other)==0 && (type.compareTo(others.type))==0 && (Integer.valueOf(age) - Integer.valueOf(others.age))==0 )
	return 0;
return (int)(super.compareTo(other) + type.compareTo(others.type) + (age - others.age));}}