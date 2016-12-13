package com.bfm.corpapps.ignite.model;

import java.io.*;
import java.util.concurrent.atomic.*;

import org.apache.ignite.cache.affinity.*;
import org.apache.ignite.cache.query.annotations.*;

public class AumMetric implements Serializable{
	
	private static final AtomicLong ID_GEN = new AtomicLong();
	
	@QuerySqlField(index = true)
	private Long id;
	
	@QuerySqlField(index = true)
	private Long productId;
	
	@QuerySqlField private double beginAum;
	@QuerySqlField private double netNewBiz;
	@QuerySqlField private double acquired;
	@QuerySqlField private double deltaMktFx;
	@QuerySqlField private double endAum;
	@QuerySqlField private double deltaAum;
	
	/* if we decide to keep the metrics collocated with the product */
	private transient AffinityKey<Long> key;
	
	private AumMetric(Product product, double beginAum, double netNewBiz, double acquired, 
			double deltaMktFx, double endAum, double deltaAum) {
		this.id = ID_GEN.incrementAndGet();
		this.productId = product.id();
		this.beginAum = beginAum;
		this.netNewBiz = netNewBiz;
		this.acquired = acquired;
		this.deltaMktFx = deltaMktFx;
		this.endAum = endAum;
		this.deltaAum = deltaAum;
	}
	
	public AffinityKey<Long> key() {
        if (key == null)
            key = new AffinityKey<>(id, productId);
        return key;
    }
	
	public Long id() {
		return id;
	}
	
	public double beginAum() {
		return beginAum;
	}

	public double netNewBiz() {
		return netNewBiz;
	}

	public double acquired() {
		return acquired;
	}

	public double deltaInMktOrFx() {
		return deltaMktFx;
	}

	public double endAum() {
		return endAum;
	}

	public double deltaInAum() {
		return deltaAum;
	}
	
	@Override
	public String toString() {
        return "AumMetric [id=" + id +
            ", productId=" + productId +
            ", beginAum=" + beginAum +
            ", netNewBiz=" + netNewBiz +
            ", acquired=" + acquired +
            ", deltaMktFx=" + deltaMktFx +
            ", endAum=" + endAum +
            ", deltaAum=" + deltaAum + ']';
    }	
	
	public static class Builder {
		private Product product;
		private double beginAum;
		private double netNewBiz;
		private double acquired;
		private double deltaMktFx;
		private double endAum;
		private double deltaAum;
		
		public Builder setProduct(Product product) {
			this.product = product;
			return this;
		}
		
		public Builder setBeginAum(double beginAum) {
			this.beginAum = beginAum;
			return this;
		}
		
		public Builder setNetNewBiz(double netNewBiz) {
			this.netNewBiz = netNewBiz;
			return this;
		}
		
		public Builder setAcquired(double acquired) {
			this.acquired = acquired;
			return this;
		}
		
		public Builder setDeltaInMktOrFx(double deltaMktFx) {
			this.deltaMktFx = deltaMktFx;
			return this;
		}
		
		public Builder setEndAum(double endAum) {
			this.endAum = endAum;
			return this;
		}
		
		public Builder setDeltaInAum(double deltaAum) {
			this.deltaAum = deltaAum;
			return this;
		}
		
		public AumMetric build() {
			if (product == null) {
				throw new IllegalArgumentException("Product must be specified");
			}
			
			return new AumMetric(product, beginAum, netNewBiz, acquired, deltaMktFx, endAum, deltaAum);
		}
	}
}
