package com.gst.roles.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="gts_roles")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gts_role_id;
	private String gts_role_name;
	private String gts_role_description;
	private boolean gts_role_status;
	
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="gts_roles_permissions_map" , joinColumns = @JoinColumn(name="gts_role_id", referencedColumnName = "gts_role_id"),
                                           inverseJoinColumns = @JoinColumn(name="gts_permission_id" , referencedColumnName = "gts_permission_id"))
    private Collection<PermissionEntity> permissions;


	
	
	public long getGts_role_id() {
		return gts_role_id;
	}
	public void setGts_role_id(long gts_role_id) {
		this.gts_role_id = gts_role_id;
	}
	public String getGts_role_name() {
		return gts_role_name;
	}
	public void setGts_role_name(String gts_role_name) {
		this.gts_role_name = gts_role_name;
	}
	public String getGts_role_description() {
		return gts_role_description;
	}
	public void setGts_role_description(String gts_role_description) {
		this.gts_role_description = gts_role_description;
	}
	public boolean isGts_role_status() {
		return gts_role_status;
	}
	public void setGts_role_status(boolean gts_role_status) {
		this.gts_role_status = gts_role_status;
	}
	public Collection<PermissionEntity> getPermissions() {
		return permissions;
	}
	public void setPermissions(Collection<PermissionEntity> permissions) {
		this.permissions = permissions;
	}
	
	
	
	
}
