package com.sears.SYWL.p2p.api;

public class GeographyUtils {
	public static final double EARTH_RADIUS=6367.45;
	public static final double MILE_FACTOR=0.621371192;
	
	public static double distanceOnEarth(double lat1,double lon1,double lat2, double lon2) {
		double la1=lat1*Math.PI/180.0;
		double lo1=lon1*Math.PI/180.0;
		double la2=lat2*Math.PI/180.0;
		double lo2=lon2*Math.PI/180.0;
		
		double dlat=la2-la1;
		double dlon=lo2-lo1;
		
		double a=Math.sin(dlat/2)*Math.sin(dlat/2)
				+Math.cos(la1)*Math.cos(la2)*Math.sin(dlon/2)*Math.sin(dlon/2);
		double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		return c*EARTH_RADIUS*MILE_FACTOR;
	}
	
	public static void main(String[] args) {
		System.out.println(distanceOnEarth(40.443721, -79.944446, 40.444285, -79.945554));
	}
}
