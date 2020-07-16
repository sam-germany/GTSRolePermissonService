package com.gst.roles.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gst.roles.entity.RoleEntity;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, Long>{

	@Query(value=" select * from gts_roles where gts_role_name=:f2" , nativeQuery = true)
	RoleEntity findByName(@Param ("f2") String gts_role_name);
}
