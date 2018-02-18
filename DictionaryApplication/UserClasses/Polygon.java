package UserClasses;
public class Polygon extends SuperType{
    private final Point a;
    private final Point b;
    private final Point c;
public Polygon(Point S0,Point S1,Point S2){
this.a=S0;
this.b=S1;
this.c=S2;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Polygon other = (Polygon) otherObj;
return ((this.a==null && other.a==null)||(this.a!=null && this.a.equals(other.a))) && ((this.b==null && other.b==null)||(this.b!=null && this.b.equals(other.b))) && ((this.c==null && other.c==null)||(this.c!=null && this.c.equals(other.c))) ;}
@Override
public String toString(){return super.toString() + "[" + "a=" + a.toString() + "," + "b=" + b.toString() + "," + "c=" + c.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*a.hashCode() + 3*b.hashCode() + 5*c.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Polygon others=(Polygon)other;
if(super.compareTo(other)==0 && (a.compareTo(others.a))==0 && (b.compareTo(others.b))==0 && (c.compareTo(others.c))==0 )
	return 0;
return (int)(super.compareTo(other) + a.compareTo(others.a) + b.compareTo(others.b) + c.compareTo(others.c));}}