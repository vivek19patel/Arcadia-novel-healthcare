package org.o2.svc.client;

public class RegisterServiceClientReq {
	
	private String cardNumber;
    private String cvvNumber;
    private String expiryDate;
    private String nameOnCard;
    private long mobileNumber;
    private String accNum;
    private long mobileNum;
    
    //generate setter() and getter()
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterServiceClientReq [cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvvNumber=");
		builder.append(cvvNumber);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", accNum=");
		builder.append(accNum);
		builder.append(", mobileNum=");
		builder.append(mobileNum);
		builder.append("]");
		return builder.toString();
	}
	
	
}
