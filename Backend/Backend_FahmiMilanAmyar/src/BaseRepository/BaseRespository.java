package BaseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseRespository<T, ID>{
    Map<ID,T> Map = new HashMap<>();
    protected ArrayList<T> List = new ArrayList<>();

    public findByID(ID id){
        return Map;
    }

    public findAll(){
        return Map;
        return List;
    }
    abstract save(T entity){
    }

    abstract getID(T entity){
    }
}


