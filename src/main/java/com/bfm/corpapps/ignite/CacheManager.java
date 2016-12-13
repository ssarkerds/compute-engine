package com.bfm.corpapps.ignite;

import java.util.*;

import org.apache.ignite.*;
import org.apache.ignite.cache.*;
import org.apache.ignite.cache.affinity.*;
import org.apache.ignite.cache.query.*;
import org.apache.ignite.cache.query.annotations.*;
import org.apache.ignite.configuration.*;
import org.springframework.util.*;

import com.bfm.corpapps.ignite.model.*;
import com.bfm.corpapps.ignite.report.*;

public class CacheManager {
	
	private static final String PRODUCT_CACHE = CacheManager.class.getSimpleName() + "Products";
    private static final String AUM_CACHE = CacheManager.class.getSimpleName() + "AUM";
    
    private Ignite ignite;
    
    //private IgniteCache<Long, Product> productCache;
    //private IgniteCache<AffinityKey<Long>, AumMetric> aumCache;
    
    public CacheManager() {
		Ignition.setClientMode(true);
		this.ignite = Ignition.start("config/ignite-compute.xml");
    }
    
    public void close() {
        ignite.destroyCache(PRODUCT_CACHE);
        ignite.destroyCache(AUM_CACHE);
        ignite.close();
    }
    
    public static void main(String[] args) {
    	StopWatch w = new StopWatch();
    	w.start("init");
    	CacheManager cm = new CacheManager();
    	w.stop();
    	w.start("create cache");
    	cm.createCache();
    	w.stop();
    	w.start("query");
    	cm.runAumQuery();
    	w.stop();
    	w.start("close");
    	cm.close();
    	w.stop();
    	System.out.println(w.prettyPrint());
    }
    
	public static void mains(String[] args) {
		Ignition.setClientMode(true);
		try (Ignite ignite = Ignition.start("config/ignite-compute.xml")) {
            System.out.println();
            System.out.println(">>> loading cache.");
            
            CacheConfiguration<Long, Product> productCacheCfg = new CacheConfiguration<>(PRODUCT_CACHE);
            productCacheCfg.setCacheMode(CacheMode.PARTITIONED);
            productCacheCfg.setIndexedTypes(Long.class, Product.class);            
            
            CacheConfiguration<AffinityKey<Long>, AumMetric> aumCacheCfg = new CacheConfiguration<>(AUM_CACHE);
            aumCacheCfg.setCacheMode(CacheMode.PARTITIONED);
            aumCacheCfg.setIndexedTypes(Long.class, AumMetric.class);
            
            try (
                    IgniteCache<Long, Product> productCache = ignite.getOrCreateCache(productCacheCfg);
                    //IgniteCache<AffinityKey<Long>, Person> colPersonCache = ignite.getOrCreateCache(colPersonCacheCfg);
                    IgniteCache<AffinityKey<Long>, AumMetric> aumCache = ignite.getOrCreateCache(aumCacheCfg)
            ) {
            	//createCache();
            	//runQuery();
            }
            finally {
                ignite.destroyCache(PRODUCT_CACHE);
                ignite.destroyCache(AUM_CACHE);
            }
            
            System.out.println("Cache query example finished.");            
        }
	}
	
	private static void runQuery() {
		IgniteCache<AffinityKey<Long>, AumMetric> cache = Ignition.ignite().cache(AUM_CACHE);
		
		String joinSql =
            "from AumMetric, \"" + PRODUCT_CACHE + "\".Product as p " +
            "where AumMetric.productId = p.id " +
            "and lower(p.name) = lower(?)";
		
		SqlQuery qry = new SqlQuery<AffinityKey<Long>, AumMetric>(AumMetric.class, joinSql);
		
		// set arguments
		qry.setArgs("Equity - ETF");
		
		// Enable distributed joins for query.
        qry.setDistributedJoins(true);
        
        // Execute queries for find employees for different organizations.
        print("products (distributed join): ", cache.query(qry).getAll());		
	}
	
