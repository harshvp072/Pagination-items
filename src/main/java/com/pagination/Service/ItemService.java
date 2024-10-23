package com.pagination.Service;
import com.pagination.Entity.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    private final Map<Integer, Item> itemMap = new HashMap<>();
    private static final int Items_Per_Page = 10;

    public ItemService() {
        for(int i=1;i<=100;i++){
            itemMap.put(i,new Item(i,"Item "+i));
        }
    }
    public List<Item> getItemsByPageNo(int page){
        int offset = (page - 1) * Items_Per_Page;
        List<Item> items = new ArrayList<>(itemMap.values());
        return items.subList(offset,Math.min(items.size(),offset + Items_Per_Page));
    }
    public int getItemCount(){
        return itemMap.size();
    }
}
