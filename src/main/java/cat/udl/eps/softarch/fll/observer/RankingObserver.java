//Observer that recalculates the ranking every time a match result is updated.

package cat.udl.eps.softarch.fll.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import cat.udl.eps.softarch.fll.event.MatchResultChangedEvent;
import cat.udl.eps.softarch.fll.service.RankingService;

@Component
public class RankingObserver implements MatchResultObserver {

	private final RankingService rankingService;

	public RankingObserver(RankingService rankingService) {
		this.rankingService = rankingService;
	}

	@Override
	@EventListener
	public void onMatchResultChanged(MatchResultChangedEvent event) {
		rankingService.recalculateRanking();
	}
}
