package com.ashish.springpractice;

public class Triangle {
	
	private Point PointA,PointB,PointC;

	public Point getPointA() {
		return PointA;
	}

	public void setPointA(Point pointA) {
		PointA = pointA;
	}

	public Point getPointB() {
		return PointB;
	}

	public void setPointB(Point pointB) {
		PointB = pointB;
	}

	public Point getPointC() {
		return PointC;
	}

	public void setPointC(Point pointC) {
		PointC = pointC;
	}
	
	public void draw() {
	System.out.println(" Triangle drawn with vertices :  [("+PointA.getX()+", "+PointA.getY()+"), ("+PointB.getX()+", "+PointB.getY()+"), ("+PointC.getX()+", "+PointC.getY()+")]");
}
	
//	private String type;
//	private int height;
//	
//	
//	public Triangle(String type) {
//		super();
//		this.type = type;
//	}
//	public Triangle(int height) {
//		super();
//		this.height = height;
//	}
//	public Triangle(String type, int height) {
//		super();
//		this.type = type;
//		this.height = height;
//	}
//	public int getHeight() {
//		return height;
//	}
//	
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public void draw() {
//		System.out.println(getType() + " Triangle drawn with height "+getHeight());
//		System.out.println(getType() + " Triangle drawn");
//	}
}
