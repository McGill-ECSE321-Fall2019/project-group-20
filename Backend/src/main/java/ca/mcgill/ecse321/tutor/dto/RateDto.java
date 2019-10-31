import java.util.Date;
import java.util.List;

public class RateDto {
	

    private Integer rate;
    private List<Rate> Rate;


    public RateDto(Integer rate) {
    	this.rate = rate;
    }

 
	public List<RateDto> getAllRates()) {
		return Rate;
	}
}
