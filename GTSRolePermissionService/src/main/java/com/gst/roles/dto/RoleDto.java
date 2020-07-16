package com.gst.roles.dto;

import java.util.List;

import com.gst.roles.entity.PermissionEntity;

public class RoleDto {

	private long gts_role_id;
	private String gts_role_name;
	private String gts_role_description;
	private boolean gts_role_status;
	
	private List<PermissionEntity> permissions;
	
	
	

	public long getGts_role_id() {
		return gts_role_id;
	}
	public void setGts_role_id(long gts_role_id) {
		this.gts_role_id = gts_role_id;
	}
	public List<PermissionEntity> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
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
	
	
}
