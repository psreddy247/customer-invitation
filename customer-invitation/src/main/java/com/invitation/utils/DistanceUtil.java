package com.invitation.utils;

/**
 * @author P Srikanth Reddy This is a utility class to find distance between to
 *         geographical coordinations.
 * 
 **/
public class DistanceUtil {

	/**
	 * This method calculates distance between to geographical coordinations.
	 * 
	 * 
	 */
	public static double findDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		final int R = 6371; // Radius of the earth
		double distance = 0D;
		double longitudeAbsDiff = longitude2 - longitude1;

		// applied formula 
		// diff = sin(lat1)*sin(lat2)+cos(lat1)*cos(lat2)*cos(long2-long1)
		double diff = Math.sin(convertDegToRad(latitude1)) * Math.sin(convertDegToRad(latitude2))
				+ Math.cos(convertDegToRad(latitude1)) * Math.cos(convertDegToRad(latitude2))
						* Math.cos(convertDegToRad(longitudeAbsDiff));

		double centralAngle = Math.acos(diff); // arccos(diff)
		
		distance = R * centralAngle; // d=r*centralAngle
		// System.out.println(" "+ latitude1+" "+ longitude1+" "+ latitude2+" "+
		// longitude2 +" dist: "+ centralAngle);
		return distance;
	}

	/**
	 * Converting Degrees to Radiance
	 */
	public static double convertDegToRad(double valueInDeg) {
		return (valueInDeg * Math.PI / 180.0);
	}
}
