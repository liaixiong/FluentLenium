package org.fluentlenium.core.filter.matcher;

import java.util.regex.Pattern;

/**
 * Matcher checking that actual contains input value.
 */
public class ContainsMatcher extends AbstractMatcher {

    /**
     * Creates a contains matcher.
     *
     * @param value input value
     */
    public ContainsMatcher(final String value) {
        super(value);
    }

    /**
     * Creates a contains matcher.
     *
     * @param value input value
     */
    public ContainsMatcher(final Pattern value) {
        super(value);
    }

    @Override
    public MatcherType getMatcherType() {
        return MatcherType.CONTAINS;
    }

    @Override
    public boolean isSatisfiedBy(final String obj) {
        return CalculateService.contains(getPattern(), getValue(), obj);
    }

}
