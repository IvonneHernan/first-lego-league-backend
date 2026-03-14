package cat.udl.eps.softarch.fll.handler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import cat.udl.eps.softarch.fll.domain.MatchResult;
import cat.udl.eps.softarch.fll.event.MatchResultChangedEvent;

@Component
@RepositoryEventHandler(MatchResult.class)
public class MatchResultEventHandler {

	private final ApplicationEventPublisher eventPublisher;

	public MatchResultEventHandler(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@HandleAfterCreate
	public void handleAfterCreate(MatchResult matchResult) {
		publishEvent(matchResult);
	}

	@HandleAfterSave
	public void handleAfterSave(MatchResult matchResult) {
		publishEvent(matchResult);
	}

	private void publishEvent(MatchResult matchResult) {
		if (matchResult == null || matchResult.getTeam() == null) {
			return;
		}

		MatchResultChangedEvent event = new MatchResultChangedEvent(
				matchResult.getId(),
				matchResult.getTeam().getId(),
				matchResult.getScore()
		);

		eventPublisher.publishEvent(event);
	}
}
