package UserClasses;
public class Vehicle extends SuperType{
    private final int iii;
    private final String ii;
public Vehicle(int S0,String S1){
this.iii=S0;
this.ii=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Vehicle other = (Vehicle) otherObj;
return ((this.ii==null && other.ii==null)||(this.ii!=null && this.ii.equals(other.ii))) ;}
@Override
public String toString(){return super.toString() + "[" + "iii=" + iii + "," + "ii=" + ii.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*ii.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Vehicle others=(Vehicle)other;
if(super.compareTo(other)==0 && (ii.compareTo(others.ii))==0 )
	return 0;
return (int)(super.compareTo(other) + ii.compareTo(others.ii));}}