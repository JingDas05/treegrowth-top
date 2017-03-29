package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.entity.Dream;
import top.treegrowth.provider.service.DreamService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author wusi
 * @version 2017/3/18 19:54.
 */
@RestController
@RequestMapping("/api/service/dreams")
public class DreamApi {

    @Autowired
    private DreamService dreamService;

    @RequestMapping(value = "/create", method = POST)
    public void addDream(@RequestBody Dream dream) {
        dreamService.add(dream);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public void addDream(@PathVariable String id) {
        dreamService.getBy(id);
    }
}
