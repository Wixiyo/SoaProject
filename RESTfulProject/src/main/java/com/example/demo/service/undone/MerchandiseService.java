package com.example.demo.service.undone;

import com.example.demo.service.undone.repository.MerchandiseRepository;
import com.example.demo.service.undone.entity.Merchandise;
import com.example.demo.dao.userDao.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Service
public class MerchandiseService {//商品服务
    @Autowired
    private MerchandiseRepository merchandiseRepository;
    private UserRepository userRepository;

    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }

    public Merchandise findMerchandiseById(long id) {
        return merchandiseRepository.findById(id);
    }

    public ResponseData update(Merchandise model) {
        merchandiseRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }

    public ResponseData add(Merchandise merchandise) {
        merchandiseRepository.save(merchandise);
        // return "{success:true,message: \"添加成功\" }";
        return new ResponseData(ExceptionMsg.SUCCESS,merchandise);
    }

    public ResponseData findMerchandiseByTitle(String title) {
        List<Merchandise> merchandises = new ArrayList<Merchandise>(merchandiseRepository.findByTitle(title));
        if (merchandises.size() != 0) {
            return new ResponseData(ExceptionMsg.SUCCESS,merchandises);
        }
        return new ResponseData(ExceptionMsg.FAILED,merchandises);
    }
    //全部查询
    public ResponseData  getMerchandiseList() {
        List<Merchandise> list = new ArrayList<Merchandise>(merchandiseRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);
    }
    //删
    public Response delete(@PathVariable("id") long id) {

     /*   RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8080" + "/{id}";
        Map map= new HashMap();
        map. put ("orderid",id);
        Void article = client.delete(uri,map,id);*/
        merchandiseRepository.deleteById(id);

        return result(ExceptionMsg.SUCCESS);
        //return new ResponseData(ExceptionMsg.SUCCESS,"");
    }

}
