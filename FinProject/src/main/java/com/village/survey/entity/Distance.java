package com.village.survey.entity;

import java.util.Scanner;

public class Distance {

	public static void main(String args[]) {
		int lat1, lat2;
		int lon1, lon2;
		double distance;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter one point i.e., lat1");
		lat1 = sc.nextInt();
		System.out.println("enter lon1 point");
		lon1 = sc.nextInt();
		System.out.println("enter lat2 point");
		lat2 = sc.nextInt();
		System.out.println("enter lon2 point");
		lon2 = sc.nextInt();
		distance = Math.sqrt((lat2 - lat1) * (lat2 - lat1) + (lon2 - lon1) * (lon2 - lon1));
		System.out.println("distancebetween two points is:" + distance);
	}
}
