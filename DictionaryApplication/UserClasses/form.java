package UserClasses;
public class form extends SuperType{
    private final String namef;
    private final int intf;
public form(String S0,int S1){
this.namef=S0;
this.intf=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
form other = (form) otherObj;
return ((this.namef==null && other.namef==null)||(this.namef!=null && this.namef.equals(other.namef))) && this.intf==other.intf ;}
@Override
public String toString(){return super.toString() + "[" + "namef=" + namef.toString() + "," + "intf=" + intf + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*namef.hashCode() + 3*Integer.valueOf(intf).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
form others=(form)other;
if(super.compareTo(other)==0 && (namef.compareTo(others.namef))==0 && (Integer.valueOf(intf) - Integer.valueOf(others.intf))==0 )
	return 0;
return (int)(super.compareTo(other) + namef.compareTo(others.namef) + (intf - others.intf));}}