package MVI.view;

import MVI.model.ViewState;

/**
 * BaseView - базовый интерфейс для всех видов.
 */
public interface BaseView {
    void render(ViewState state);
}
