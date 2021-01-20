package gmfd;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MileageRepository extends PagingAndSortingRepository<Mileage, Long>{

    void deleteByPayId(Long payId);
    //findby 할때 View에서 생성한 변수와 동일한 변수명을 사용해야 함
    Optional<Mileage> findByPayId(Long payId);
}