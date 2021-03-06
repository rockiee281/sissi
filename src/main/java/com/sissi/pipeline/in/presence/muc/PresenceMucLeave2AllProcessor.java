package com.sissi.pipeline.in.presence.muc;

import com.sissi.context.JID;
import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.muc.Item;
import com.sissi.protocol.muc.XUser;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.PresenceType;
import com.sissi.ucenter.Relation;
import com.sissi.ucenter.muc.MucConfig;
import com.sissi.ucenter.muc.MucConfigBuilder;
import com.sissi.ucenter.muc.MucStatusJudger;
import com.sissi.ucenter.muc.RelationMuc;

/**
 * @author kim 2014年2月11日
 */
public class PresenceMucLeave2AllProcessor extends ProxyProcessor {

	private final MucConfigBuilder mucConfigBuilder;

	private final MucStatusJudger mucStatusJudger;

	public PresenceMucLeave2AllProcessor(MucConfigBuilder mucConfigBuilder, MucStatusJudger mucStatusJudger) {
		super();
		this.mucConfigBuilder = mucConfigBuilder;
		this.mucStatusJudger = mucStatusJudger;
	}

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		Presence presence = new Presence();
		JID group = super.build(protocol.getTo());
		MucConfig config = this.mucConfigBuilder.build(group);
		RelationMuc relation = super.ourRelation(context.jid(), group).cast(RelationMuc.class);
		for (Relation each : super.myRelations(group)) {
			JID to = super.build(each.cast(RelationMuc.class).jid());
			super.findOne(to, true).write(presence.clear().add(this.mucStatusJudger.judege(new XUser(to, config.allowed(to, MucConfig.HIDDEN_NATIVE, null)).setItem(new Item(config.allowed(to, MucConfig.HIDDEN_COMPUTER, context.jid()), relation, this.mucConfigBuilder.build(group)))).cast(XUser.class)).setType(PresenceType.UNAVAILABLE).setFrom(protocol.getTo()));
		}
		return true;
	}
}
