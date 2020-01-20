package mine.vo;


public class Contract {
	//正好是数据库里面创建的8个对象，并在这里设置他们的get和set方法，等待着被封装
	private String id;
	private String branchorg;
	private String objectname;
	private String contracttype;
	private String otherside;
	private String ispartition;
	private Double contractsum;
	private String signdate;
	private String workdatefrom;
	private String workdateto;
	private String approvedate;
	private String issave;
	private String bidstate;
	private String isover;
	private Double oversum;
	private String remark;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the branchorg
	 */
	public String getBranchorg() {
		return branchorg;
	}


	/**
	 * @param branchorg the branchorg to set
	 */
	public void setBranchorg(String branchorg) {
		this.branchorg = branchorg;
	}


	/**
	 * @return the objectname
	 */
	public String getObjectname() {
		return objectname;
	}


	/**
	 * @param objectname the objectname to set
	 */
	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}


	/**
	 * @return the contracttype
	 */
	public String getContracttype() {
		return contracttype;
	}


	/**
	 * @param contracttype the contracttype to set
	 */
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}


	/**
	 * @return the otherside
	 */
	public String getOtherside() {
		return otherside;
	}


	/**
	 * @param otherside the otherside to set
	 */
	public void setOtherside(String otherside) {
		this.otherside = otherside;
	}


	/**
	 * @return the ispartition
	 */
	public String getIspartition() {
		return ispartition;
	}


	/**
	 * @param ispartition the ispartition to set
	 */
	public void setIspartition(String ispartition) {
		this.ispartition = ispartition;
	}


	/**
	 * @return the contractsum
	 */
	public Double getContractsum() {
		return contractsum;
	}


	/**
	 * @param contractsum the contractsum to set
	 */
	public void setContractsum(Double contractsum) {
		this.contractsum = contractsum;
	}


	/**
	 * @return the signdate
	 */
	public String getSigndate() {
		return signdate;
	}


	/**
	 * @param signdate the signdate to set
	 */
	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}


	/**
	 * @return the workdatefrom
	 */
	public String getWorkdatefrom() {
		return workdatefrom;
	}


	/**
	 * @param workdatefrom the workdatefrom to set
	 */
	public void setWorkdatefrom(String workdatefrom) {
		this.workdatefrom = workdatefrom;
	}


	/**
	 * @return the workdateto
	 */
	public String getWorkdateto() {
		return workdateto;
	}


	/**
	 * @param workdateto the workdateto to set
	 */
	public void setWorkdateto(String workdateto) {
		this.workdateto = workdateto;
	}


	/**
	 * @return the approvedate
	 */
	public String getApprovedate() {
		return approvedate;
	}


	/**
	 * @param approvedate the approvedate to set
	 */
	public void setApprovedate(String approvedate) {
		this.approvedate = approvedate;
	}


	/**
	 * @return the issave
	 */
	public String getIssave() {
		return issave;
	}


	/**
	 * @param issave the issave to set
	 */
	public void setIssave(String issave) {
		this.issave = issave;
	}


	/**
	 * @return the bidstate
	 */
	public String getBidstate() {
		return bidstate;
	}


	/**
	 * @param bidstate the bidstate to set
	 */
	public void setBidstate(String bidstate) {
		this.bidstate = bidstate;
	}


	/**
	 * @return the isover
	 */
	public String getIsover() {
		return isover;
	}


	/**
	 * @param isover the isover to set
	 */
	public void setIsover(String isover) {
		this.isover = isover;
	}


	/**
	 * @return the oversum
	 */
	public Double getOversum() {
		return oversum;
	}


	/**
	 * @param oversum the oversum to set
	 */
	public void setOversum(Double oversum) {
		this.oversum = oversum;
	}


	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}


	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contract [id=" + id + ", branchorg=" + branchorg
				+ ", objectname=" + objectname + ", contracttype="
				+ contracttype + ", otherside=" + otherside + ", ispartition="
				+ ispartition + ", contractsum=" + contractsum + ", signdate="
				+ signdate + ", workdatefrom=" + workdatefrom + ", workdateto="
				+ workdateto + ", approvedate=" + approvedate + ", issave="
				+ issave + ", bidstate=" + bidstate + ", isover=" + isover
				+ ", oversum=" + oversum + ", remark=" + remark + "]";
	}
	
}









