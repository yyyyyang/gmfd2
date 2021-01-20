
package gmfd.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="customer", url=//"${api.customer.url}")
        "http://customer:8080")
        //"http://localhost:8083")
public interface CustomerService {

    @RequestMapping(method= RequestMethod.GET, path="/customers")
    public void queryCustomer(@RequestBody Customer customer);

}
