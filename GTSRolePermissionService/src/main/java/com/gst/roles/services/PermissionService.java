package com.gst.roles.services;

import java.util.List;

import com.gst.roles.dto.PermissionDto;

public interface PermissionService {

	PermissionDto createPermission(PermissionDto permissonDto);
	PermissionDto getPermissionById(long gts_permission_id);
	PermissionDto updatePermission(long gts_permission_id, PermissionDto permissonDto);
	PermissionDto deletePermission(long gts_permission_id);
	List<PermissionDto> getAllPermissions(int page, int limit);
	PermissionDto getPermissionByName(String gts_permission_name);
	
}
