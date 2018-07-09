package com.dszy.visualconfig.repo.activity;

import com.dszy.visualconfig.entity.ActConfigEntity;
import com.dszy.visualconfig.entity.ActConfigEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActConfigRepo extends JpaRepository<ActConfigEntity, ActConfigEntityPK>{

}
