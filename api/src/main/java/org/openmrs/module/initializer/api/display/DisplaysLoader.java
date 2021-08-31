package org.openmrs.module.initializer.api.display;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.module.initializer.api.CsvParser;
import org.openmrs.module.initializer.api.loaders.BaseCsvLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisplaysLoader extends BaseCsvLoader<BaseOpenmrsObject, DisplaysCsvParser> {
	
	@Override
	public void setDisplaysLoader(DisplaysLoader displaysLoader) {
	}
	
	@Autowired
	public void setParser(DisplaysCsvParser parser) {
		this.parser = parser;
	}
	
	public void setReferenceParser(CsvParser<?, ?> parser) {
		this.parser.setReferenceParser(parser);
	}
	
}
