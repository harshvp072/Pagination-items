package com.pagination.Controller;
import com.pagination.Entity.Item;
import com.pagination.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public Map<String,Object> getItems(@RequestParam int PageNo){
        List<Item> items = itemService.getItemsByPageNo(PageNo);
        int total = itemService.getItemCount();
        int totalPages = (int)Math.ceil((double) total/10);
        Map<String,Object> map = new HashMap<>();
        map.put("items", items);
        map.put("totalPages", totalPages);
        map.put("totalItems", total);
        map.put("currentPage", PageNo);
        return map;
    }
}