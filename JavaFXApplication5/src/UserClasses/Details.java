package UserClasses;
public class Details extends superDictionary{
    private final int one;
    private final String two;
public Details(int S0,String S1){
this.one=S0;
this.two=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Details other = (Details) otherObj;
return this.one==other.one ;}
@Override
public String toString(){return super.toString() + "[" + "one=" + one + "," + "two=" + two.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Integer.valueOf(one).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Details others=(Details)other;
if(super.compareTo(other)==0 && (Integer.valueOf(one) - Integer.valueOf(others.one))==0 )
	return 0;
return (int)(super.compareTo(other) + (one - others.one));}}