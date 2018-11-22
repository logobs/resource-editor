package com.logo.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.logo.util.OwnerProduct;
import com.logo.util.OwnerProductConverter;
import com.logo.util.ResourceCase;
import com.logo.util.ResourceCaseConverter;
import com.logo.util.ResourceGroup;
import com.logo.util.ResourceState;
import com.logo.util.ResourceStateConverter;
import com.logo.util.ResourceType;
import com.logo.util.ResourceTypeConverter;

@Entity
@Table(name = "RE_RESOURCES", 
	indexes = {@Index(name = "I_RESOURCES_DESC", columnList = "DESCRIPTION,ID", unique = true),
			   @Index(name = "I_RESOURCES_GRP", columnList = "resourcenr,resourcegroup", unique = true)})
@EntityListeners(AuditingEntityListener.class)
public class ReResource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, updatable = false, unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "RESOURCENR")
	private int resourceNr;

	@Column(name = "DESCRIPTION", columnDefinition = "nvarchar(128)")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "RESOURCEGROUP", columnDefinition = "nvarchar(10)")
	private ResourceGroup resourcegroup;

	@Convert(converter = ResourceTypeConverter.class)
	@Column(name = "RESOURCETYPE")
	private ResourceType resourcetype;

	@Convert(converter = ResourceCaseConverter.class)
	@Column(name = "RESOURCECASE")
	private ResourceCase resourcecase;

	@Column(name = "SLIST")
	private int slist;

	@Column(name = "CREATEDBY")
	private int createdby;

	@CreatedDate
	@Type(type = "java.time.LocalDateTime")
	@Column(name = "CREATEDON", columnDefinition = "datetime")
	@DateTimeFormat
	private LocalDateTime createdon;

	@Column(name = "MODIFIEDBY")
	private int modifiedby;

	@LastModifiedDate
	@Type(type = "java.time.LocalDateTime")
	@Column(name = "MODIFIEDON", columnDefinition = "datetime")
	@DateTimeFormat
	private LocalDateTime modifiedon;

	@Type(type = "java.time.LocalDateTime")
	@Column(name = "AUTOMODIFIEDON", columnDefinition = "datetime")
	@DateTimeFormat
	private LocalDateTime automodifiedon;

	@Column(name = "VERSION")
	private int version;

	@Column(name = "REQUESTED")
	private int requested;

	@Convert(converter = ResourceStateConverter.class)
	@Column(name = "ACTIVE")
	private ResourceState active;

	@Convert(converter = OwnerProductConverter.class)
	@Column(name = "OWNERPRODUCT")
	private OwnerProduct ownerproduct;

	@Column(name = "RESOURCECATEGORY")
	private int resourcecategory;

	public final int getResourcenr() {
		return resourceNr;
	}

	public final void setResourcenr(int resourceNr) {
		this.resourceNr = resourceNr;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final ResourceGroup getResourcegroup() {
		return resourcegroup;
	}

	public final void setResourcegroup(ResourceGroup resourcegroup) {
		this.resourcegroup = resourcegroup;
	}

	public final ResourceType getResourcetype() {
		return resourcetype;
	}

	public final void setResourcetype(ResourceType resourcetype) {
		this.resourcetype = resourcetype;
	}

	public final ResourceCase getResourcecase() {
		return resourcecase;
	}

	public final void setResourcecase(ResourceCase resourcecase) {
		this.resourcecase = resourcecase;
	}

	public final int getSlist() {
		return slist;
	}

	public final void setSlist(int slist) {
		this.slist = slist;
	}

	public final int getCreatedby() {
		return createdby;
	}

	public final void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public final LocalDateTime getCreatedon() {
		return createdon;
	}

	public final void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public final int getModifiedby() {
		return modifiedby;
	}

	public final void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public final LocalDateTime getModifiedon() {
		return modifiedon;
	}

	public final void setModifiedon(LocalDateTime modifiedon) {
		this.modifiedon = modifiedon;
	}

	public final LocalDateTime getAutomodifiedon() {
		return automodifiedon;
	}

	public final void setAutomodifiedon(LocalDateTime automodifiedon) {
		this.automodifiedon = automodifiedon;
	}

	public final int getVersion() {
		return version;
	}

	public final void setVersion(int version) {
		this.version = version;
	}

	public final int getRequested() {
		return requested;
	}

	public final void setRequested(int requested) {
		this.requested = requested;
	}

	public final ResourceState getActive() {
		return active;
	}

	public final void setActive(ResourceState active) {
		this.active = active;
	}

	public final OwnerProduct getOwnerproduct() {
		return ownerproduct;
	}

	public final void setOwnerproduct(OwnerProduct ownerproduct) {
		this.ownerproduct = ownerproduct;
	}

	public final int getResourcecategory() {
		return resourcecategory;
	}

	public final void setResourcecategory(int resourcecategory) {
		this.resourcecategory = resourcecategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPersisted() {
		return id != null;
	}

	public ReResource() {
		/* */
	}

	@OneToMany(orphanRemoval = true,fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinColumn(name="resourceref", referencedColumnName="id")
	private List<ReResourceitem> reResourceitems = new ArrayList<>();

	public List<ReResourceitem> getReResourceitem()
	{
		return reResourceitems;
	}
	
	public void setReResourceitems(List<ReResourceitem> reResourceitems) {
		this.reResourceitems = reResourceitems;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
	@JoinTable(name = "re_versionasgs", joinColumns = {
			@JoinColumn(name = "resourceid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "versionid", nullable = false, updatable = true, insertable = true) })
	private Set<ReProjectVersion> reProjectVersion = new HashSet<>(0);

	public Set<ReProjectVersion> getReProjectVersion() {
		return reProjectVersion;
	}

	public void setReProjectVersion(Set<ReProjectVersion> reProjectVersion) {
		this.reProjectVersion = reProjectVersion;
	}	
	
	@PrePersist
	@PreUpdate
	protected void beforeInsertOrUpdate() {
		automodifiedon = LocalDateTime.now();
		modifiedon = LocalDateTime.now();
	}
}
