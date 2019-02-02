package snofang.repub.trepub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {

	public static String getNewUniqueName(String prefix) {
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yymmdd_hhmmssSSS");
		return prefix == null? "":prefix + dateFormat.format(d);
	}
}
