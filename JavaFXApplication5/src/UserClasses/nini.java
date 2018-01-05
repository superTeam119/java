package UserClasses;

import java.util.Date;

public class nini extends superDictionary{
    private final Date hj;
    private final int jh;
public nini(Date S0,int S1){
this.hj=S0;
this.jh=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
nini other = (nini) otherObj;
return  true;}
@Override
public String toString(){return super.toString() + "[" + "hj=" + hj.toString() + "," + "jh=" + jh + "]";
}
@Override
public int hashCode(){
return super.hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
nini others=(nini)other;
if(super.compareTo(other)==0)
	return 0;
return super.compareTo(other);}}