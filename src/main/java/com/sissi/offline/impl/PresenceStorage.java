package com.sissi.offline.impl;

import java.util.Map;

import com.sissi.context.JID.JIDBuilder;
import com.sissi.protocol.Delay;
import com.sissi.protocol.Element;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.Presence.Type;

/**
 * @author kim 2013-11-15
 */
public class PresenceStorage extends ProtocolStorage {

	public PresenceStorage(String hit, JIDBuilder jidBuilder) {
		super(hit, jidBuilder);
	}

	@Override
	public Map<String, Object> write(Element element) {
		return super.based(Presence.class.cast(element));
	}

	@Override
	public Element read(Map<String, Object> storage) {
		Presence presence = (Presence) super.based(storage, new Presence());
		presence.setDelay(new Delay(super.hit, presence.getFrom(), storage.get("delay").toString()));
		return presence;
	}

	public Boolean isSupport(Element element) {
		return Presence.class.isAssignableFrom(element.getClass()) && this.isNotStatus(element);
	}

	@Override
	public Boolean isSupport(Map<String, Object> storage) {
		return Presence.class.getSimpleName().equals(storage.get("class"));
	}

	private boolean isNotStatus(Element element) {
		Type type = Presence.Type.parse(element.getType());
		return type != Presence.Type.ONLINE && type != Presence.Type.UNAVAILABLE;
	}
}
