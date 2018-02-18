package UserClasses;
public class hello extends SuperType{
    private final int ww;
public hello(int S0){
this.ww=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
hello other = (hello) otherObj;
return this.ww==other.ww ;}
@Override
public String toString(){return super.toString() + "[" + "ww=" + ww + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(ww).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
hello others=(hello)other;
if(super.compareTo(other)==0 && (Integer.valueOf(ww) - Integer.valueOf(others.ww))==0 )
	return 0;
return (int)(super.compareTo(other) + (ww - others.ww));}}