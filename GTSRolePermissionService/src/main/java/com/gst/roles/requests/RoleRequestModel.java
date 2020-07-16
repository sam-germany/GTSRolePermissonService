package com.gst.roles.requests;

import java.util.List;

public class RoleRequestModel {

	private String gts_role_name;
	private String gts_role_description;
	private boolean gts_role_status;
	
	private List<PermissionRequestModel> permissions;

	
	
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

	public List<PermissionRequestModel> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionRequestModel> permissions) {
		this.permissions = permissions;
	}
	
	
	
	
	
}
