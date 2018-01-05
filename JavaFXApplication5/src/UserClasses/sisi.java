package UserClasses;
public class sisi extends superDictionary{
    private final char ho;
public sisi(char S0){
this.ho=S0;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
sisi other = (sisi) otherObj;
return  true;}
@Override
public String toString(){return super.toString() + "[" + "ho=" + ho + "]";
}
@Override
public int hashCode(){
return super.hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
sisi others=(sisi)other;
if(super.compareTo(other)==0)
	return 0;
return super.compareTo(other);}}