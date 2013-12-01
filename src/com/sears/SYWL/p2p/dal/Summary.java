package com.sears.SYWL.p2p.dal;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TB_SUMMARY")
public class Summary {
	
	@Id
	@GeneratedValue
	@Column(name="SUMMARY_ID")
	private int summaryId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name="TB_SUMMARY_USER", 
			   joinColumns = @JoinColumn(name="SUMMARY_ID"),
			   inverseJoinColumns = @JoinColumn(name="USER_ID"))
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="TB_SUMMARY_ENTRY", 
               joinColumns={@JoinColumn(name="SUMMARY_ID")}, 
               inverseJoinColumns={@JoinColumn(name="ENTRY_ID")})
	private Set<SummaryEntry> entryList;
	
	@Column(name="SUBMIT_DATE")
	private long submittedDate;
	
	public int getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(int summaryId) {
		this.summaryId = summaryId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<SummaryEntry> getEntryList() {
		return entryList;
	}
	public void setEntryList(Set<SummaryEntry> entryList) {
		this.entryList = entryList;
	}
	public long getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(long submittedDate) {
		this.submittedDate = submittedDate;
	}
	
}
