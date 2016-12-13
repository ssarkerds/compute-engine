package com.bfm.corpapps.ignite.model;

import java.util.*;

import org.apache.ignite.cache.query.annotations.*;

public class Snapshot {
	private String gcgChannel;
	private String gcgDistChannel;
	private String accountingTeam;
	private String region;
	private String marketingRegion;
	private String marketingDomicile;
	
	@QuerySqlField(index = true)
	private String assetClass;
	
	private String managementStyle;
	private String mandate;
	private Integer portfolioCode;
	private String portfolioTicker;
	private String portfolioFullName;
	private String assignmentName;
	private String clientName;
	private String shortName;
	private String clientType;
	private String portFundingType;
	private String reportedClientType;
	private Date assignmentStartDate;
	private Date portTerminationDate;
	private String portCurrencyBase;
	
	@QuerySqlField
	private double beginningAum;
	private double netIn;
	private double netOut;
	private double transferIn;
	private double transferOut;
	private double netNewBusiness;
	private double netNewBusinessExclTx;
	private double lastFridayNetIn;
	private double lastFridayNetOut;
	private double lastFridayTxIn;
	private double lastFridayTxOut;
	private double lastFridayNetNewBus;
	private double lastFridayNetNewBusExclTx;
	private double weeklyNetIn;
	private double weeklyNetOut;
	private double weeklyTxIn;
	private double weeklyTxOut;
	private double weeklyNetNewBus;
	private double weeklyNewBusExclTx;
	private double weeklyNewBusExclTxAbs;
	private double fxMovement;
	private double priceMovement;
	private double market;
	private double marketPercent;
	private double acquisitions;
	private double disposals;
	private double endingAum;
	private double beginningDoubleDip;
	private double doubleDipAdjustments;
	private double endingAumDoubleDip;

	public String getGcgChannel() {
		return gcgChannel;
	}

	public void setGcgChannel(String gcgChannel) {
		this.gcgChannel = gcgChannel;
	}

	public String getGcgDistChannel() {
		return gcgDistChannel;
	}

	public void setGcgDistChannel(String gcgDistChannel) {
		this.gcgDistChannel = gcgDistChannel;
	}

	public String getAccountingTeam() {
		return accountingTeam;
	}

