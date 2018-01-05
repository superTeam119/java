package UserClasses;
public class bibi extends superDictionary{
    private final String bobo;
public bibi(String S0){
this.bobo=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
bibi other = (bibi) otherObj;
return  true;}
@Override
public String toString(){return super.toString() + "[" + "bobo=" + bobo.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
bibi others=(bibi)other;
if(super.compareTo(other)==0)
	return 0;
return super.compareTo(other);}}