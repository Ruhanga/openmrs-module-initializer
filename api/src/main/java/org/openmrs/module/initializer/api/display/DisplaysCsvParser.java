package org.openmrs.module.initializer.api.display;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.module.initializer.Domain;
import org.openmrs.module.initializer.api.BaseLineProcessor;
import org.openmrs.module.initializer.api.CsvLine;
import org.openmrs.module.initializer.api.CsvParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisplaysCsvParser extends CsvParser<BaseOpenmrsObject, BaseLineProcessor<BaseOpenmrsObject>> {
	
	private CsvParser<?, ?> referenceParser;
	
	public void setReferenceParser(CsvParser<?, ?> parser) {
		this.referenceParser = parser;
	}
	
	@Autowired
	public DisplaysCsvParser(DisplayLineProcessor baseProcessor) {
		super(baseProcessor);
	}
	
	@Override
	public Domain getDomain() {
		return Domain.DISPLAYS;
	}
	
	/**
	 * In case no UUID can be read from the CSV line this will bootstrap into an object without UUID.
	 * This will result in an error
	 */
	@Override
	public BaseOpenmrsObject bootstrap(CsvLine line) throws IllegalArgumentException {
		return isBlank(line.getUuid()) ? null : (BaseOpenmrsObject) referenceParser.bootstrap(line);
	}
	
	@Override
	public BaseOpenmrsObject save(BaseOpenmrsObject instance) {
		return instance;
	}
	
}
