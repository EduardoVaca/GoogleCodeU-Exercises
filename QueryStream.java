import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*Questions:
1. Can a string of a query be " "?

*/

public class QueryStream implements Iterator{

    ArrayList<Query>  list_query;
    Iterator <Query> it;
    StringTokenizer sToken;
    boolean first, changeQuery;
    Query actualQuery;
    
    
    public QueryStream(){     
       list_query = new ArrayList<Query>();       
       first = changeQuery = true;
    }
    
    public void add(String s){
        list_query.add(new Query(s));
    }
            
    private class Query{
        String timestamp;
        String list_words;
        Query(String s){
            list_words = s;
        }
    }
    
    public boolean hasNext() {
        if(first && list_query.isEmpty() == false)
            return true;
        else if(sToken.hasMoreTokens()){
            return true;
        }else{
            return it.hasNext();
        }
    }

    
    public Object next() { 
        if(hasNext()){
            if(first){
                it = list_query.iterator();
                actualQuery = it.next();
                first = false;
                sToken = new StringTokenizer(actualQuery.list_words);            
            }
            if(sToken.hasMoreTokens()){
                return sToken.nextToken();
            }else{                                                    
                actualQuery = it.next();
                sToken = new StringTokenizer(actualQuery.list_words);
                changeQuery = true;
                return "<QueryStream>";
            } 
        }        
        return null;
    }
    
    public static void main(String args[]){
        QueryStream QS = new QueryStream();
        QS.add("Hi there");
        QS.add("what's up");
        QS.add("   I'm at Google CodeU");
        while(QS.hasNext()){
            System.out.print(QS.next() + " ");
        }
        System.exit(0);
    }
    
}