package UserClasses;
public class finalsssss extends superDictionary{
    private final String isis;
    private final String vyvyv;
    private final double vttvt;
public finalsssss(String S0,String S1,double S2){
this.isis=S0;
this.vyvyv=S1;
this.vttvt=S2;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
finalsssss other = (finalsssss) otherObj;
return ((this.isis==null && other.isis==null)||(this.isis!=null && this.isis.equals(other.isis))) && ((this.vyvyv==null && other.vyvyv==null)||(this.vyvyv!=null && this.vyvyv.equals(other.vyvyv))) && this.vttvt==other.vttvt ;}
@Override
public String toString(){return super.toString() + "[" + "isis=" + isis.toString() + "," + "vyvyv=" + vyvyv.toString() + "," + "vttvt=" + vttvt + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*isis.hashCode() + 3*vyvyv.hashCode() + 5*Double.valueOf(vttvt).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
finalsssss others=(finalsssss)other;
if(super.compareTo(other)==0 && (isis.compareTo(others.isis))==0 && (vyvyv.compareTo(others.vyvyv))==0 && (Double.valueOf(vttvt) - Double.valueOf(others.vttvt))==0 )
	return 0;
return (int)(super.compareTo(other) + isis.compareTo(others.isis) + vyvyv.compareTo(others.vyvyv) + (vttvt - others.vttvt));}}