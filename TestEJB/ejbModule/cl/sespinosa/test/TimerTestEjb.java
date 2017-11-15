package cl.sespinosa.test;

import java.io.File;
import java.io.FileWriter;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;

@Stateless
public class TimerTestEjb {

	/**
	 * Default constructor.
	 */
	public TimerTestEjb() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	@Schedule(second = "*/10", minute = "*", hour = "*", dayOfWeek = "Mon-Fri", dayOfMonth = "*", month = "*", year = "*", info = "MyTimer", persistent = false)
	private void scheduledTimeout(final Timer t) {
		System.out.println("@Schedule called at: " + new java.util.Date());

		try {
			FileWriter fw = new FileWriter(new File("Test.txt"));

			for (int i = 0; i < 1000; i++) {

				fw.write("Test:" + i);

			}

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}