package com.emolog.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@GeneratedValue(generator="uuid4")
	@GenericGenerator(name="uuid4", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name="user_id", nullable=false)
	private UUID userId;
	
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="pw", nullable=false)
	private String pw;
	@Column(name="pw_2nd", nullable=false)
	private String pw2nd = null;
	@Column(name="login_type", nullable=false)
	private String loginType;
	@Column(name="platform", nullable=false)
	private String platform;
	@Column(name="verified", nullable=false)
	private boolean verified = false;
	@Column(name="forgot_pw", nullable=false)
	private boolean forgotPw = false;
	@Column(name="fcm_token")
	private String fcmToken = null;
	@Column(name="push_agree_yn")
	private String pushAgreeYn = null;
	@Column(name="marketing_agree_yn")
	private String marketingAgreeYn = null;
	@Column(name="active", nullable=false)
	private boolean active = true;
	
	public UserEntity() {
		super();
	}
	
	@Autowired
	public UserEntity(String name, String email, String pw, String pw_2nd, String login_type,
			String platform, boolean verified, boolean forgot_pw, String fcm_token,
			String push_agree_yn, String marketing_agree_yn, boolean active) {
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.pw2nd = pw_2nd;
		this.loginType = login_type;
		this.platform = platform;
		this.verified = verified;
		this.forgotPw = forgot_pw;
		this.fcmToken = fcm_token;
		this.pushAgreeYn = push_agree_yn;
		this.marketingAgreeYn = marketing_agree_yn;
		this.active = active;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw2nd() {
		return pw2nd;
	}

	public void setPw2nd(String pw2nd) {
		this.pw2nd = pw2nd;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isForgotPw() {
		return forgotPw;
	}

	public void setForgotPw(boolean forgotPw) {
		this.forgotPw = forgotPw;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getPushAgreeYn() {
		return pushAgreeYn;
	}

	public void setPushAgreeYn(String pushAgreeYn) {
		this.pushAgreeYn = pushAgreeYn;
	}

	public String getMarketingAgreeYn() {
		return marketingAgreeYn;
	}

	public void setMarketingAgreeYn(String marketingAgreeYn) {
		this.marketingAgreeYn = marketingAgreeYn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
