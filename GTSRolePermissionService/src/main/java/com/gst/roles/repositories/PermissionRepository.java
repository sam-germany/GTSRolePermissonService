package com.gst.roles.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gst.roles.entity.PermissionEntity;
import com.gst.roles.entity.RoleEntity;

@Repository
public interface PermissionRepository extends PagingAndSortingRepository<PermissionEntity, Long>{

	@Query(value=" select * from gts_permissions where gts_permission_name=:f2" , nativeQuery = true)
	PermissionEntity findByName(@Param ("f2") String gts_permission_name);
}