	public void setAccountingTeam(String accountingTeam) {
		this.accountingTeam = accountingTeam;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMarketingRegion() {
		return marketingRegion;
	}

	public void setMarketingRegion(String marketingRegion) {
		this.marketingRegion = marketingRegion;
	}

	public String getMarketingDomicile() {
		return marketingDomicile;
	}

	public void setMarketingDomicile(String marketingDomicile) {
		this.marketingDomicile = marketingDomicile;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getManagementStyle() {
		return managementStyle;
	}

	public void setManagementStyle(String managementStyle) {
		this.managementStyle = managementStyle;
	}

	public String getMandate() {
		return mandate;
	}

	public void setMandate(String mandate) {
		this.mandate = mandate;
	}

	public Integer getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(Integer portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public String getPortfolioTicker() {
		return portfolioTicker;
	}

	public void setPortfolioTicker(String portfolioTicker) {
		this.portfolioTicker = portfolioTicker;
	}

	public String getPortfolioFullName() {
		return portfolioFullName;
	}

	public void setPortfolioFullName(String portfolioFullName) {
		this.portfolioFullName = portfolioFullName;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getPortFundingType() {
		return portFundingType;
	}

	public void setPortFundingType(String portFundingType) {
		this.portFundingType = portFundingType;
	}

	public String getReportedClientType() {
		return reportedClientType;
	}

	public void setReportedClientType(String reportedClientType) {
		this.reportedClientType = reportedClientType;
	}

	public Date getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(Date assignmentStartDate) {
		this.assignmentStartDate = assignmentStartDate;
	}

	public Date getPortTerminationDate() {
		return portTerminationDate;
	}

	public void setPortTerminationDate(Date portTerminationDate) {
		this.portTerminationDate = portTerminationDate;
	}

	public String getPortCurrencyBase() {
		return portCurrencyBase;
	}

	public void setPortCurrencyBase(String portCurrencyBase) {
		this.portCurrencyBase = portCurrencyBase;
	}

	public double getBeginningAum() {
		return beginningAum;
	}

	public void setBeginningAum(double beginningAum) {
		this.beginningAum = beginningAum;
	}

	public double getNetIn() {
		return netIn;
	}

	public void setNetIn(double netIn) {
		this.netIn = netIn;
	}

	public double getNetOut() {
		return netOut;
	}

	public void setNetOut(double netOut) {
		this.netOut = netOut;
	}

	public double getTransferIn() {
		return transferIn;
	}

	public void setTransferIn(double transferIn) {
		this.transferIn = transferIn;
	}

	public double getTransferOut() {
		return transferOut;
	}

	public void setTransferOut(double transferOut) {
		this.transferOut = transferOut;
	}

	public double getNetNewBusiness() {
		return netNewBusiness;
	}

	public void setNetNewBusiness(double netNewBusiness) {
		this.netNewBusiness = netNewBusiness;
	}

	public double getNetNewBusinessExclTx() {
		return netNewBusinessExclTx;
	}

	public void setNetNewBusinessExclTx(double netNewBusinessExclTx) {
		this.netNewBusinessExclTx = netNewBusinessExclTx;
	}

	public double getLastFridayNetIn() {
		return lastFridayNetIn;
	}

	public void setLastFridayNetIn(double lastFridayNetIn) {
		this.lastFridayNetIn = lastFridayNetIn;
	}

	public double getLastFridayNetOut() {
		return lastFridayNetOut;
	}

	public void setLastFridayNetOut(double lastFridayNetOut) {
		this.lastFridayNetOut = lastFridayNetOut;
	}

	public double getLastFridayTxIn() {
		return lastFridayTxIn;
	}

	public void setLastFridayTxIn(double lastFridayTxIn) {
		this.lastFridayTxIn = lastFridayTxIn;
	}

	public double getLastFridayTxOut() {
		return lastFridayTxOut;
	}

	public void setLastFridayTxOut(double lastFridayTxOut) {
		this.lastFridayTxOut = lastFridayTxOut;
	}

	public double getLastFridayNetNewBus() {
		return lastFridayNetNewBus;
	}

	public void setLastFridayNetNewBus(double lastFridayNetNewBus) {
		this.lastFridayNetNewBus = lastFridayNetNewBus;
	}

	public double getLastFridayNetNewBusExclTx() {
		return lastFridayNetNewBusExclTx;
	}

	public void setLastFridayNetNewBusExclTx(double lastFridayNetNewBusExclTx) {
		this.lastFridayNetNewBusExclTx = lastFridayNetNewBusExclTx;
	}

	public double getWeeklyNetIn() {
		return weeklyNetIn;
	}

	public void setWeeklyNetIn(double weeklyNetIn) {
		this.weeklyNetIn = weeklyNetIn;
	}

	public double getWeeklyNetOut() {
		return weeklyNetOut;
	}

	public void setWeeklyNetOut(double weeklyNetOut) {
		this.weeklyNetOut = weeklyNetOut;
	}

	public double getWeeklyTxIn() {
		return weeklyTxIn;
	}

	public void setWeeklyTxIn(double weeklyTxIn) {
		this.weeklyTxIn = weeklyTxIn;
	}

	public double getWeeklyTxOut() {
		return weeklyTxOut;
	}

	public void setWeeklyTxOut(double weeklyTxOut) {
		this.weeklyTxOut = weeklyTxOut;
	}

	public double getWeeklyNetNewBus() {
		return weeklyNetNewBus;
	}

	public void setWeeklyNetNewBus(double weeklyNetNewBus) {
		this.weeklyNetNewBus = weeklyNetNewBus;
	}

	public double getWeeklyNewBusExclTx() {
		return weeklyNewBusExclTx;
	}

	public void setWeeklyNewBusExclTx(double weeklyNewBusExclTx) {
		this.weeklyNewBusExclTx = weeklyNewBusExclTx;
	}

	public double getWeeklyNewBusExclTxAbs() {
		return weeklyNewBusExclTxAbs;
	}

	public void setWeeklyNewBusExclTxAbs(double weeklyNewBusExclTxAbs) {
		this.weeklyNewBusExclTxAbs = weeklyNewBusExclTxAbs;
	}

	public double getFxMovement() {
		return fxMovement;
	}

	public void setFxMovement(double fxMovement) {
		this.fxMovement = fxMovement;
	}

	public double getPriceMovement() {
		return priceMovement;
	}

	public void setPriceMovement(double priceMovement) {
		this.priceMovement = priceMovement;
	}

	public double getMarket() {
		return market;
	}

	public void setMarket(double market) {
		this.market = market;
	}

	public double getMarketPercent() {
		return marketPercent;
	}

	public void setMarketPercent(double marketPercent) {
		this.marketPercent = marketPercent;
	}

	public double getAcquisitions() {
		return acquisitions;
	}

	public void setAcquisitions(double acquisitions) {
		this.acquisitions = acquisitions;
	}

	public double getDisposals() {
		return disposals;
	}

	public void setDisposals(double disposals) {
		this.disposals = disposals;
	}

	public double getEndingAum() {
		return endingAum;
	}

	public void setEndingAum(double endingAum) {
		this.endingAum = endingAum;
	}

	public double getBeginningDoubleDip() {
		return beginningDoubleDip;
	}

	public void setBeginningDoubleDip(double beginningDoubleDip) {
		this.beginningDoubleDip = beginningDoubleDip;
	}

	public double getDoubleDipAdjustments() {
		return doubleDipAdjustments;
	}

	public void setDoubleDipAdjustments(double doubleDipAdjustments) {
		this.doubleDipAdjustments = doubleDipAdjustments;
	}

	public double getEndingAumDoubleDip() {
		return endingAumDoubleDip;
	}

	public void setEndingAumDoubleDip(double endingAumDoubleDip) {
		this.endingAumDoubleDip = endingAumDoubleDip;
	}

}
