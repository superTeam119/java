package UserClasses;
public class Point extends SuperType{
    private final int x;
    private final int y;
public Point(int S0,int S1){
this.x=S0;
this.y=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Point other = (Point) otherObj;
return this.y==other.y ;}
@Override
public String toString(){return super.toString() + "[" + "x=" + x + "," + "y=" + y + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(y).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Point others=(Point)other;
if(super.compareTo(other)==0 && (Integer.valueOf(y) - Integer.valueOf(others.y))==0 )
	return 0;
return (int)(super.compareTo(other) + (y - others.y));}}