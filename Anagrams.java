import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("unchecked")
class HashMap{
    List<String>[] arr;
    int size;
    HashMap(int n){
        this.size=nextprime(n);
        arr=new List[this.size];
        for(int i=0;i<size;i++){
            arr[i]=new Vector<>();
        }
    }
    int HashCode(String str){
        int r=0; 
        for(int i=0;i<str.length();i++){
            int ascii=str.charAt(i); 
            r=(ascii+257*r)%this.size;
        }
        return r;
    }
    
    void put(String key,String val){
        int ind=HashCode(key);
        if(arr[ind].isEmpty()) 
            arr[ind].add(val); 
        else{
            if(val.length()==arr[ind].get(0).length()&& key.equals(Sort(arr[ind].get(0)))){
                arr[ind].add(val);
            }
            else{
                int i=0;
                while(true){
                    if(arr[ind].isEmpty()){
                        //arr[ind].add(key);
                        arr[ind].add(val);
                        break;    
                    }
                    if(Sort(arr[ind].get(0)).equals(key)){
                        arr[ind].add(val);
                        break;
                    }    
                    ind=(ind+i*i)%size;
                    i++;
                }
            }
        }
    }
  

    List<String> search(String key){
        int ind=HashCode(key);
        /*if(arr[ind].isEmpty()) return arr[ind];
        if(arr[ind].get(0)==key)
            return arr[ind];
        else{
            int i=0;
            while(true){
                if(!arr[ind].isEmpty()){
                    if(arr[ind].get(0)==key)
                        return arr[ind];
                    ind=(ind+i*i)%size;
                    i++;
                }
            }
        }
        */
        List<String> lis=new Vector<>();
        int p=0;
        while(p<size){
            if(arr[ind].isEmpty())
                return lis;
            else if(key.equals(Sort(arr[ind].get(0))))
                return arr[ind];
            else{
                ind=(ind+p*p)%size;
                p=p+1;
            }
        }
        return lis;
    }
    boolean contains(String key){
        int ind=HashCode(key);
        int p=0;
        while(p<size){
            if(arr[ind].isEmpty())
                return false;
            else if(key.equals(Sort(arr[ind].get(0))))
                return true;
            else{
                ind=(ind+p*p)%size;
                p=p+1;
            }
        }
        return false;
    }
    boolean contdist(String key){
        int ind=HashCode(key);
        int p=0;
        while(p<size){
            if(arr[ind].isEmpty())
                return false;
            else if(key.equals(arr[ind].get(0)))
                return true;
            else{
                ind=(ind+p*p)%size;
                p=p+1;
            }
        }
        return false;
    }

    int getcount(){
        int count=0;
        for(int i=0;i<size;i++){
            count+=arr[i].size();
        }
        return count;
    }


    int nextprime(int num){
        int a=num,i,j;
        for(j=a+1;;j++){
            for(i=2;i<j;i++){
                if(j%i==0)
                    break;
            }
            if(i==j){
             return j;
            }
        }
    }
    static String Sort(String str){
        char[] temp=str.toCharArray();
        mergesort(temp,0,temp.length);
        String s=new String(temp);  
        return s;
    }
    static void mergesort(char[] a,int lo,int hi){
            int n=hi-lo;
            if(n<=1) return;
            int mid=lo+n/2;
            mergesort(a,lo,mid);
            mergesort(a,mid,hi);
            char[] temp=new char[n];
            int i=lo;
            int j=mid;
            for(int k=0;k<n;k++){
                if(i==mid)
                    temp[k]=a[j++];
                else if(j==hi)
                    temp[k]=a[i++];
                else if(a[j]<a[i])
                    temp[k]=a[j++];
                else
                    temp[k]=a[i++];            
            }
            for(int k=0;k<n;k++){
                a[lo+k]=temp[k]; 
            }   
    }
} 

