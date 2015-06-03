package com.generated.code.repository;

import com.edgar.core.jdbc.BaseMapper;
import org.springframework.stereotype.Repository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.generated.code.repository.db.CompanyConfigDB;
import com.generated.code.domain.CompanyConfig;
import org.springframework.jdbc.core.RowMapper;
import com.edgar.core.jdbc.RowUnmapper;

/**
 * This class is generated by Spring Data Jdbc code generator.
 *
 * @author Spring Data Jdbc Code Generator
 */
@Repository
public interface CompanyConfigMapper extends BaseMapper<CompanyConfig, Integer>
{

	final static Logger logger = LoggerFactory.getLogger (CompanyConfigMapper.class);

	/* START Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/

	/* END Do not remove/edit this line. CodeGenerator will preserve any code between start and end tags.*/

}
