package gmfd;

import gmfd.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }


    //Bean 간 연결
    @Autowired
    MileageRepository mileageRepository;
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCancelled_remove(@Payload Cancelled cancelled){

        if(cancelled.isMe()){
            System.out.println("##### listener  : " + cancelled.toJson());

            //Mileage mileage = mileageRepository.findById(cancelled.getId()).get();
            //mileageRepository.deleteByPayId(cancelled.getId());
            //mileageRepository.saveAll();

            Optional<Mileage> optionalMileage = mileageRepository.findByPayId(cancelled.getId());
            Mileage mileage = optionalMileage.get();

            //pay.setOrderid(deliveryCanceled.getOrderId());

            mileageRepository.delete(mileage);
            //

            /*Cancelled cancelled = new Cancelled();
            cancelled.setAmout(pay.getAmout());
            cancelled.setId(pay.getId());
            cancelled.setOrderid(pay.getOrderid());
            cancelled.setStatus(pay.getStatus());
            cancelled.publish();*/
        }
    }

}