	public List<EstimatedAum> runAumQuery() {
		IgniteCache<AffinityKey<Long>, AumMetric> cache = Ignition.ignite().cache(AUM_CACHE);
		
		String joinSql =
			"select p.displayName, p.type, p.category, m.beginAum, m.netNewBiz, m.acquired, m.deltaMktFx, m.endAum, m.deltaAum "+
            "from AumMetric m, \"" + PRODUCT_CACHE + "\".Product as p " +
            "where m.productId = p.id ";
		
		//SqlQuery qry = new SqlQuery<AffinityKey<Long>, AumMetric>(AumMetric.class, joinSql);
		SqlFieldsQuery qry = new SqlFieldsQuery(joinSql);
		
		// set arguments
		//qry.setArgs("Equity - ETF");
		
		// Enable distributed joins for query.
        qry.setDistributedJoins(true);
		
		QueryCursor<List<?>> cursor = cache.query(qry);
        List<List<?>> res = cursor.getAll();
        
        List<EstimatedAum> report = new ArrayList<>();
        for (List<?> item : res) {
        	EstimatedAum ea = new EstimatedAum();
        	ea.name = (String)item.get(0);
        	ea.type = (String)item.get(1);
        	ea.category = (String)item.get(2);
        	ea.beginAum = (double)item.get(3);
        	ea.netNewBiz = (double)item.get(4);
        	ea.acquired = (double)item.get(5);
        	ea.deltaMktFx = (double)item.get(6);
        	ea.endAum = (double)item.get(7);
        	ea.deltaAum = (double)item.get(8);
        	report.add(ea);
        }
        
        return report;
	}
	
	private void createCache() {
        CacheConfiguration<Long, Product> productCacheCfg = new CacheConfiguration<>(PRODUCT_CACHE);
        productCacheCfg.setCacheMode(CacheMode.PARTITIONED);
        productCacheCfg.setIndexedTypes(Long.class, Product.class);            
        
        CacheConfiguration<AffinityKey<Long>, AumMetric> aumCacheCfg = new CacheConfiguration<>(AUM_CACHE);
        aumCacheCfg.setCacheMode(CacheMode.PARTITIONED);
        aumCacheCfg.setIndexedTypes(Long.class, AumMetric.class);
        
        ignite.createCache(productCacheCfg);
        ignite.createCache(aumCacheCfg);
		
		IgniteCache<Long, Product> productCache = Ignition.ignite().cache(PRODUCT_CACHE);
		productCache.clear();
		
		Product p1 = new Product("Fixed Income - Index", "Index FI", "Index", "Long-Term");
		Product p2 = new Product("Equity - Index", "Index EQ", "Index", "Long-Term");
		Product p3 = new Product("Fixed Income - ETF", "ETF FI", "ETF", "Long-Term");
		Product p4 = new Product("Equity - ETF", "ETF EQ", "ETF", "Long-Term");
		
		productCache.put(p1.id(), p1);
		productCache.put(p2.id(), p2);
		productCache.put(p3.id(), p3);
		productCache.put(p4.id(), p4);
		
		
		IgniteCache<Long, AumMetric> aumCache = Ignition.ignite().cache(AUM_CACHE);
		aumCache.clear();
		
		AumMetric m1 = new AumMetric.Builder()
				.setProduct(p1)
				.setBeginAum(459.0)
				.setNetNewBiz(8)
				.setAcquired(0)
				.setDeltaInMktOrFx(13)
				.setEndAum(480)
				.setDeltaInAum(21)
				.build();
			 
		AumMetric m2 = new AumMetric.Builder()
				.setProduct(p2)
				.setBeginAum(1224)
				.setNetNewBiz(-2)
				.setAcquired(0)
				.setDeltaInMktOrFx(88)
				.setEndAum(1311)
				.setDeltaInAum(87)
				.build();

		AumMetric m3 = new AumMetric.Builder()
				.setProduct(p3)
				.setBeginAum(276)
				.setNetNewBiz(9)
				.setAcquired(0)
				.setDeltaInMktOrFx(6)
				.setEndAum(291)
				.setDeltaInAum(15)
				.build();
	
		AumMetric m4 = new AumMetric.Builder()
				.setProduct(p4)
				.setBeginAum(753)
				.setNetNewBiz(12)
				.setAcquired(0)
				.setDeltaInMktOrFx(56)
				.setEndAum(821)
				.setDeltaInAum(68)
				.build();
	
		aumCache.put(m1.id(), m1);
		aumCache.put(m2.id(), m2);
		aumCache.put(m3.id(), m3);
		aumCache.put(m4.id(), m4);
	}
	
	private static void print(String msg, Iterable<?> col) {
        System.out.println();
        System.out.println(">>> " + msg);
        for (Object next : col)
            System.out.println(">>>     " + next);
    }
}
