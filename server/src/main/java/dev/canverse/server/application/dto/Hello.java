package dev.canverse.server.application.dto;

import org.hibernate.validator.constraints.Length;

public final class Hello {
    public record Request(@Length(min = 3) String name) {
    }

    public record Response(String message) {
    }
}
