package com.bfm.corpapps.ignite.report;

public class EstimatedAum {
	public String name;
	public String type;
	public String category;
	public double beginAum;
	public double netNewBiz;
	public double acquired;
	public double deltaMktFx;
	public double endAum;
	public double deltaAum;

	@Override
	public String toString() {
		return "[name=" + name 
			+", type="+type
			+", category="+category
			+", beginAum="+beginAum
			+", netNewBiz="+netNewBiz
			+", acquired="+acquired
			+", deltaMktFx="+deltaMktFx
			+", endAum="+endAum
			+", deltaAum="+deltaAum+"]";
	}
}
