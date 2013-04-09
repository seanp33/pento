package pento.model;

/**
 * Command indicating desired action to be taken against a {@link Statement}
 */
public enum Command {
    NONE, SAVED, ASSERT, DELETE, UPDATE
}
