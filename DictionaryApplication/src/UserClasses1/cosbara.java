package UserClasses1;
import DictionaryApplication.SuperType;
public class cosbara extends SuperType{
    private final float d;
public cosbara(float S0){
this.d=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
cosbara other = (cosbara) otherObj;
return  true;}
@Override
public String toString(){return super.toString() + "[" + "d=" + d + "]";
}
@Override
public int hashCode(){
return super.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
cosbara others=(cosbara)other;
if(super.compareTo(other)==0 )
	return 0;
return (int)(super.compareTo(other));}}