package top.treegrowth.single.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.entity.Dream;
import top.treegrowth.single.service.IDreamService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/3/18 19:54.
 */
@RestController
@RequestMapping("/api/dreams")
public class DreamApi {

    @Autowired
    private IDreamService iDreamService;

    @RequestMapping(value = "/create", method = POST)
    public void addDream(@RequestBody Dream dream) {
        iDreamService.add(dream);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public void addDream(@PathVariable String id) {
        iDreamService.getBy(id);
    }
}
