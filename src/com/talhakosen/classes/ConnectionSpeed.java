package com.talhakosen.classes;


public class ConnectionSpeed {
	public static SpeedInfo calculate(final long downloadTime, final long bytesIn) {
		SpeedInfo info = new SpeedInfo();
		// from mil to sec
		long bytespersecond = (bytesIn / downloadTime) * 1000;
		double kilobits = bytespersecond * Constants.BYTE_TO_KILOBIT;
		double megabits = kilobits * Constants.KILOBIT_TO_MEGABIT;
		info.downspeed = bytespersecond;
		info.kilobits = kilobits;
		info.megabits = megabits;

		return info;
	}

	private static class SpeedInfo {
		public double kilobits = 0;
		public double megabits = 0;
		public double downspeed = 0;
	}

}
