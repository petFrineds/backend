package petfriends.daily.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import petfriends.daily.model.Daily;

public interface DailyRepository extends JpaRepository<Daily, Long>{

	// 리스트 조회
    List<Daily> findAllById(Long id);
    
    // 단건 조회
    Optional<Daily> findById(Long id);
    
}