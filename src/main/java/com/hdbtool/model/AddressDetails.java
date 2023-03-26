package com.hdbtool.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "address_details")
@EntityListeners(AuditingEntityListener.class)
public class AddressDetails extends Auditable<String> {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@OneToOne
	@JoinColumn(name = "buyerId")
	private Buyer buyerId;

	@OneToOne
	@JoinColumn(name = "userTypeId")
	private UserType userTypeId;

	@OneToOne
	@JoinColumn(name = "sellerId")
	private Seller sellerId;

	private String addressLine1;
	private String addressLine2;
	private String country;
	private String city;
	private Integer homePhoneNumber;
	private String addressType;
	private Integer pinCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Buyer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}

	public UserType getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(UserType userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Seller getSellerId() {
		return sellerId;
	}

	public void setSellerId(Seller sellerId) {
		this.sellerId = sellerId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(Integer homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

}
