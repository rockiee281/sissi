package com.sissi.protocol.iq.bind;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sissi.protocol.Protocol;
import com.sissi.read.Collector;
import com.sissi.read.Metadata;

/**
 * @author Kim.shen 2013-10-20
 */
@Metadata(uri = Bind.XMLNS, localName = Bind.NAME)
@XmlType(namespace = Bind.XMLNS)
@XmlRootElement
public class Bind extends Protocol implements Collector {

	public final static String XMLNS = "urn:ietf:params:xml:ns:xmpp-bind";

	public final static String NAME = "bind";

	private String jid;

	private Resource resource;

	public Bind() {
		super();
	}

	public Bind(String resource) {
		super();
		this.resource = new Resource(resource);
	}

	@XmlElement
	public String getJid() {
		return this.jid;
	}

	public Bind setJid(String jid) {
		this.jid = jid;
		return this;
	}
	
	public Bind setResource(String resourc){
		return this;
	}

	@XmlElement
	public Resource getResource() {
		return this.resource;
	}

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	public boolean hasResource() {
		return this.resource != null && this.resource.hasResource();
	}

	public Bind clear() {
		super.clear();
		this.jid = null;
		this.resource = null;
		return this;
	}

	@Override
	public void set(String localName, Object ob) {
		this.resource = Resource.class.cast(ob);
	}
}
