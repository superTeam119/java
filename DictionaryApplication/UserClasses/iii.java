package UserClasses;
public class iii extends SuperType{
    private final Person oo;
    private final int pp;
public iii(Person S0,int S1){
this.oo=S0;
this.pp=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
iii other = (iii) otherObj;
return  true;}
@Override
public String toString(){return super.toString() + "[" + "oo=" + oo.toString() + "," + "pp=" + pp + "]";
}
@Override
public int hashCode(){
return super.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
iii others=(iii)other;
if(super.compareTo(other)==0 )
	return 0;
return (int)(super.compareTo(other));}}