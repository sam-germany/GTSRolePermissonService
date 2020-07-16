package com.gst.roles.services;

import java.util.List;

import com.gst.roles.dto.RoleDto;

public interface RoleService {

	RoleDto createRole(RoleDto roleDto);
	RoleDto getRoleById(long gts_role_id);
	RoleDto updateRoleById(long gts_role_id, RoleDto roleDto);
	RoleDto deleteRoleById(long gts_role_id);
	List<RoleDto> getAllRoles(int page, int limit);
	RoleDto getRoleByName(String gts_role_name);
	
	
	
	
	
}
