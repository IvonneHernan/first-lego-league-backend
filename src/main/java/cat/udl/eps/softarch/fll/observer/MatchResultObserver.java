/**
 * This is the Observer interface, so that it is crystal clear in the project that you are applying the pattern.
 */

package cat.udl.eps.softarch.fll.observer;

import cat.udl.eps.softarch.fll.event.MatchResultChangedEvent;

public interface MatchResultObserver {
	void onMatchResultChanged(MatchResultChangedEvent event);
}
