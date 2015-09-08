package com.generated.code.domain;

import com.edgar.core.repository.Persistable;
import javax.validation.constraints.Null;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.groups.Default;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects;

/**
 * This class is generated by Jdbc code generator.
 *
 * @author Jdbc Code Generator
 */
public class StudyHistory implements Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	@NotNull (groups = { Default.class, Default.class })
	private int studyHistoryId;

	private int applicantId;

	private int studyHistorySumId;

	private int courseId;

	@NotNull
	private int studyTime = 0;

	@NotNull
	private int status = 1;

	@Size (max = 128)
	private String courseName = "-";

	private int courseType = 1;

	@Size (max = 140)
	private String description = "-";

	private int courseTime = 0;

	private int occupation = 1;

	private int applicationLevel = 1;

	@Size (max = 8)
	private String fullname;

	private int gender = 1;

	private int identityType = 1;

	@Size (max = 18)
	private String identityNo = "-";


	public StudyHistory () {

	}

	@Override
	public Integer getId () {
		return this.studyHistoryId;
	}

	@Override
	public void setId(Integer id) {
		this.studyHistoryId = id;
	}

	public void setStudyHistoryId (Integer studyHistoryId) {
		this.studyHistoryId = studyHistoryId;
	}

	public Integer getStudyHistoryId () {
		return this.studyHistoryId;
	}

	public void setApplicantId (Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getApplicantId () {
		return this.applicantId;
	}

	public void setStudyHistorySumId (Integer studyHistorySumId) {
		this.studyHistorySumId = studyHistorySumId;
	}

	public Integer getStudyHistorySumId () {
		return this.studyHistorySumId;
	}

	public void setCourseId (Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCourseId () {
		return this.courseId;
	}

	public void setStudyTime (Integer studyTime) {
		this.studyTime = studyTime;
	}

	public Integer getStudyTime () {
		return this.studyTime;
	}

	public void setStatus (Integer status) {
		this.status = status;
	}

	public Integer getStatus () {
		return this.status;
	}

	public void setCourseName (String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName () {
		return this.courseName;
	}

	public void setCourseType (Integer courseType) {
		this.courseType = courseType;
	}

	public Integer getCourseType () {
		return this.courseType;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public String getDescription () {
		return this.description;
	}

	public void setCourseTime (Integer courseTime) {
		this.courseTime = courseTime;
	}

	public Integer getCourseTime () {
		return this.courseTime;
	}

	public void setOccupation (Integer occupation) {
		this.occupation = occupation;
	}

	public Integer getOccupation () {
		return this.occupation;
	}

	public void setApplicationLevel (Integer applicationLevel) {
		this.applicationLevel = applicationLevel;
	}

	public Integer getApplicationLevel () {
		return this.applicationLevel;
	}

	public void setFullname (String fullname) {
		this.fullname = fullname;
	}

	public String getFullname () {
		return this.fullname;
	}

	public void setGender (Integer gender) {
		this.gender = gender;
	}

	public Integer getGender () {
		return this.gender;
	}

	public void setIdentityType (Integer identityType) {
		this.identityType = identityType;
	}

	public Integer getIdentityType () {
		return this.identityType;
	}

	public void setIdentityNo (String identityNo) {
		this.identityNo = identityNo;
	}

	public String getIdentityNo () {
		return this.identityNo;
	}

	@Override
	public String toString () {
		return MoreObjects.toStringHelper("StudyHistory")
			.add("studyHistoryId", studyHistoryId)
			.add("applicantId", applicantId)
			.add("studyHistorySumId", studyHistorySumId)
			.add("courseId", courseId)
			.add("studyTime", studyTime)
			.add("status", status)
			.add("courseName", courseName)
			.add("courseType", courseType)
			.add("description", description)
			.add("courseTime", courseTime)
			.add("occupation", occupation)
			.add("applicationLevel", applicationLevel)
			.add("fullname", fullname)
			.add("gender", gender)
			.add("identityType", identityType)
			.add("identityNo", identityNo)
			.toString();
	}

	/* START 写在START和END中间的代码不会被替换*/

	/* END д��START��END�м�Ĵ��벻�ᱻ�滻*/

}