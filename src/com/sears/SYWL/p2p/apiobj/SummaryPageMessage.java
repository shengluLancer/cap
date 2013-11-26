package com.sears.SYWL.p2p.apiobj;

public class SummaryPageMessage implements IJSONable {
	SummaryPageMessage summaryPageMessage;
	public SummaryPageMessage(SummaryPageMessage summaryPageMessage) {
		this.summaryPageMessage=summaryPageMessage;
	}

	@Override
	public String toJSON() {
		return JsonWrapper.wrap(this, "SummaryPage");
	}

}
