package null;

import com.edgar.core.repository.Persistable;
import javax.validation.constraints.Null;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.groups.Default;
import com.google.common.base.MoreObjects;

/**
 * This class is generated by Jdbc code generator.
 *
 * @author Jdbc Code Generator
 */
public class Applicant implements Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	@NotNull(groups = {Default.class, Default.class})
	private int applicantId;

	@NotNull(groups = {Default.class, Default.class})
	private int userId;

	@NotEmpty
	@Size(max=8)
	private String fullname = "-";

	@NotNull
	private int gender = 1;

	@NotEmpty
	@Size(max=15)
	private String phone = "-";

	@NotNull
	private int identityType = 1;

	@NotEmpty
	@Size(max=18)
	private String identityNo = "-";

	@NotEmpty
	@Size(max=10)
	private String nation = "1";

	@NotEmpty
	@Size(max=10)
	private String nativePlace = "-";

	@NotNull
	private int degree = 1;

	@NotNull
	private int politics = 0;

	@NotEmpty
	@Size(max=32)
	private String company = "-";

	@NotNull
	private int seniority = 0;

	@NotEmpty
	@Size(max=32)
	private String photoPath = "-";

	@NotNull
	private int studyAddr = 1;

	@NotNull
	private int occupation = 1;

	@NotNull
	private int applicationLevel = 1;

	public Applicant() {

	}

	@Override
	public Integer getId () {
		return this.applicantId;
	}

	@Override
	public void setId(Integer id) {
		this.applicantId = id;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public int getApplicantId() {
		return this.applicantId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getGender() {
		return this.gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setIdentityType(int identityType) {
		this.identityType = identityType;
	}

	public int getIdentityType() {
		return this.identityType;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getIdentityNo() {
		return this.identityNo;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return this.degree;
	}

	public void setPolitics(int politics) {
		this.politics = politics;
	}

	public int getPolitics() {
		return this.politics;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return this.company;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public int getSeniority() {
		return this.seniority;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setStudyAddr(int studyAddr) {
		this.studyAddr = studyAddr;
	}

	public int getStudyAddr() {
		return this.studyAddr;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	public int getOccupation() {
		return this.occupation;
	}

	public void setApplicationLevel(int applicationLevel) {
		this.applicationLevel = applicationLevel;
	}

	public int getApplicationLevel() {
		return this.applicationLevel;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper("Applicant")
			.add("applicantId", applicantId)
			.add("userId", userId)
			.add("fullname", fullname)
			.add("gender", gender)
			.add("phone", phone)
			.add("identityType", identityType)
			.add("identityNo", identityNo)
			.add("nation", nation)
			.add("nativePlace", nativePlace)
			.add("degree", degree)
			.add("politics", politics)
			.add("company", company)
			.add("seniority", seniority)
			.add("photoPath", photoPath)
			.add("studyAddr", studyAddr)
			.add("occupation", occupation)
			.add("applicationLevel", applicationLevel)
			.toString();
	}

	/* START 写在START和END中间的代码不会被替换*/

	/* END 写在START和END中间的代码不会被替换*/

}