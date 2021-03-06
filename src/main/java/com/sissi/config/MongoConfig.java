package com.sissi.config;

/**
 * @author kim 2013-11-15
 */
public interface MongoConfig extends Config {

	public final static String D_NAME = "D_NAME";

	public final static String C_NAME = "C_NAME";

	public final static String FIELD_TO = "to";

	public final static String FIELD_JID = "jid";

	public final static String FIELD_FROM = "from";

	public final static String FIELD_NICK = "nick";

	public final static String FIELD_TYPE = "type";

	public final static String FIELD_CLASS = "class";

	public final static String FIELD_STATE = "state";

	public final static String FIELD_INDEX = "index";

	public final static String FIELD_COUNT = "count";

	public final static String FIELD_RESULT = "result";

	public final static String FIELD_HIDDEN = "hidden";

	public final static String FIELD_CONFIGS = "configs";

	public final static String FIELD_CREATOR = "creator";

	public final static String FIELD_PRIORITY = "priority";

	public final static String FIELD_ACTIVATE = "activate";

	public final static String FIELD_RESOURCE = "resource";

	public final static String FIELD_USERNAME = "username";

	public final static String FIELD_PASSWORD = "password";

	public final static String FIELD_TIMESTAMP = "timestamp";

	public final static String FIELD_AFFILIATION = "affiliation";

	public final static String FIELD_AFFILIATIONS = "affiliations";

	public MongoConfig clear();

	public MongoCollection collection();
}
