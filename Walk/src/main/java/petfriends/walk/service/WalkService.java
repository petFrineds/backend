package petfriends.walk.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petfriends.walk.model.SmsStatus;
import petfriends.walk.model.Walk;
import petfriends.walk.repository.WalkRepository;
import petfriends.walk.view.WalkEndRequestView;
import petfriends.walk.view.WalkRequestView;

@Service
public class WalkService {
	 
	 @Autowired
	 WalkRepository walkRepository;
	 
	 // 산책 단건 조회
	 public Walk findById(Long id) throws RuntimeException{
		 return walkRepository.findById(id).orElseThrow(()->new RuntimeException("산책 건이 존재하지 않습니다."));
	 }
	 
	 // 산책 시작
	 @Transactional
	 public Walk walkStart(WalkRequestView walkRequest) throws Exception {
		 
		 // 산책 시작시 SMS상태는 START로 세팅
		 Walk walkStarted = Walk.of(SmsStatus.START, 
				 walkRequest.getReservedId(), 
				 walkRequest.getUserId(), 
				 walkRequest.getDogWalkerId());
		 
		 // 산책 시작 일자는 현재일시분으로 세팅
		 //walkStarted.setWalkStartDate(LocalDateTime.now());
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 String dateStr = format.format(Calendar.getInstance().getTime());
		 walkStarted.setWalkStartDate(dateStr);
		 
		 return walkRepository.save(walkStarted);
		 
	 }

	 // 산책 종료
	 @Transactional
	 public Walk walkEnd(WalkEndRequestView walkEndRequest) throws Exception {
		 
		 // 해당건 존재여부 체크
		 walkRepository.findById(walkEndRequest.getId()).orElseThrow(()->new RuntimeException("산책 건이 존재하지 않습니다."));
		 
		 // 해당건 조회
		 Walk walkEnded = walkRepository.findById(walkEndRequest.getId()).get();
		 
		 // 해당건이 이미 산책 종료된 건인지 체크
		 if(walkEnded.getSmsStatus() == SmsStatus.END) {
			 
			 throw new Exception("해당 건은 이미 산책 종료되었습니다.");
			 
		 }
			 
	     // 산책 종료시 SMS상태는 END로 세팅
		 walkEnded.setSmsStatus(SmsStatus.END);
			 
		 // 산책 종료 일자는 현재일시로 세팅 
		 //walkEnded.setWalkEndDate(LocalDateTime.now());
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 String dateStr = format.format(Calendar.getInstance().getTime());
		 walkEnded.setWalkEndDate(dateStr);
			 
		 return	walkRepository.save(walkEnded);
		 
	 }
	 
//	 // 산책 조회
//	 public List<Walk> findAllById(Long userId) {
//		 return walkRepository.findAllById(userId);
//	 }
	 
		 
}

