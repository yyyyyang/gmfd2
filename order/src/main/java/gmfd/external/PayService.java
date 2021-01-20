
package gmfd.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
                                //url="${api.payment.url}"
@FeignClient(name="payment", url=//"${api.payment.url}")
                                  "http://payment:8080")
        //"http://localhost:8084")
public interface PayService {

    @RequestMapping(method= RequestMethod.GET, path="/pays")
    public void pay(@RequestBody Pay pay);

}
