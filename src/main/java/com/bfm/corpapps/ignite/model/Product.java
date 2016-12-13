package com.bfm.corpapps.ignite.model;

import java.io.*;
import java.util.concurrent.atomic.*;

import org.apache.ignite.cache.query.annotations.*;

public class Product implements Serializable {
	
	private static final AtomicLong ID_GEN = new AtomicLong();
	
	@QuerySqlField(index = true)
	private Long id;
	
	@QuerySqlField(index = true)
	private String name;
	
	@QuerySqlField private String displayName;
	@QuerySqlField private String type;
	@QuerySqlField private String category;
	
	public Product(String name, String displayName, String type, String category) {
        this.id = ID_GEN.incrementAndGet();
        this.name = name;
        this.displayName = displayName;
        this.type = type;
        this.category = category;
    }
	
	public Long id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public String displayName() {
		return displayName;
	}
	
	public String type() {
		return type;
	}
	
	public String category() {
		return category;
	}
	
	@Override
	public String toString() {
        return "Product [id=" + id +
                ", name=" + name +
                ", displayName=" + displayName +
                ", type=" + type +
                ", category=" + category + ']';
    }
}
