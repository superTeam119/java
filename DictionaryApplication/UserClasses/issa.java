package UserClasses;
public class issa extends SuperType{
    private final int ss;
    private final int xx;
public issa(int S0,int S1){
this.ss=S0;
this.xx=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
issa other = (issa) otherObj;
return this.ss==other.ss && this.xx==other.xx ;}
@Override
public String toString(){return super.toString() + "[" + "ss=" + ss + "," + "xx=" + xx + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(ss).hashCode() + 3*Integer.valueOf(xx).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
issa others=(issa)other;
if(super.compareTo(other)==0 && (Integer.valueOf(ss) - Integer.valueOf(others.ss))==0 && (Integer.valueOf(xx) - Integer.valueOf(others.xx))==0 )
	return 0;
return (int)(super.compareTo(other) + (ss - others.ss) + (xx - others.xx));}}