package playground;

import java.text.DateFormat;
import java.util.Date;

public class TimeService {

	public String getTime() {
		return DateFormat.getInstance().format(new Date());
	}
}