public class Anagrams{
    List<String> word1;
    List<String> word2;
    List<String> word3;
    public static String Sort(String str){
        char[] temp=str.toCharArray();
        mergesort(temp,0,temp.length);
        String s=new String(temp);  
        return s;
    }
    public static void mergesort(char[] a,int lo,int hi){
            int n=hi-lo;
            if(n<=1) return;
            int mid=lo+n/2;
            mergesort(a,lo,mid);
            mergesort(a,mid,hi);
            char[] temp=new char[n];
            int i=lo;
            int j=mid;
            for(int k=0;k<n;k++){
                if(i==mid)
                    temp[k]=a[j++];
                else if(j==hi)
                    temp[k]=a[i++];
                else if(a[j]<a[i])
                    temp[k]=a[j++];
                else
                    temp[k]=a[i++];            
            }
            for(int k=0;k<n;k++){
                a[lo+k]=temp[k]; 
            }   
    }
    public  static List<String> printSubsets(String str)
    {   
        List<String> words =new Vector<>();
        String w1="";
        String wcomp="";
        String s=str;
        char[] temp=s.toCharArray();
        int n=temp.length;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0)  
                    w1+=temp[j];
                else
                    wcomp+=temp[j];
            }      
            if(w1.length()> 2 && wcomp.length()>2){
                words.add(w1+" "+wcomp);
            }
            w1="";
            wcomp="";
        }
        return words;
    }
    public static List<String> printSubsets(String str,List<String> list){
        List<String> w2space=new Vector<>();
        for(int k=0;k<list.size();k++){
            String[] arr=list.get(k).split(" ");
            String w1="";
            String w1comp="";
            String s1=arr[0];
            String s2="";
            if(arr.length==2) s2=arr[1];
            char[] temp1=s1.toCharArray();
            char[] temp2=s2.toCharArray();
            int n1=temp1.length;
            int n2=temp2.length;
                for(int i=0;i<(1<<n1);i++){
                    for(int j=0;j<n1;j++){
                        if((i&(1<<j))>0){  
                            w1+=temp1[j];
                        }    
                        else{
                            w1comp+=temp1[j];
                        }
                    }
                    if(w1.length()>2&&w1comp.length()>2&&s2.length()>2)
                        w2space.add(w1+" "+w1comp+" "+s2);
                    w1="";
                    w1comp="";
                }
        
            String w2="";
            String w2comp="";
                for(int i=0;i<(1<<n2);i++){
                    for(int j=0;j<n2;j++){
                        if((i&(1<<j))>0){  
                            w2+=temp2[j];
                        }    
                        else{
                            w2comp+=temp2[j];
                        }
                    }
                    if(w2.length()>2&&w2comp.length()>2&&s1.length()>2)
                        w2space.add(s1+" "+w2+" "+w2comp);
                    w2="";
                    w2comp="";
                }

    }
        return w2space;
    }

    public static List<String> printSubsets3(String str)
    {
        List<String> word=printSubsets(str);
        List<String> word3=printSubsets(str,word);
        return word3;
    }

    public static void main(String[] args){
        try{    
            long start=System.currentTimeMillis();
            File vocab=new File(args[0]);
            BufferedReader br=new BufferedReader(new FileReader(vocab));
            File input=new File(args[1]);
            BufferedReader br1=new BufferedReader(new FileReader(input));
            int k=Integer.parseInt(br1.readLine());
            int size=Integer.parseInt(br.readLine());
            HashMap hm=new HashMap(size);
            String val="";
            while((val=br.readLine())!=null){
                String key= Sort(val);
                hm.put(key,val);
            }
            String s="";
            HashMap hp;
            List<String> anagrams;
        for(int i=0;i<k;i++){
            hp=new HashMap(size);
            s=br1.readLine();
            anagrams=new Vector<>();
            String st=Sort(s);
            if(st.length()>2&& st.length()<6){
                if(hm.contains(st)){
                    for(String str:hm.search(st)){
                        if(!hp.contdist(str)){
                            hp.put(str,str);
                            anagrams.add(str);
                        }
                    }
                }
            }
            else if(st.length()>=6 && st.length()<9){
                if(hm.contains(st)){
                    for(String str:hm.search(st)){
                        if(!hp.contdist(str)){
                            hp.put(str,str);
                            anagrams.add(str);
                        }
                    }
                }
                List<String> list=printSubsets(st);
                for(String str: list){
                    String[] arr=str.split(" ");
                    if(hm.contains(arr[0]) && hm.contains(arr[1])){
                        for(String str1: hm.search(arr[0])){
                            for(String str2: hm.search(arr[1])){
                                if(!hp.contdist(str1+" "+str2)){
                                    hp.put(str1+" "+str2,str1+" "+str2);
                                    anagrams.add(str1+" "+str2);
                                }        
                            }
                        }
                    }
                }
            }
            else if(st.length()>=9 && st.length()<=12){
                if(hm.contains(st)){
                    for(String str:hm.search(st)){
                        if(!hp.contdist(str)){
                            hp.put(str,str);
                            anagrams.add(str);
                        }
                    }
                }
                List<String> list=printSubsets(st);
                for(String str: list){
                    String[] arr=str.split(" ");
                    if(hm.contains(arr[0])&& hm.contains(arr[1])){
                        for(String str1: hm.search(arr[0])){
                            for(String str2: hm.search(arr[1])){
                                if(!hp.contdist(str1+" "+str2)){
                                    hp.put(str1+" "+str2,str1+" "+str2);
                                    anagrams.add(str1+" "+str2);
                                }            
                            }
                        }
                    }
                }
                List<String> list2=printSubsets3(st);
                for(String stri: list2){
                    String[] arr=stri.split(" ");
                    if(hm.contains(arr[0])&& hm.contains(arr[1])&&hm.contains(arr[2])){
                        for(String str1: hm.search(arr[0])){
                            for(String str2: hm.search(arr[1])){
                                for(String str3:hm.search(arr[2])){
                                    if(!hp.contdist(str1+" "+str2+" "+str3)){
                                        hp.put(str1+" "+str2+" "+str3,str1+" "+str2+" "+str3);
                                        anagrams.add(str1+" "+str2+" "+str3);
                                    }       
                                }        
                            }
                        }
                    }
                }

            }
            Collections.sort(anagrams);
            for(String anag: anagrams){
                System.out.println(anag);
            }
            System.out.println("-1");
        }
        br.close();
        br1.close(); 
            long end=System.currentTimeMillis();
            long total=end-start;
            System.out.println("Total time taken to find anagram is is: "+total+" millis");
        }
        catch(Exception e){
            System.out.println("lol");
        }
   }
}
