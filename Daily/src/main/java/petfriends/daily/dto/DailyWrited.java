package petfriends.daily.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import petfriends.AbstractEvent;
import petfriends.daily.model.WalkingPlace;

public class DailyWrited extends AbstractEvent {

	private Long id;					// 일지ID
    private String dailyRecordDate;		// 작성일자
    
    @Enumerated(EnumType.STRING)
    private WalkingPlace walkingPlace;	// 산책장소
    
    private String contents;			// 작성내용
    private int starScore;				// 별점
    private Long walkId;				// 산책ID
    private Long dogWalkerId;			// 도그워커ID
    private Long userId;				// 회원ID
    
    public DailyWrited(){
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDailyRecordDate() {
		return dailyRecordDate;
	}

	public void setDailyRecordDate(String dailyRecordDate) {
		this.dailyRecordDate = dailyRecordDate;
	}

	public WalkingPlace getWalkingPlace() {
		return walkingPlace;
	}

	public void setWalkingPlace(WalkingPlace walkingPlace) {
		this.walkingPlace = walkingPlace;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getWalkId() {
		return walkId;
	}

	public void setWalkId(Long walkId) {
		this.walkId = walkId;
	}

	public Long getDogWalkerId() {
		return dogWalkerId;
	}

	public void setDogWalkerId(Long dogWalkerId) {
		this.dogWalkerId = dogWalkerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}
	
}