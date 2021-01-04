package com.example.demo.service.undone;
import com.example.demo.dao.repository.MerchandiseRepository;
import com.example.demo.dao.entity.Merchandise;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;


@RestController
@RequestMapping("merchandise")
public class MerchandiseController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }

    @Autowired
    private MerchandiseRepository merchandiseRepository;
    @Autowired
    private MerchandiseService merchandiseService;
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData  getMerchandiseList() {
        return merchandiseService.getMerchandiseList();
    }

    //增
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData add(Merchandise merchandise) {
        return merchandiseService.add(merchandise);
    }


    //删
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") long id) {
        return merchandiseService.delete(id);
      }


    //改
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseData update(Merchandise model) {
        return merchandiseService.update(model);
    }

    //查
    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public ResponseData findMerchandise(@PathVariable("title") String title) throws IOException {
        return merchandiseService.findMerchandiseByTitle(title);
    }

    //查询测试
    @RequestMapping(value = "/te/{title}", method = RequestMethod.GET)
    public ResponseData  findMerchandised(@PathVariable("title") String title) throws IOException {
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8080/merchandise/"+title;
        ResponseData  responseData = client.getForObject (uri,ResponseData.class,title) ;
        System.out.println(responseData.getRspMsg());
        return responseData;
    }
}


