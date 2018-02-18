package UserClasses;
public class mtoo extends SuperType{
    private final Person pp;
    private final int ss;
public mtoo(Person S0,int S1){
this.pp=S0;
this.ss=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
mtoo other = (mtoo) otherObj;
return ((this.pp==null && other.pp==null)||(this.pp!=null && this.pp.equals(other.pp))) && this.ss==other.ss ;}
@Override
public String toString(){return super.toString() + "[" + "pp=" + pp.toString() + "," + "ss=" + ss + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*pp.hashCode() + 3*Integer.valueOf(ss).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
mtoo others=(mtoo)other;
if(super.compareTo(other)==0 && (pp.compareTo(others.pp))==0 && (Integer.valueOf(ss) - Integer.valueOf(others.ss))==0 )
	return 0;
return (int)(super.compareTo(other) + pp.compareTo(others.pp) + (ss - others.ss));}}