package cat.udl.eps.softarch.fll.event;

/**
 * Event published when a MatchResult is created or updated.
 */
public record MatchResultChangedEvent(Long matchResultId, String teamId, Integer score) {
}
