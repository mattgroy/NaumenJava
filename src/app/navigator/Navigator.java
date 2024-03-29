package app.navigator;

/**
 * Интерфейс поиска маршрутов в городе Мачу-Пикчу
 */
public interface Navigator
{
    /**
     * Поиск кратчайшего маршрута на карте города между двумя точками
     * @param map карта города
     * @return карта города с построенным маршрутом
     */
    char[][] searchRoute(char[][] map);
}
