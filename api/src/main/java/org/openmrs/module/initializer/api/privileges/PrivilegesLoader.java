package org.openmrs.module.initializer.api.privileges;

import java.io.File;

import org.openmrs.Privilege;
import org.openmrs.module.initializer.api.loaders.BaseCsvLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrivilegesLoader extends BaseCsvLoader<Privilege, PrivilegesCsvParser> {
	
	@Autowired
	public void setParser(PrivilegesCsvParser parser) {
		this.parser = parser;
	}
	
	/**
	 * Privilege is without UUID and hence DisplaysLoader would log an error.
	 */
	@Override
	protected File preload(File file) {
		return file;
	}
}
