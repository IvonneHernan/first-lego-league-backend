/**
 * It doesn't recalculate anything, but it records the change in logs.
 */

package cat.udl.eps.softarch.fll.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import cat.udl.eps.softarch.fll.event.MatchResultChangedEvent;

@Component
public class MatchResultAuditObserver implements MatchResultObserver {

	private static final Logger logger = LoggerFactory.getLogger(MatchResultAuditObserver.class);

	@Override
	@EventListener
	public void onMatchResultChanged(MatchResultChangedEvent event) {
		logger.info("MatchResult changed -> id: {}, teamId: {}, score: {}",
				event.matchResultId(),
				event.teamId(),
				event.score());
	}
}
