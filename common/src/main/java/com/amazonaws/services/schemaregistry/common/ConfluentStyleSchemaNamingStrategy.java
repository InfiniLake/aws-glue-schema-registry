package com.amazonaws.services.schemaregistry.common;

/**
 * Implements getSchemaName method to make the schema name in the following format:
 * topicname-key for keys of the kafka records
 * and topicname-value for content of the kafka records
 */
public class ConfluentStyleSchemaNamingStrategy extends AWSSchemaNamingStrategyDefaultImpl {

	@Override
	public String getSchemaName(String transportName, Object data) {
		return getSchemaName(transportName);
	}

	@Override
	public String getSchemaName(String transportName,
								Object data,
								boolean isKey) {
		return String.format("%s-%s", transportName, isKey ? "key" : "value");
	}

}